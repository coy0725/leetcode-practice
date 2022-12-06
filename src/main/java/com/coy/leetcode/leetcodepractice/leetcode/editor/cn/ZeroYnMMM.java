/**
 * 直方图最大矩形面积
 */
//给定非负整数数组 heights ，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=105 
// 0 <= heights[i] <= 104 
// 
//
// 
//
// 注意：本题与主站 84 题相同： https://leetcode-cn.com/problems/largest-rectangle-in-histog
//ram/ 
// Related Topics 栈 数组 单调栈 
// 👍 63 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.Stack;

/**
 * 剑指 Offer II 039
 */
public class ZeroYnMMM {
    public static void main(String[] args) {
        Solution solution = new ZeroYnMMM().new Solution();
        System.out.println(solution.largestRectangleArea(new int[] {2,1,5,6,2,3}));

        Solution1 solution1 = new ZeroYnMMM().new Solution1();
        System.out.println(solution1.largestRectangleArea(new int[] {2,1,5,6,2,3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            int maxArea = 0;
            for (int i = 0; i < heights.length; i++) {
                //当前柱子高度小于栈顶柱子高度
                while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                    //计算以栈顶柱子高度为高的最大面积
                    int height = heights[stack.pop()];
                    //i是当前柱子右边，stack.peek是当前柱子左边
                    int width = i - stack.peek() - 1;
                    int area = height * width;

                    maxArea = Math.max(maxArea, area);
                }
                stack.push(i);
            }

            while (stack.peek() != -1) {
                int height = heights[stack.pop()];
                //i小于length，为什么这里的宽用的右边使用height.length?
                int width = heights.length - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            return maxArea;
        }


        public int largestRectangleArea2(int[] heights){
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            int maxArea = 0;

            for (int i = 0; i < heights.length; i++) {
                //保持栈是单调递增的
                if (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                    int height = heights[stack.pop()];
                    //i是当前柱子右边比他矮的柱子，stack.peek是当前柱子左边比它矮的柱子
                    int width = i - stack.peek() -1;
                    int area = height*width;
                    maxArea = Math.max(maxArea, area);
                }
                stack.push(i);

            }

            while (stack.peek() != -1) {
                int height = heights[stack.pop()];
                //i是当前柱子右边比他矮的柱子，stack.peek是当前柱子左边比它矮的柱子
                int width = heights.length - stack.peek() -1;
                int area = height*width;
                maxArea = Math.max(maxArea, area);
            }
            return maxArea;
        }
    }

    class Solution1 {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            int maxArea = 0;

            for (int i = 0; i < heights.length; i++) {
                //处理入栈情况,高度是单调递增的
                int height = heights[i];
                if (stack.peek()==-1||height >= heights[stack.peek()]) {
                    stack.push(i);
                } else {
                    //处理出栈情况，计算以当前出栈柱子为高的最大矩形面积
                    while (stack.peek()!=-1&&height < heights[stack.peek()]) {
                        //计算以当前栈顶柱子为高的最大矩形面积
                        Integer index = stack.pop();
                        int area = heights[index] * (i - index);
                        maxArea = Math.max(maxArea, area);
                        System.out.printf("index:%s,index height:%s,area:%s,maxArea:%s",index,
                            heights[index],area,maxArea);
                        System.out.println();
                    }
                    stack.push(i);
                }


            }
            //忘记处理栈中的元素
            while (stack.peek() != -1) {
                Integer index = stack.pop();
                int height = heights[index];
                //i小于length，为什么这里的宽用的右边使用height.length?
                int width = heights.length - index - 1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
                System.out.printf("index:%s,index height:%s,area:%s,maxArea:%s",index,
                    height,area,maxArea);
                System.out.println();
            }
            return maxArea;
        }



    }
    //leetcode submit region end(Prohibit modification and deletion)

}