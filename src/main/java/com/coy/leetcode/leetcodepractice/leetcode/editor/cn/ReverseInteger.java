/**
 * 整数反转
 */
//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 3719 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

/**
 * 7
 */
public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            long n = 0;
            while (x != 0) {
                n = n * 10 + x % 10;
                //通过除以10来进行移位个位-》10位-》100位
                x = x / 10;
            }
            return (int) n == n ? (int) n : 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}