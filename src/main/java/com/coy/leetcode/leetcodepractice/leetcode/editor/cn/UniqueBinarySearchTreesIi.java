/**
 * 不同的二叉搜索树 II
 */
//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// 
// 
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 
// 👍 1364 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Medium;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.solveDate.January2023;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.BinarySearchTree;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.DynamicProgramming;

/**
 * 95
 */
@DynamicProgramming
@BinarySearchTree
@Medium
@January2023
public class UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTreesIi().new Solution();
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
        public List<TreeNode> generateTrees(int n) {
            List<TreeNode> rlt = new ArrayList<>();
            if (n == 0) {
                return rlt;
            }
            return build(1, n);

        }

        //函數返回是集合
        private List<TreeNode> build(int lo, int hi) {
            List<TreeNode> rlt = new ArrayList<>();
            if (lo > hi) {
                rlt.add(null);
                return rlt;
            }

            for (int i = lo; i <= hi; i++) {
                List<TreeNode> leftNodes = build(lo, i - 1);
                List<TreeNode> rightNodes = build(i + 1, hi);
                for (final TreeNode leftNode : leftNodes) {
                    for (final TreeNode rightNode : rightNodes) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        rlt.add(root);
                    }
                }

            }

            return rlt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}