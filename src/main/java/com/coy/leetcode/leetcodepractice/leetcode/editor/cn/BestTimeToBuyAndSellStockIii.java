/**
 * 买卖股票的最佳时机 III
 */
//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//
//
// 示例 1:
//
//
//输入：prices = [3,3,5,0,0,3,1,4]
//输出：6
//解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
//
// 示例 2：
//
//
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
//
//
// 示例 3：
//
//
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
//
// 示例 4：
//
//
//输入：prices = [1]
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= prices.length <= 105
// 0 <= prices[i] <= 105
//
// Related Topics 数组 动态规划
// 👍 1282 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

/**
 * 123
 */
public class BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {

            int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
            int release1 = 0, release2 = 0;
            for (final int price : prices) {
                release2 = Math.max(release2, hold2 + price);   // The maximum if we've just sold 2nd stock so far.
                hold2 = Math.max(hold2, release1 - price);      // The maximum if we've just buy  2nd stock so far.
                release1 = Math.max(release1, hold1 + price);   // The maximum if we've just sold 1nd stock so far.
                hold1 = Math.max(hold1, -price);                // The maximum if we've just buy  1st stock so far.
            }
            return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
        }
    }

    class Solution2 {
        public int maxProfit(int[] prices) {

            int firstBuy = Integer.MIN_VALUE, firstSell = 0;
            int secBuy = Integer.MIN_VALUE, secSell = 0;

            for (final int price : prices) {
                //该天第一次买入获得的最大收益
                firstBuy = Math.max(firstBuy, -price);
                //该第一次卖出获得的最大收益
                firstSell = Math.max(firstSell, firstSell + price);
                //改天第二次买入股票可获得的最大收益
                secBuy = Math.max(secBuy, firstSell - price);
                //该天第二次卖出股票可获得的最大收益
                secSell = Math.max(secSell, secBuy + price);
            }
            return secSell;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}