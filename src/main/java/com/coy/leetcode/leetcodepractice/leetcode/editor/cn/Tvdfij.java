/**
 * 左右两边子数组的和相等
 */
//给你一个整数数组 nums ，请计算数组的 中心下标 。 
//
// 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。 
//
// 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。 
//
// 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,7,3,6,5,6]
//输出：3
//解释：
//中心下标是 3 。
//左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
//右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1, 2, 3]
//输出：-1
//解释：
//数组中不存在满足此条件的中心下标。 
//
// 示例 3： 
//
// 
//输入：nums = [2, 1, -1]
//输出：0
//解释：
//中心下标是 0 。
//左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
//右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -1000 <= nums[i] <= 1000 
// 
//
// 
//
// 注意：本题与主站 724 题相同： https://leetcode-cn.com/problems/find-pivot-index/ 
// Related Topics 数组 前缀和 
// 👍 48 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.HashMap;

/**
 * 剑指 Offer II 012
 */
public class Tvdfij {
    public static void main(String[] args) {
        Solution solution = new Tvdfij().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int pivotIndex(int[] nums) {
            //key：index,value:S[0,index]
            HashMap<Integer, Integer> indexToSum = new HashMap<>();
            int sum = 0;
            int pivot = -1;
            for (int i = 0; i < nums.length; i++) {
                sum = sum + nums[i];
                indexToSum.put(i, sum);
            }
            //？左边没有数组怎么说？就是0
            int left;
            int right;
            for (int i = 0; i < nums.length; i++) {
                //i左边子数组的和
                left = indexToSum.getOrDefault(i - 1, 0);
                //i右边子数组的和
                right = indexToSum.get(nums.length) - indexToSum.get(i);
                if (left == right) {
                    pivot = i;
                    break;
                }
            }
            return pivot;
        }

        public int pivotIndex2(int[] nums) {
            int total = 0;
            int left = 0;
            int right;
            int pivot = -1;
            for (final int num : nums) {
                total = total + num;
            }

            for (int i = 0; i < nums.length; i++) {
                right = total - left - nums[i];
                if (left == right) {
                    return i;
                }
                left = left + nums[i];
            }
            return pivot;
        }

        public int pivotIndex3(int[] nums){
            int total = 0;
            int sum = 0;

            for (final int num : nums) {
                total = total + num;
            }
            for (int i = 0; i < nums.length; i++) {
                sum = sum+ nums[i];

                if (sum-nums[i]==total-sum){
                    return i;
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}