/**
 * 节点之和最大的路径
 */
//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给定一个二叉树的根节点 root ，返回其 最大路径和，即所有路径上节点值之和的最大值。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
//
// 
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
//
// 
//
// 注意：本题与主站 124 题相同： https://leetcode-cn.com/problems/binary-tree-maximum-path-s
//um/ 
// Related Topics 树 深度优先搜索 动态规划 二叉树 
// 👍 58 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Hard;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.PostOrderTraversal;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Tree;

/**
 * 剑指 Offer II 051
 */
@Tree
@Hard
@PostOrderTraversal
public class JC7MId {
    public static void main(String[] args) {
        Solution solution = new JC7MId().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        int maxPath = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            dfs(root);
            return maxPath;
        }

        private int dfs(TreeNode root) {
            if (root==null){
                return 0;
            }
            int leftPath = dfs(root.left);
            int rightPath = dfs(root.right);
            if (leftPath < 0) {
                leftPath = 0;
            }
            if (rightPath < 0) {
                rightPath = 0;
            }

            maxPath = Math.max(root.val + leftPath + rightPath,maxPath);
            //为什么是这样的？是一条路径，所以要么选左边要么选右边
            return Math.max(leftPath,rightPath)+root.val;
        }
    }

    class Solution2 {
        int maxPath = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            oneSideMax(root);
            return maxPath;
        }

        private int oneSideMax(TreeNode root) {
            if (root==null){
                return 0;
            }
            int leftPath = Math.max(0,oneSideMax(root.left));
            int rightPath = Math.max(0,oneSideMax(root.right));
            //最后访问根节点，代码的后序遍历
            maxPath = Math.max(root.val + leftPath + rightPath,maxPath);
            //为什么是这样的？是一条路径，所以要么选左边要么选右边
            return Math.max(leftPath,rightPath)+root.val;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}