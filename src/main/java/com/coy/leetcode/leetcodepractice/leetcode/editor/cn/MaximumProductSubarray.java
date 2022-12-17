/**
 * 乘积最大子数组
 */
//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 子数组 是数组的连续子序列。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -10 <= nums[i] <= 10 
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
// 
// Related Topics 数组 动态规划 
// 👍 1870 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

/**
 * 152
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        solution.maxProduct(new int[]{2,3,-2,4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int maxProduct = Integer.MIN_VALUE;
        public int maxProduct(int[] nums) {

            //定义 f[i,j] 为[i,j]之间的乘积

            dfs(nums, 0, nums.length-1);
            System.out.println(maxProduct);
            return maxProduct;
        }

        private int dfs(int[] nums, int i, int j) {
            if (i > nums.length-1 || j < 0) {
                return 1;
            } else {
                int subProduct1 = dfs(nums, i + 1, j);

                int subProduct2 = dfs(nums, i, j - 1);
                int product = nums[i] * subProduct1;
                System.out.println(subProduct1);
                System.out.println(subProduct2);
                System.out.println(product);
                //maxProduct = Math.max(maxProduct, subProduct1);
                //maxProduct = Math.max(maxProduct, subProduct2);
                //maxProduct = Math.max(maxProduct, nums[i]);
                //maxProduct = Math.max(maxProduct, nums[j]);
                //maxProduct = Math.max(maxProduct, nums[i] * subProduct1);
                //maxProduct = Math.max(maxProduct, nums[j] * subProduct2);

                return product;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}