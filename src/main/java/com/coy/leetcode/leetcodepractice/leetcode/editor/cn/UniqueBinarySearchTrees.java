/**
 * 不同的二叉搜索树
 */
//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 
// 👍 2047 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Medium;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.solution.BeHelped;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.BinarySearchTree;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.DynamicProgramming;

/**
 * 96
 */
@BinarySearchTree
@Medium
@DynamicProgramming
@BeHelped
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int [][] memo;

        public int numTrees(int n) {
            //计算闭区间[1,n]组成的BST的个数
            memo = new int[n + 1][n + 1];
            //计算闭区间[1,n]组成的BST的个数
            return count(1, n);
        }

        /**
         * 计算闭区间[begin,end]组成的BST的个数
         */
        int count(int begin, int end) {
            if (begin > end) {
                return 1;
            }
            if (memo[begin][end] != 0) {
                return memo[begin][end];
            }
            int res = 0;

            for (int mid = begin; mid <= end; mid++) {
                int leftCount = count(begin, mid - 1);
                int rightCount = count(mid + 1, end);
                res = res + leftCount * rightCount;
            }
            memo[begin][end] = res;
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}