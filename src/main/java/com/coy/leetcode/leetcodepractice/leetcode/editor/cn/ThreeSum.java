/**
* 三数之和
* 
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
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rlt = new ArrayList<>();
        Arrays.sort(nums);
        for (int left = 0; left < nums.length - 2; left++) {
            if (nums[left] > 0) {
                break;
            }
            if (nums[left]==nums[left+1]){
                continue;
            }
            int mid = left+1;
            int right = nums.length-1;
            while (mid < right) {
                int sum = nums[left]+nums[mid]+nums[right];
                if (sum<0){
                    while (mid<right&&nums[mid]==nums[mid+1]){
                        mid++;
                    }
                }else if (sum>0){
                    while (mid<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                }else {
                    rlt.add(new ArrayList<>(Arrays.asList(nums[left],nums[mid],nums[right])));
                    while (mid<right&&nums[mid]==nums[mid+1]){
                        mid++;
                    }
                    while (mid<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                }
            }
        }

        return rlt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}