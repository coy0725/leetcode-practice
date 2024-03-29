/**
 * 房屋偷盗
 */
//一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响小偷偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被
//小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：nums = [2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// 
//
// 注意：本题与主站 198 题相同： https://leetcode-cn.com/problems/house-robber/ 
// Related Topics 数组 动态规划 
// 👍 27 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.Arrays;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.frequency.ThirdTime;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.DynamicProgramming;

/**
 * 剑指 Offer II 089
 */
@DynamicProgramming
@ThirdTime
public class Gu0c2T {
    public static void main(String[] args) {
        Solution3 solution = new Gu0c2T().new Solution3();
        Solution5 solution5 = new Gu0c2T().new Solution5();
        System.out.println(solution.rob(new int[] {2,7,9,3,1}));
        System.out.println(solution5.rob(new int[] {2, 7, 9, 3, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int len = nums.length;
            //每一步在序列中增加一个元素--》for循环？
            int[] dp = new int[] {nums[0], nums[1]};
            for (int i = 2; i < len; ) {

                dp[i%2] = Math.max(dp[0], dp[1]) + nums[i];
                if (dp[0] > dp[1]) {
                    i = i + 1;
                } else {
                    i = i + 2;
                }
            }
            return Math.max(dp[0], dp[1]);
            // f(i) = f(i) + Math.max(f(i-2),f(i-3))
        }
    }

    //带缓存的递归代码
    class Solution1 {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dfs(nums, nums.length - 1, dp);
            return dp[nums.length - 1];
        }

        private void dfs(int[] nums, int i, int[] dp) {
            if (i == 0) {
                dp[i] = nums[0];
            } else if (i == 1) {
                dp[i] = Math.max(nums[0], nums[1]);
            } else if (dp[i] < 0) {
                dfs(nums, i - 2, dp);
                dfs(nums, i - 1, dp);
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
    //空间复杂度为O（n）的迭代代码
    class Solution2 {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            if (nums.length > 1) {
                dp[1] = Math.max(nums[0], nums[1]);
            }
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            return dp[nums.length - 1];
        }



    }

    //空间复杂度为O（1）的迭代代码
    class Solution3 {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int[] dp = new int[2];
            dp[0] = nums[0];
            if (nums.length > 1) {
                dp[1] = Math.max(nums[0], nums[1]);
            }
            for (int i = 2; i < nums.length; i++) {
                dp[i%2] = Math.max(dp[(i-1)%2], dp[(i-2)%2] + nums[i]);

            }
            return Math.max(dp[0], dp[1]);
        }



    }

    //用两个状态转移方程分析解决问题
    class Solution4 {
        public int rob(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return 0;
            }

            //定义两个表达式f（i）和g（i），其中f（i）表示小偷选择不进入标号为i的房屋偷东西时能偷得的最多财物数量，
            // 而g（i）表示小偷选择进入标号为i的房屋偷东西时能偷得的最多财物数量
            int[][] dp = new int[2][2];
            dp[0][0] = nums[0];
            dp[1][0] = 0;

            //“dp[0][i%2]”中用来存放f（i）的计算结果，“dp[1][i%2]”中用来存放g（i）的计算结果
            for (int i = 2; i < len; i++) {
                dp[0][i % 2] = Math.max(dp[0][(i - 1) % 2], dp[1][(i - 1) % 2]);//f(i)
                dp[1][i % 2] = nums[i] + dp[0][(i - 1) % 2];

            }
            return Math.max(dp[0][(len - 1) % 2], dp[1][(len - 1) % 2]);
        }



    }

    class Solution5 {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            int[] dp = new int[nums.length];
            Arrays.fill(dp, -1);
            dfs(nums, nums.length - 1, dp);
            System.out.println(Arrays.toString(dp));
            return dp[nums.length - 1];
        }

        private void dfs(int[] nums, int i, int[] dp) {
            if (i == 0) {
                dp[i] = nums[0];
            } else if (i == 1) {
                dp[i] = Math.max(nums[0], nums[1]);
            } else {
                dfs(nums, i - 2, dp);
                dfs(nums, i - 1, dp);
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }

        }

    }


    class Solution6 {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int[] dp = new int[2];
            dp[0] = nums[0];
            if (nums.length > 1) {
                dp[1] = Math.max(nums[0], nums[1]);
            }
            for (int i = 2; i < nums.length; i++) {
                //i=2 ,偷第0间+第2间，或者偷第1间房

                dp[i%2] = Math.max(dp[(i-1)%2], dp[(i)%2] + nums[i]);

            }
            return Math.max(dp[0], dp[1]);
        }



    }

}