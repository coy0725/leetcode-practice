/**
 * 多数元素
 */
//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//提示：
//
// 
// n == nums.length 
// 1 <= n <= 5 * 104 
// -109 <= nums[i] <= 109 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// Related Topics 数组 哈希表 分治 计数 排序 
// 👍 1585 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169
 */
public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //hashMap
        public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> numToCount = new HashMap<>();
            for (final int num : nums) {
                numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
            }
            for (final Map.Entry<Integer, Integer> entry : numToCount.entrySet()) {
                if (entry.getValue() > nums.length / 2) {
                    return entry.getKey();
                }
            }
            return -1;
        }

        //排序
        public int majorityElement2(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }

        //摩尔投票法
        public int majorityElement3(int[] nums) {
            int candidate_num = nums[0], count = 1;
            for (int i = 0; i < nums.length; i++) {
                if (candidate_num == nums[i]) {
                    count++;
                } else if (--count == 0) {//更换候选人
                    candidate_num = nums[i];
                    count = 1;
                }
            }
            return candidate_num;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}