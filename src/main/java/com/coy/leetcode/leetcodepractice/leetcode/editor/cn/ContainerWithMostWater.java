/**
* 盛最多水的容器
* 
*/
//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 105 
// 0 <= height[i] <= 104 
// 
// Related Topics 贪心 数组 双指针 
// 👍 3806 👎 0
	
package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;
/**
* 11
*/
public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        System.out.println(solution.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        //面积=长（right-left）*高（min(height[left],height[right])）
        //如果使用双指针的话，左右指针初识位置是哪？如何确定指针移动方向？移动会改变两个内容长和高
        //移动长板一定变小，移动短板可能增大，所以移动短板
        int maxArea = 0 ;
        int area;
        int left = 0;
        int right = height.length-1;
        while (left!=right){
            area=(right-left)*Math.min(height[left],height[right]);
            maxArea = Math.max(maxArea,area);
            if (height[left]<=height[right]){
                left++;
            }else right--;
        }
        return maxArea;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}