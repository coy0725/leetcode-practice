/**
 * 找到所有数组中消失的数字
 */
//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
//字，并以数组的形式返回结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 105 
// 1 <= nums[i] <= n 
// 
//
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。 
// Related Topics 数组 哈希表 
// 👍 1093 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 448
 */
public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> rlt = new ArrayList<>();
            HashMap<Integer, Integer> numToCount = new HashMap<>();
            for (final int num : nums) {
                numToCount
                    .put(num, numToCount.getOrDefault(num, numToCount.getOrDefault(num, 0) + 1));
            }
            for (int i = 1; i <= nums.length; i++) {
                if (!numToCount.containsKey(i)) {
                    rlt.add(i);
                }
            }
            return rlt;
        }

        public List<Integer> findDisappearedNumbers2(int[] nums) {
            List<Integer> rlt = new ArrayList<>();
            int length = nums.length;
            for (final int num : nums) {
                int index = (num - 1) % length;
                nums[index] = nums[index] + length;
            }
            for (int i = 0; i < length; i++) {
                if (nums[i] < length) {
                    rlt.add(i + 1);
                }
            }
            return rlt;
        }

        public List<Integer> findDisappearedNumbers3(int[] nums) {
            int n = nums.length;
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                //把相应的nums中的数对应的-1下标位置，乘以-1 表明这个下标也就是这个数出现过了
                int index = Math.abs(nums[i]) - 1;
                if (nums[index] > 0) {
                    nums[index] = nums[index] * -1;
                }
            }

            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    list.add(i + 1);
                }
            }
            return list;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}