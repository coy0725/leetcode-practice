/**
* 和大于等于 target 的最短子数组
* 
*/
//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 109 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 105 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// 
//
// 注意：本题与主站 209 题相同：https://leetcode-cn.com/problems/minimum-size-subarray-sum/ 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 
// 👍 91 👎 0
	
package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;
/**
* 剑指 Offer II 008
*/
public class TwoVG8Kg {
    public static void main(String[] args) {
        Solution solution = new TwoVG8Kg().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        //移动右指针,做加法
        for (int right = 0 ;right<nums.length;right++){
            sum = sum+ nums[right];
            //移动左指针，做减法
            while (left<=right&&sum>=target){
                minLength=Math.min(minLength,right-left+1);
                sum = sum -nums[left++];
            }
        }
        return minLength==Integer.MAX_VALUE?0:minLength;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}