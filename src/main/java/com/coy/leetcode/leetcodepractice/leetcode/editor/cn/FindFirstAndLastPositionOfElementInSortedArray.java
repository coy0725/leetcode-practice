/**
 * 在排序数组中查找元素的第一个和最后一个位置
 */
//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 2069 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.solution.BeHelped;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.BinarySearch;

/**
 * 34
 */
@BeHelped
@BinarySearch
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        System.out.println(solution.searchRange(new int[] {1, 3, 5, 6
        }, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            //想法1 通过二分查找先找到目标位置，没有就直接返回，
            // 有就往左右搜索到第一个不等于target值的位置，但是因为有重复值，这个也不能算是log n

            //第一个大于等于target值的位置 leftIndex
            int leftIndex = binarySearchGraterOrEqual(nums, target);
            //第一个大于target值的位置-1
            int rightIndex = binarySearchGrater(nums, target) - 1;
            if (leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == target
                && nums[rightIndex] == target) {
                return new int[] {leftIndex, rightIndex};
            }

            return new int[] {-1, -1};
        }

        /**
         * 第一个大于目标值的索引位置
         */
        private int binarySearchGrater(int[] nums, int target) {
            int left = 0, right = nums.length - 1, ans = nums.length;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                    ans = mid;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }

        /* 第一个大于等于目标值的索引位置
         */
        private int binarySearchGraterOrEqual(int[] nums, int target) {
            int left = 0, right = nums.length - 1, ans = nums.length;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    right = mid - 1;
                    ans = mid;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }
    }

    private int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    //leetcode submit region end(Prohibit modification and deletion)

}