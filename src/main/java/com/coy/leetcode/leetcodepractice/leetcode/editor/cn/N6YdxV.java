/**
* 查找插入位置
* 
*/
//给定一个排序的整数数组 nums 和一个整数目标值 target ，请在数组中找到 target ，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺
//序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 示例 4: 
//
// 
//输入: nums = [1,3,5,6], target = 0
//输出: 0
// 
//
// 示例 5: 
//
// 
//输入: nums = [1], target = 0
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 为无重复元素的升序排列数组 
// -104 <= target <= 104 
// 
//
// 
//
// 注意：本题与主站 35 题相同： https://leetcode-cn.com/problems/search-insert-position/ 
// Related Topics 数组 二分查找 
// 👍 34 👎 0
	
package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;
/**
* 剑指 Offer II 068
*/
public class N6YdxV {
    public static void main(String[] args) {
        Solution solution = new N6YdxV().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;
        int mid = (right-left)/2 +left;
        while (left <= right) {
            mid = (right-left)/2 +left;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid+1;
            }
        }
        return mid;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}