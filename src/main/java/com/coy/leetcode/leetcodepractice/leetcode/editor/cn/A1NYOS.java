/**
 * 0 和 1 个数相同的子数组
 */
//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2： 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// nums[i] 不是 0 就是 1 
// 
//
// 
//
// 注意：本题与主站 525 题相同： https://leetcode-cn.com/problems/contiguous-array/ 
// Related Topics 数组 哈希表 前缀和 
// 👍 99 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.HashMap;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Array;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.HashTable;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.PrefixSum;

/**
 * 剑指 Offer II 011
 */
@PrefixSum
@Array
@HashTable
public class A1NYOS {
    public static void main(String[] args) {
        Solution solution = new A1NYOS().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxLength(int[] nums) {
            //key:数组下标的子数组之和，value:数组下标
            HashMap<Integer, Integer> sumToIndex = new HashMap<>();
            int maxLength = 0;
            int sum = 0;

            sumToIndex.put(0, -1);
            for (int i = 0; i < nums.length; i++) {
                int value = nums[i]==0?-1:1;
                sum =sum+value;//当前子数组的和
                if (sumToIndex.containsKey(sum)){//之前子数组的和与当前子数组的和相等
                    maxLength = Math.max(maxLength,i - sumToIndex.get(sum));
                }else {
                    sumToIndex.put(sum,i);
                }
            }
            return maxLength;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}