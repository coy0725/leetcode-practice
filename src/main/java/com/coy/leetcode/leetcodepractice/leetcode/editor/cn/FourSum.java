/**
 * 四数之和
 */
//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b
//], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 双指针 排序 
// 👍 1463 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Medium;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Sorting;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.TwoPointers;

/**
 * 18
 */
@TwoPointers
@Medium
@Sorting
public class FourSum {
    public static void main(String[] args) {

        Solution2 solution = new FourSum().new Solution2();
        solution.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> rlt = new ArrayList<>();
            int len = nums.length;
            if (len < 4) {
                return rlt;
            }
            //step1 :将数组排序
            Arrays.sort(nums);

            //step2 :固定两个数字,使用双指针
            for (int i = 0; i < nums.length - 3; i++) {
                if (nums[i] + nums[i + 1] > target) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int left = i + 2;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[i + 1] + nums[left] + nums[right];
                    if (sum == target) {
                        rlt.add(new ArrayList<>(Arrays.asList(nums[i],
                            nums[i + 1], nums[left], nums[right])));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return rlt;
        }

    }

    class Solution2 {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> rlt = new ArrayList<>();
            int len = nums.length;
            if (len < 4) {
                return rlt;
            }
            //step1 :将数组排序
            Arrays.sort(nums);

            //step2 :固定两个数字,使用双指针
            for (int i = 0; i < len - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) {
                    break;
                }
                if ((long) nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) {
                    continue;
                }
                for (int j = i + 1; j < len - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }
                    if ((long) nums[i] + nums[j] + nums[len- 1] + nums[len- 2] < target) {
                        continue;
                    }
                    int left = j + 1, right = len - 1;
                    while (left < right) {
                        long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            rlt.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (left < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }
                            left++;
                            right--;
                        } else if (sum < target) {
                            left++;
                        } else {
                            right++;
                        }
                    }
                }

            }
            return rlt;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}