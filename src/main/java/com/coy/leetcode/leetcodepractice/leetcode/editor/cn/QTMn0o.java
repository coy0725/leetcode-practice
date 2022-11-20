/**
 * 和为 k 的子数组
 */
//给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2
//解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
// 
//
// 示例 2： 
//
// 
//输入:nums = [1,2,3], k = 3
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -1000 <= nums[i] <= 1000 
// 
// -107 <= k <= 107 
// 
// 
//
// 
//
// 注意：本题与主站 560 题相同： https://leetcode-cn.com/problems/subarray-sum-equals-k/ 
// Related Topics 数组 哈希表 前缀和 
// 👍 107 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.HashMap;

/**
 * 剑指 Offer II 010
 */
public class QTMn0o {
    public static void main(String[] args) {
        Solution solution = new QTMn0o().new Solution();
        System.out.println(solution.subarraySum(new int[] {-1, -1, 1}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int preSum = 0;
            int count = 0;
            //key:preSum值，value：等于该preSum值的个数
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int i : nums) {
                preSum += i;
                count += map.getOrDefault(preSum - k, 0);
                map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            }
            return count;
        }

        public int subarraySum2(int[] nums, int k) {
            int preSum = 0;
            int kCount = 0;
            //key:preSum值，value：等于该preSum值的个数
            HashMap<Integer, Integer> preSumCount = new HashMap<>();
            preSumCount.put(0, 1);
            for (final int num : nums) {
                preSum = preSum+ num;
                kCount = kCount +preSumCount.getOrDefault(preSum-k,0);
                preSumCount.put(preSum,preSumCount.getOrDefault(preSum, 0)+1);

            }
            return kCount;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}