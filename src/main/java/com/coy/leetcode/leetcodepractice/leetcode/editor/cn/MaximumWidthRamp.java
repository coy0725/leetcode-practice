/**
* 最大宽度坡
* 
*/
//给定一个整数数组 A，坡是元组 (i, j)，其中 i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。 
//
// 找出 A 中的坡的最大宽度，如果不存在，返回 0 。 
//
// 
//
// 示例 1： 
//
// 输入：[6,0,8,2,1,5]
//输出：4
//解释：
//最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
// 
//
// 示例 2： 
//
// 输入：[9,8,1,0,1,9,4,0,4,1]
//输出：7
//解释：
//最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 50000 
// 0 <= A[i] <= 50000 
// 
//
// 
// Related Topics 栈 数组 单调栈 
// 👍 186 👎 0
	
package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.Stack;

/**
* 962
*/
public class MaximumWidthRamp {
    public static void main(String[] args) {
        Solution solution = new MaximumWidthRamp().new Solution();
        System.out.println(solution.maxWidthRamp(new int[] {6,0,8,2,1,5}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxWidthRamp(int[] nums) {
        int matWidth = 0;
        //stack存储数组下标，数组下标对应的数组value单调递减？

        //计算坡度的前提是nums[i]>=stack.peek()最小值，但是出栈之后这个最小值应该还要再进栈，是不是需要两个栈？
        //用于临时存储栈弹出的变量
        Stack<Integer> tmpStack = new Stack<>();
        //计算当前i的最大坡度，依赖于0-i-1的数据
        //存储数组索引值，将0到i的值按num[i]从大到小排
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.empty()||nums[i]<nums[stack.peek()]){
                stack.push(i);
                continue;
            }
            while (!stack.empty()&&nums[i]>=nums[stack.peek()]){
                Integer left = stack.pop();
                int width = i-left;
                matWidth=Math.max(width,matWidth);
                tmpStack.push(left);
            }
            stack.push(i);
            while (!tmpStack.empty()){
                stack.push(tmpStack.pop());
            }
        }

        return matWidth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}