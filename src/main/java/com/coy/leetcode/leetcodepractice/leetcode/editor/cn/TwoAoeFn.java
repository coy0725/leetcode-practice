/**
 * 路径的数目
 */
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 109 
// 
//
// 
//
// 注意：本题与主站 62 题相同： https://leetcode-cn.com/problems/unique-paths/ 
// Related Topics 数学 动态规划 组合数学 
// 👍 36 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.Arrays;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Medium;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.solveDate.February2023;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.DynamicProgramming;

/**
 * 剑指 Offer II 098
 */
@February2023
@Medium
@DynamicProgramming
public class TwoAoeFn {
    public static void main(String[] args) {
        Solution solution = new TwoAoeFn().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] count;
        public int uniquePaths(int m, int n) {
            //f(m,n) = f(m-1,n)+f(m,n-1)
            count = new int[m + 1][n + 1];
            for (final int[] ints : count) {
                Arrays.fill(ints, -1);
            }
            dfs(m, n);
            return count[m][n];
        }

        private int dfs(int m, int n) {
            if (count[m][n] != -1) {
                return count[m][n];
            }
            int rlt;
            if (m == 1 && n == 1) {
                rlt = 0;
            } else if (m == 1 && n > 1) {
                rlt = 1 + dfs(m, n - 1);
            } else if (m > 1 && n == 1) {
                rlt = 1 + dfs(m - 1, n);
            } else {
                rlt = dfs(m - 1, n) + dfs(m, n - 1) + 2;
            }
            count[m][n] = rlt;
            return rlt;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}