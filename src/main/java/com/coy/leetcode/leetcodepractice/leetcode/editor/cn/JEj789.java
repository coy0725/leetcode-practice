/**
 * 粉刷房子
 */
//假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。 
//
// 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 cos
//ts 来表示的。 
//
// 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。 
//
// 请计算出粉刷完所有房子最少的花费成本。 
//
// 
//
// 示例 1： 
//
// 
//输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
//输出: 10
//解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
//     最少花费: 2 + 5 + 3 = 10。
// 
//
// 示例 2： 
//
// 
//输入: costs = [[7,6,2]]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// costs.length == n 
// costs[i].length == 3 
// 1 <= n <= 100 
// 1 <= costs[i][j] <= 20 
// 
//
// 
//
// 注意：本题与主站 256 题相同：https://leetcode-cn.com/problems/paint-house/ 
// Related Topics 数组 动态规划 
// 👍 137 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

/**
 * 剑指 Offer II 091
 */
public class JEj789 {
    public static void main(String[] args) {
        Solution solution = new JEj789().new Solution();
        System.out.println(solution.minCost(new int[][] {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 0 红 1 蓝 2 绿
        public int minCost(int[][] costs) {
            if (costs.length == 0) {
                return 0;
            }
            int preUsed = -1;
            int[] dp = new int[costs.length];


            return 0;
        }

        /**
         * 返回成本最小的
         */
        private void dfs(int[][] costs, int[] dp, int i) {
            if (i == 0) {
                dp[i] = doMin(costs[0]);
            } else if (dp[i] < 0) {
                dfs(costs,dp,i-2);

            }
        }

        private int doMin(int[] cost) {
            int min = Math.min(cost[0], cost[1]);
            return Math.min(min, cost[2]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}