/**
 * 爬楼梯的最少成本
 */
//数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。 
//
// 每当爬上一个阶梯都要花费对应的体力值，一旦支付了相应的体力值，就可以选择向上爬一个阶梯或者爬两个阶梯。 
//
// 请找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。 
//
// 
//
// 示例 1： 
//
// 
//输入：cost = [10, 15, 20]
//输出：15
//解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
// 
//
// 示例 2： 
//
// 
//输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//输出：6
//解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= cost.length <= 1000 
// 0 <= cost[i] <= 999 
// 
//
// 
//
// 注意：本题与主站 746 题相同： https://leetcode-cn.com/problems/min-cost-climbing-stairs/ 
//
// Related Topics 数组 动态规划 
// 👍 49 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.frequency.ThirdTime;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.DynamicProgramming;

/**
 * 剑指 Offer II 088
 */
@DynamicProgramming
@ThirdTime
public class GzCJIP {
    public static void main(String[] args) {
        Solution2 solution = new GzCJIP().new Solution2();
        System.out.println(solution.minCostClimbingStairs(new int[] {1, 100}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int len = cost.length;
            return Math.min(dfs(cost, len - 2), dfs(cost, len - 1));
        }

        private int dfs(int[] cost, int i) {
            if (i < 2) {
                return cost[i];
            }
            return Math.min(dfs(cost, i - 2), dfs(cost, i - 1));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
    class Solution2 {
        public int minCostClimbingStairs(int[] cost) {

            int len = cost.length;
            int[] dp = new int[len];
            dp[0] = cost[0];
            dfs(cost, len - 1,dp);
            return Math.min(dp[len-2], dp[len-1]);

        }

        private void dfs(int[] cost, int i,int [] dp) {
            if (i < 2) {
                dp[i] = cost[i];
            } else if (dp[i] == 0) {
                dfs(cost, i - 2,dp);
                dfs(cost, i - 1,dp);
                dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
            }


        }
    }

    class Solution3 {
        public int minCostClimbingStairs(int[] cost) {

            int len = cost.length;
            int[] dp = new int[len];
            dp[0] = cost[0];
            dp[1] = cost[1];
            for (int i = 2; i < len; i++) {
                dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
            }
            return Math.min(dp[len-2], dp[len-1]);

        }


    }

    class Solution4 {
        public int minCostClimbingStairs(int[] cost) {

            int len = cost.length;
            int[] dp = new int[] {cost[0], cost[1]};
            for (int i = 2; i < len; i++) {
                dp[i%2] = Math.min(dp[0], dp[1]) + cost[i];
            }
            return Math.min(dp[0], dp[1]);

        }


    }

    /**
     * 带缓存的递归解法
     */
    class Solution5 {
        public int minCostClimbingStairs(int[] cost) {
            int len = cost.length;
            if (len == 0) {
                return 0;
            }
            int[] dp = new int[len];
            dfs(cost, len - 1, dp);
            return dp[len - 1];
        }

        private void dfs(int[] cost, int i, int[] dp) {
            if (i == 0) {
                dp[0] = cost[0];
            } else if (i == 1) {
                dp[1] = Math.max(cost[0], cost[1]);
            } else {
                dfs(cost, i - 1, dp);
                dfs(cost, i - 2, dp);
                dp[i] = Math.min(dp[i - 1], dp[i - 2] + cost[i]);
            }
        }

    }

    class Solution6 {
        public int minCostClimbingStairs(int[] cost) {

            //step1 找出状态转移方程,用一个等式表示其中某一步最优解，与前面若干步最优解的关系
            //f(i) 表示爬上低i级楼梯，i>2。所用的最少体力,有两种方式可以爬到第i级楼梯，从i-2级楼梯，爬两步，从i-1级楼梯爬一步
            //f(i) = min(f(i-1),f(i-2))+cost[i]
            int len = cost.length;
            int[] dp = new int[len] ;
            dp[0] = cost[0];
            dp[1] = cost[1];
            for (int i = 2; i < len; i++) {
                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
            }

            return dp[len - 1];

        }


    }

    class Solution7 {
        public int minCostClimbingStairs(int[] cost) {

            //step1 找出状态转移方程,用一个等式表示其中某一步最优解，与前面若干步最优解的关系
            //f(i) 表示爬上低i级楼梯，i>2。所用的最少体力,有两种方式可以爬到第i级楼梯，从i-2级楼梯，爬两步，从i-1级楼梯爬一步
            //f(i) = min(f(i-1),f(i-2))+cost[i]
            int len = cost.length;
            int[] dp = new int[2] ;
            dp[0] = cost[0];
            dp[1] = cost[1];
            for (int i = 2; i < len; i++) {
                //2 需要替换 dp[0]那次的状态
                dp[i%2] = Math.min(dp[0], dp[1]) + cost[i];
            }

            return Math.min(dp[0],dp[1]);

        }


    }
}