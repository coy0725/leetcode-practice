/**
 * 有效的完全平方数
 */
//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 460 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Easy;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.BinarySearch;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Math;

/**
 * 367
 */
@Easy
@Math
@BinarySearch
public class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
        System.out.println(solution.isPerfectSquare(16));
        System.out.println(solution.isPerfectSquare(808201));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {

            long left = 0;
            long right = num;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                //这个乘积会不会有溢出的情况？left,right,product都声明为long
                long product = mid * mid;
                if (product == num) {
                    return true;
                } else if (product > num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}