/**
 * 至少在两个数组中出现的值
 */
//给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 元素各不相同的 数组，且由 至少 在 两个 数组中出现的所有值组成。数组中的
//元素可以按 任意 顺序排列。
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
//输出：[3,2]
//解释：至少在两个数组中出现的所有值为：
//- 3 ，在全部三个数组中都出现过。
//- 2 ，在数组 nums1 和 nums2 中出现过。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
//输出：[2,3,1]
//解释：至少在两个数组中出现的所有值为：
//- 2 ，在数组 nums2 和 nums3 中出现过。
//- 3 ，在数组 nums1 和 nums2 中出现过。
//- 1 ，在数组 nums1 和 nums3 中出现过。
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
//输出：[]
//解释：不存在至少在两个数组中出现的值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length, nums3.length <= 100 
// 1 <= nums1[i], nums2[j], nums3[k] <= 100 
// 
// Related Topics 数组 哈希表 
// 👍 25 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Easy;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.solveDate.December2022;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.HashTable;

/**
 * 2032
 */
@Easy
@HashTable
@December2022
public class TwoOutOfThree {
    public static void main(String[] args) {
        Solution solution = new TwoOutOfThree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            //是需要使用三个hashMap吗，一个hashMap不好统计，因为如何判断一个元素在两个数组出现过呢？

            HashMap<Integer, Integer> nums1Map = new HashMap<>();
            HashMap<Integer, Integer> nums2Map = new HashMap<>();
            HashMap<Integer, Integer> nums3Map = new HashMap<>();

            //使用三个hashMap统计三个数组中数值出现次数
            for (final int i : nums1) {
                nums1Map.put(i, 1);
            }
            for (final int i : nums2) {
                nums2Map.put(i, 1);
            }
            for (final int i : nums3) {
                nums3Map.put(i, 1);
            }

            Set<Integer> set = new HashSet<>();
            for (final Map.Entry<Integer, Integer> entry : nums1Map.entrySet()) {
                if (nums2Map.containsKey(entry.getKey()) || nums3Map.containsKey(entry.getKey())) {
                    set.add(entry.getKey());
                }
            }
            for (final Map.Entry<Integer, Integer> entry : nums2Map.entrySet()) {
                if (nums1Map.containsKey(entry.getKey()) || nums3Map.containsKey(entry.getKey())) {
                    set.add(entry.getKey());
                }
            }
            return new ArrayList<>(set);

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}