/**
 * 二叉树中的最大路径和
 */
//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
//
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 104] 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 
// 👍 1771 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.DepthFirstSearch;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.DynamicProgramming;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Tree;

/**
 * 124
 */
@DepthFirstSearch
@DynamicProgramming
@Tree
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
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
        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            dfs(root);
            return max;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftValue = Math.max(0, dfs(root.left));
            int rightValue = Math.max(0, dfs(root.right));
            max = Math.max(max, leftValue + rightValue + root.val);
            return Math.max(leftValue, rightValue) + root.val;
        }
    }

    class Solution2 {
        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            dfs(root);
            return max;
        }

        /**
         * 返回当前节点能获取到的最大路径和：当前节点+max(左子树路径和,右子树路径和）
         *
         * @param root 树的根节点
         */
        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftPath = Math.max(dfs(root.left), 0);
            int rightPath = Math.max(dfs(root.right), 0);
            //尝试更新最大路径和
            max = Math.max(max, root.val + leftPath + rightPath);
            return root.val + Math.max(leftPath, rightPath);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}