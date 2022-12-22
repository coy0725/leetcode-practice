/**
 * 三数之和
 */
//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k
// ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 5363 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15
 */
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        System.out.println(solution.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> rlt = new ArrayList<>();
            int length = nums.length;
            if (length < 3) {
                return rlt;
            }
            Arrays.sort(nums);
            for (int i = 0; i < length - 2; i++) {
                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        rlt.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
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
                    } else if (sum > 0) {
                        right--;
                    }
                }
            }

            return rlt;
        }
    }

    class Solution2 {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> rlt = new ArrayList<>();
            int length = nums.length;
            if (length < 3) {
                return rlt;
            }
            //step 1：将数组排序
            Arrays.sort(nums);

            //step 2:固定一个数字,使用双指针
            for (int i = 0; i < nums.length; i++) {
                int left = i + 1;
                int right = nums.length - 1;
                int twoSum = 0 - nums[i];

                while (left < right) {
                    if (i > 1 && nums[left] == nums[left - 1]) {
                        continue;
                    }
                    if (nums[left] + nums[right] == twoSum) {
                        rlt.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                    } else if (nums[left] + nums[right] > twoSum) {
                        right--;
                    } else {
                        left++;
                    }
                }

            }

            return rlt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}