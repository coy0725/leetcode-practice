/**
 * 只出现一次的数字 II
 */
//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。 
//
// 你必须设计并实现线性时间复杂度的算法且不使用额外空间来解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,3,2]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,1,0,1,99]
//输出：99
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -231 <= nums[i] <= 231 - 1 
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 
// 
// Related Topics 位运算 数组 
// 👍 928 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 137
 */
public class SingleNumberIi {
    public static void main(String[] args) {
        Solution solution = new SingleNumberIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //位运算
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int i = 0; i < 32; ++i) {
                int total = 0;
                for (int num : nums) {
                    total += ((num >> i) & 1);
                }
                if (total % 3 != 0) {
                    ans |= (1 << i);
                }
            }
            return ans;
        }
        //hashMap
        public int singleNumber2(int[] nums) {
            HashMap<Integer, Integer> numToCount = new HashMap<>();
            for (final int num : nums) {
                numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
            }
            for (final Map.Entry<Integer, Integer> entry : numToCount.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }
            return -1;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

