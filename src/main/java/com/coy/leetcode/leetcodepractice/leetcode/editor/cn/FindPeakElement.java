/**
 * 寻找峰值
 */
//峰值元素是指其值严格大于左右相邻值的元素。 
//
// 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。 
//
// 你可以假设 nums[-1] = nums[n] = -∞ 。 
//
// 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1]
//输出：2
//解释：3 是峰值元素，你的函数应该返回其索引 2。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,1,3,5,6,4]
//输出：1 或 5 
//解释：你的函数可以返回索引 1，其峰值元素为 2；
//     或者返回索引 5， 其峰值元素为 6。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// -231 <= nums[i] <= 231 - 1 
// 对于所有有效的 i 都有 nums[i] != nums[i + 1] 
// 
// Related Topics 数组 二分查找 
// 👍 941 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Medium;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.solution.BeHelped;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.BinarySearch;

/**
 * 162
 */
@BeHelped
@BinarySearch
@Medium
public class FindPeakElement {
    public static void main(String[] args) {
        Solution solution = new FindPeakElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 通过本题，我们可以对「二分」有进一步的认识。
     *
     * 最早在 33. 搜索旋转排序数组 中，我们强调，二分的本质是「二段性」而非「单调性」，
     * 而经过本题，我们进一步发现「二段性」还能继续细分，不仅仅只有满足 01 特性（满足/不满足）的「二段性」可以使用二分，
     * 满足 1? 特性（一定满足/不一定满足）也可以二分。
     *
     */
    class Solution {
        public int findPeakElement(int[] nums) {
            //始终选择大于边界一端进行二分，可以确保选择的区间一定存在峰值，并随着二分过程不断逼近峰值位置
            int n = nums.length;
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = left;
                if (nums[mid] > nums[mid + 1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return right;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}