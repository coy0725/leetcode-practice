/**
 * 计算器
 */
//给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。 
//
// 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 栈 数学 字符串 
// 👍 90 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Math;

/**
 * 面试题 16.26
 */
@com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Stack
@Math
public class CalculatorLcci {
    public static void main(String[] args) {
        Solution solution = new CalculatorLcci().new Solution();
        System.out.println(solution.calculate("3+2*2"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<Character> addOrSubtract = new HashSet<>();
        Set<Character> multiplyDivide = new HashSet<>();

        public int calculate(String s) {
            s = s.replace(" ", "");
            Deque<Integer> nums = new LinkedList<>();
            Deque<Character> ops = new LinkedList<>();
            addOrSubtract.add('+');
            addOrSubtract.add('-');
            multiplyDivide.add('*');
            multiplyDivide.add('/');

            Stack<Integer> numStack = new Stack<>();
            Stack<Character> opStack = new Stack<>();
            //step1 分离操作数与操作符
            char[] chars = s.toCharArray();
            StringBuilder num = new StringBuilder();
            for (final char ch : chars) {
                if (Character.isDigit(ch)) {
                    num.append(ch);
                } else {
                    nums.addLast(Integer.valueOf(num.toString()));
                    num = new StringBuilder();
                    ops.addLast(ch);
                }
            }

            //step2 先算乘除法
            while (!ops.isEmpty()) {
                Character op = ops.pollFirst();
                if ('*' == op) {
                    Integer first = nums.pollFirst();
                    Integer second = nums.pollFirst();
                    nums.addFirst(first * second);
                } else if ('/' == op) {
                    Integer first = nums.pollFirst();
                    Integer second = nums.pollFirst();
                    nums.addFirst(first / second);
                } else {
                    opStack.push(op);
                    numStack.push(nums.getFirst());
                }
            }
            while (!opStack.isEmpty()) {
                ops.addFirst(opStack.pop());
                nums.addFirst(numStack.pop());
            }
            //step3 算加减法
            while (!ops.isEmpty()) {
                Character op = ops.pollFirst();
                if ('+' == op) {
                    Integer first = nums.pollFirst();
                    Integer second = nums.pollFirst();
                    nums.addFirst(first + second);
                } else {
                    Integer first = nums.pollFirst();
                    Integer second = nums.pollFirst();
                    nums.addFirst(first - second);
                }
            }
            return nums.getFirst();

        }

    }

    class Solution2 {

        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            char opt = '+';
            int num = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (Character.isDigit(ch)) {
                    num = num * 10 + (ch - '0');
                }
                //先做乘除法
                if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                    if (opt == '+') {
                        stack.push(num);
                    } else if (opt == '-') {
                        stack.push(-num);
                    } else if (opt == '*') {
                        stack.push(stack.pop() * num);
                    } else {
                        stack.push(stack.pop() / num);
                    }
                    num = 0;
                    opt = ch;
                }
            }
            int res = 0;
            //做加法
            while (!stack.isEmpty()) {
                res = res + stack.pop();
            }
            return res;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}