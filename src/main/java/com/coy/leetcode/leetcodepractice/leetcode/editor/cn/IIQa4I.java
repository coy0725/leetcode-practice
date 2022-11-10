/**
 * 每日温度
 */
//请根据每日 气温 列表 temperatures ，重新生成一个列表，要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不
//会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 105 
// 30 <= temperatures[i] <= 100 
// 
//
// 
//
// 注意：本题与主站 739 题相同： https://leetcode-cn.com/problems/daily-temperatures/ 
// Related Topics 栈 数组 单调栈 
// 👍 63 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.Stack;

/**
 * 剑指 Offer II 038
 */
public class IIQa4I {
    public static void main(String[] args) {
        Solution solution = new IIQa4I().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Integer> stack = new Stack<>();//每天温度在数组中的下标
            int[] result = new int[temperatures.length];
            for (int i = 0; i < temperatures.length; i++) {
                //当前温度比栈顶温度大？
                while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                    Integer prev = stack.pop();
                    result[prev] = i - prev;
                }
                stack.push(i);
            }
            return result;

        }

        public int[] dailyTemperatures2(int[] temperatures) {
            Stack<Integer> stack = new Stack<>();
            int[] result = new int[temperatures.length];

            for (int i = 0; i < temperatures.length; i++) {

                //当前温度比之前的温度高
                int todayTemperature = temperatures[i];
                while (!stack.isEmpty() && todayTemperature > temperatures[stack.peek()]) {
                    Integer index = stack.pop();
                    result[index] = i - index;
                }
                stack.push(i);
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}