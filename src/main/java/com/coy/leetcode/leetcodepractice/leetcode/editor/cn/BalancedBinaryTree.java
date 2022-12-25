/**
 * 平衡二叉树
 */
//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 1210 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Easy;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.DepthFirstSearch;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.PostOrderTraversal;

/**
 * 110
 */
@Easy
@PostOrderTraversal
@DepthFirstSearch
public class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
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
    class Solution {
        private boolean isBalanced = true;

        public boolean isBalanced(TreeNode root) {
            //实际上是求二叉树高度的一道题
            dfs(root);
            return isBalanced;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int leftTreeHeight = dfs(root.left);
                int rightTreeHeight = dfs(root.right);
                if (Math.abs(leftTreeHeight - rightTreeHeight) > 1) {
                    isBalanced = false;
                }
                return Math.max(leftTreeHeight, rightTreeHeight) + 1;
            }

        }
    }

    class Solution2 {

        public boolean isBalanced(TreeNode root) {
            //实际上是求二叉树高度的一道题
            if (root == null) {
                return true;
            }
            return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left)
                && isBalanced(root.right);
        }

        private int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(depth(root.left), depth(root.right)) + 1;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}