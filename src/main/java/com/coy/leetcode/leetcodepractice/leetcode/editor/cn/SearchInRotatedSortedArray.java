/**
 * 搜索旋转排序数组
 */
//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -104 <= nums[i] <= 104 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -104 <= target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 2432 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Medium;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.solution.BeHelped;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.BinarySearch;

/**
 * 33
 */
@BinarySearch
@Medium
@BeHelped
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        solution.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int len = nums.length;
            if (len == 0) {
                return -1;
            }
            if (len == 1) {
                return nums[0] == target ? 0 : -1;
            }

            // 第一次「二分」：找旋转点
            // 由于第一段满足 >=nums[0]，第二段不满足 >=nums[0]，当使用 >=nums[0] 进行二分，
            // 二分出的是满足此性质的最后一个数
            int left = 0, right = len - 1;
            while (left < right) {
                int mid = left + right + 1 >> 1;
                if (nums[mid] >= nums[0]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            // 通过和 nums[0] 进行比较，得知 target 是在旋转点的左边还是右边
            if (target >= nums[0]) {
                left = 0;
            } else {
                left = left + 1;
                right = len - 1;
            }
            // 第二次「二分」：找 target
            while (left < right) {
                int mid = left + right + 1 >> 1;
                if (nums[mid] <= target) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            return nums[right] == target ? right : -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}