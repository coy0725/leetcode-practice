/**
 * 二叉树最底层最左边的值
 */
//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,104] 
// -231 <= Node.val <= 231 - 1 
// 
//
// 
//
// 注意：本题与主站 513 题相同： https://leetcode-cn.com/problems/find-bottom-left-tree-valu
//e/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 32 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer II 045
 */
public class LwUNpT {
    public static void main(String[] args) {
        Solution solution = new LwUNpT().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            int levelLeftValue = root.val;
            Queue<TreeNode> queue1 = new LinkedList<>();
            Queue<TreeNode> queue2 = new LinkedList<>();
            queue1.offer(root);

            while (queue1.peek() != null) {
                TreeNode node = queue1.poll();
                if (node.left != null) {
                    queue2.offer(node.left);
                }
                if (node.right != null) {
                    queue2.offer(node.right);
                }
                if (queue1.isEmpty()) {
                    if (!queue2.isEmpty()) {
                        levelLeftValue = queue2.peek().val;
                        Queue<TreeNode> temp = queue1;
                        queue1 = queue2;
                        queue2 = temp;

                    }
                }

            }
            return levelLeftValue;

        }
    }

    class Solution2 {
        public int findBottomLeftValue(TreeNode root) {
            int bottomLeftValue = root.val;
            Queue<TreeNode> currentLayer = new LinkedList<>();
            Queue<TreeNode> nextLayer = new LinkedList<>();
            currentLayer.offer(root);

            while (currentLayer.peek() != null) {
                TreeNode node = currentLayer.poll();
                if (node.left != null) {
                    nextLayer.offer(node.left);
                }
                if (node.right != null) {
                    nextLayer.offer(node.right);
                }

                if (currentLayer.isEmpty()) {
                    if (!nextLayer.isEmpty()) {
                        bottomLeftValue = nextLayer.peek().val;
                        Queue<TreeNode> tmp = currentLayer;
                        currentLayer = nextLayer;
                        nextLayer = tmp;
                    }

                }
            }
            return bottomLeftValue;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}