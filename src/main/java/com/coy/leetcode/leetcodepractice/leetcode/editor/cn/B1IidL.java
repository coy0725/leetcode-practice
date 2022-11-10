/**
* 山峰数组的顶部
* 
*/
//符合下列属性的数组 arr 称为 山峰数组（山脉数组） ： 
//
// 
// arr.length >= 3 
// 存在 i（0 < i < arr.length - 1）使得：
// 
// arr[0] < arr[1] < ... arr[i-1] < arr[i] 
// arr[i] > arr[i+1] > ... > arr[arr.length - 1] 
// 
// 
// 
//
// 给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 
//1] > ... > arr[arr.length - 1] 的下标 i ，即山峰顶部。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [0,1,0]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,3,5,4,2]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：arr = [0,10,5,2]
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：arr = [3,4,5,1]
//输出：2
// 
//
// 示例 5： 
//
// 
//输入：arr = [24,69,100,99,79,78,67,36,26,19]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 3 <= arr.length <= 104 
// 0 <= arr[i] <= 106 
// 题目数据保证 arr 是一个山脉数组 
// 
//
// 
//
// 进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？ 
//
// 
//
// 注意：本题与主站 852 题相同：https://leetcode-cn.com/problems/peak-index-in-a-mountain-ar
//ray/ 
// Related Topics 数组 二分查找 
// 👍 96 👎 0
	
package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;
/**
* 剑指 Offer II 069
*/
public class B1IidL {
    public static void main(String[] args) {
        Solution solution = new B1IidL().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        int left =0 ;
        int right =arr.length-1;
        int mid ;

        while (left <= right) {
            mid =  (right-left)/2 +left;

            // mid是和前后两个元素进行比较吗？会存在数组访问越界的情况
            //先判断left与mid-1,right与mid+1的关系吧
            int leftBoundary = Math.max(mid - 1, left);
            int rightBoundary = Math.min(mid + 1, right);

            //处于递增情况 mid-1<mid<mid+1
            if (arr[leftBoundary] < arr[mid] && arr[mid] < arr[rightBoundary]) {
                left = mid +1;
            }
            //处于递减情况 mid-1>mid>mid+1
            else if (arr[leftBoundary] > arr[mid] && arr[mid] > arr[rightBoundary]) {
                right = mid-1;
            }else {
                return mid;
            }

        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}