/**
 * 环形房屋偷盗
 */
//一个专业的小偷，计划偷窃一个环形街道上沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同
//时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
//
// 
//
// 注意：本题与主站 213 题相同： https://leetcode-cn.com/problems/house-robber-ii/ 
// Related Topics 数组 动态规划 
// 👍 32 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 剑指 Offer II 090
 */
public class PzWKhm {
    public static void main(String[] args) {
        Solution solution = new PzWKhm().new Solution();
        System.out.println(solution.rob(new int[] {2, 3, 4, 5, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 可以将这个问题分解成两个子问题：一个问题是求小偷从标号为0开始到标号为n-2结束的房屋内能偷得的最多财物数量，
     * 另一个问题是求小偷从标号为1开始到标号为n-1结束的房屋内能偷得的最多财物数量
     */
    class Solution {
        public int rob(int[] nums) {
            if (nums.length ==0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }

            int[] range1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
            int[] range2 = Arrays.copyOfRange(nums, 1, nums.length);

            return Math.max(doRob(range1), doRob(range2));
        }

        public int doRob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int[] dp = new int[2];
            dp[0] = nums[0];
            if (nums.length > 1) {
                dp[1] = Math.max(nums[0], nums[1]);
            }
            for (int i = 2; i < nums.length; i++) {
                dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + nums[i]);

            }
            return Math.max(dp[0], dp[1]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}