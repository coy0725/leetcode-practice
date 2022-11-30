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
        Solution3 solution = new JEj789().new Solution3();
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
                dfs(costs, dp, i - 2);

            }
        }

        private int doMin(int[] cost) {
            int min = Math.min(cost[0], cost[1]);
            return Math.min(min, cost[2]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * 不带缓存的递归解决方案
     */
    class Solution1 {
        // 0 红 1 蓝 2 绿
        public int minCost(int[][] costs) {
            if (costs.length == 0) {
                return 0;
            }

            int min = Math.min(red(costs, costs.length - 1), blue(costs, costs.length - 1));
            return Math.min(min, green(costs, costs.length - 1));
        }

        int red(int[][] costs, int i) {
            if (i == 0) {
                return costs[0][0];
            } else {
                return Math.min(green(costs, i - 1), blue(costs, i - 1)) + costs[i][0];
            }
        }

        int blue(int[][] costs, int i) {
            if (i == 0) {
                return costs[0][1];
            } else {
                return Math.min(red(costs, i - 1), green(costs, i - 1)) + costs[i][1];
            }
        }

        int green(int[][] costs, int i) {
            if (i == 0) {
                return costs[0][2];
            } else {
                return Math.min(red(costs, i - 1), blue(costs, i - 1)) + costs[i][2];
            }
        }

    }

    /**
     * 带缓存的递归解决方案
     */
    class Solution2 {
        // 0 红 1 蓝 2 绿
        public int minCost(int[][] costs) {
            if (costs.length == 0) {
                return 0;
            }
            int[][] dp = new int[costs.length][3];
            int min = Math.min(red(costs, costs.length - 1, dp), blue(costs, costs.length - 1, dp));
            return Math.min(min, green(costs, costs.length - 1, dp));
        }

        int red(int[][] costs, int i, int[][] dp) {
            if (i == 0) {
                dp[i][0] = costs[0][0];
                return dp[i][0];
            }
            if (dp[i][0] != 0) {
                return dp[i][0];
            } else {
                int blue = blue(costs, i - 1, dp);
                int green = green(costs, i - 1, dp);
                dp[i - 1][2] = green;
                dp[i - 1][1] = blue;
                return Math.min(blue, green) + costs[i][0];
            }
        }

        int blue(int[][] costs, int i, int[][] dp) {
            if (i == 0) {
                dp[i][1] = costs[0][1];
                return dp[i][1];
            }
            //缓存过了
            if (dp[i][0] != 0) {
                return dp[i][1];
            } else {
                dp[i - 1][0] = red(costs, i - 1, dp);
                dp[i - 1][2] = green(costs, i - 1, dp);
                return Math.min(dp[i-1][0], dp[i - 1][2])+ costs[i][1];
            }
        }

        int green(int[][] costs, int i, int[][] dp) {
            if (i == 0) {
                dp[i][2] = costs[0][2];
                return dp[i][2];
            }
            if (dp[i][0] != 0) {
                return dp[i][2];
            } else {
                dp[i - 1][0] = red(costs, i - 1, dp);
                dp[i - 1][1] = blue(costs, i - 1, dp);
                return Math.min(dp[i-1][0], dp[i - 1][2]) + costs[i][2];
            }
        }

    }

    class Solution3  {
        // 0 红 1 蓝 2 绿
        public int minCost(int[][] costs) {
            if (costs.length == 0) {
                return 0;
            }
            int[][] dp = new int[3][2];
            for (int j = 0; j < 3; j++) {
                dp[j][0] = costs[0][j];
            }
            for (int i = 0; i < costs.length; i++) {
                for (int j = 0; j < 3; j++) {
                    int prev1 = dp[(j + 2) % 3][(i - 1) % 2];
                    int prev2 = dp[(j + 1) % 3][(i - 1) % 2];
                    dp[j][i % 2] = Math.min(prev1, prev2) + costs[i][j];
                }
            }
            int last = (costs.length - 1) % 2;
            return Math.min(dp[0][last], Math.min(dp[1][last], dp[2][last]));
        }



    }

}