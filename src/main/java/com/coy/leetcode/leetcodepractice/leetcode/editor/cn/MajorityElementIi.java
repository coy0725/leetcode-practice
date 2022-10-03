/**
 * 多数元素 II
 */
//给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：[3] 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2]
//输出：[1,2] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 104 
// -109 <= nums[i] <= 109 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。 
// Related Topics 数组 哈希表 计数 排序 
// 👍 631 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 229
 */
public class MajorityElementIi {
    public static void main(String[] args) {
        Solution solution = new MajorityElementIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //使用hashMap
        public List<Integer> majorityElement(int[] nums) {
            List<Integer> rlt = new ArrayList<>();
            HashMap<Integer, Integer> numToCount = new HashMap<>();
            for (final int num : nums) {
                numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
            }
            for (final Map.Entry<Integer, Integer> entry : numToCount.entrySet()) {
                if (entry.getValue() > nums.length / 3) {
                    rlt.add(entry.getKey());
                }
            }
            return rlt;
        }

        //使用摩尔投票法进行处理
        public List<Integer> majorityElement2(int[] nums) {
            // 创建返回值
            List<Integer> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;
            // 初始化两个候选人candidate，和他们的计票
            int cand1 = nums[0], count1 = 0;
            int cand2 = nums[0], count2 = 0;

            // 摩尔投票法，分为两个阶段：配对阶段和计数阶段
            // 配对阶段
            for (int num : nums) {
                // 投票
                if (cand1 == num) {
                    count1++;
                    continue;
                }
                if (cand2 == num) {
                    count2++;
                    continue;
                }

                // 第1个候选人配对
                if (count1 == 0) {
                    cand1 = num;
                    count1++;
                    continue;
                }
                // 第2个候选人配对
                if (count2 == 0) {
                    cand2 = num;
                    count2++;
                    continue;
                }

                count1--;
                count2--;
            }

            // 计数阶段
            // 找到了两个候选人之后，需要确定票数是否满足大于 N/3
            count1 = 0;
            count2 = 0;
            for (int num : nums) {
                if (cand1 == num) count1++;
                else if (cand2 == num) count2++;
            }

            if (count1 > nums.length / 3) res.add(cand1);
            if (count2 > nums.length / 3) res.add(cand2);

            return res;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}