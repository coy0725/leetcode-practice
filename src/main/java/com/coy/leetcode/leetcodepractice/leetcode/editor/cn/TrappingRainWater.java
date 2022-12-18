/**
 * 接雨水
 */
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 3996 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.Stack;

/**
 * 42
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {

            int water = 0;
            Stack<Integer> stack = new Stack<>();
            for (int right = 0; right < height.length; right++) {

                while (!stack.isEmpty() && height[right] > height[stack.peek()]) {
                    Integer bottom = stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    Integer left = stack.peek();
                    int leftHeight = height[left];
                    int rightHeight = height[right];
                    int bottomHeight = height[bottom];
                    water = water + (right - left - 1) * (Math.min(leftHeight, rightHeight)
                        - bottomHeight);
                }
                stack.push(right);
            }
            return water;
        }
    }

    class Solution2 {
        public int trap(int[] height) {

            int water = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    Integer bottom = stack.pop();
                    if (stack.isEmpty()) {
                        break;

                    }
                    Integer left = stack.peek();
                    int leftHeight = height[left];
                    int rightHeight = height[i];
                    int bottomHeight = height[bottom];
                    water = water + (i - left - 1) * (Math.min(leftHeight, rightHeight) - bottomHeight);
                }
                stack.push(i);
            }

            return water;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}