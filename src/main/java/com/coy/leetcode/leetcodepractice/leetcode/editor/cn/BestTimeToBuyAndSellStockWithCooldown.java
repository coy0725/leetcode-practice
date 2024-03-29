/**
 * 最佳买卖股票时机含冷冻期
 */
//给定一个整数数组 prices，其中第 prices[i] 表示第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics 数组 动态规划 
// 👍 1373 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.DynamicProgramming;

/**
 * 309
 */
@DynamicProgramming
public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {

            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            if (prices.length > 1) {
                dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
                dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);
            }
            //是不是需要从第三天开始？
            for (int i = 2; i < prices.length; i++) {
                //卖股票只需要关注前一天手上有股票的状态
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                //dp[i - 2][0] - prices[i] 表示买入股票，所以只能需要在前两天手上没有股票的时候进行从操作
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }
            return dp[prices.length - 1][0];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}