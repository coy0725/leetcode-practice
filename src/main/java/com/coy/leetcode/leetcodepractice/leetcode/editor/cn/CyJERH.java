/**
 * 翻转字符
 */
//如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是 单
//调递增 的。 
//
// 我们给出一个由字符 '0' 和 '1' 组成的字符串 s，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。 
//
// 返回使 s 单调递增 的最小翻转次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "00110"
//输出：1
//解释：我们翻转最后一位得到 00111.
// 
//
// 示例 2： 
//
// 
//输入：s = "010110"
//输出：2
//解释：我们翻转得到 011111，或者是 000111。
// 
//
// 示例 3： 
//
// 
//输入：s = "00011000"
//输出：2
//解释：我们翻转得到 00000000。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20000 
// s 中只包含字符 '0' 和 '1' 
// 
//
// 
//
// 注意：本题与主站 926 题相同： https://leetcode-cn.com/problems/flip-string-to-monotone-in
//creasing/ 
// Related Topics 字符串 动态规划 
// 👍 56 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

/**
 * 剑指 Offer II 092
 */
public class CyJERH {
    public static void main(String[] args) {
        Solution solution = new CyJERH().new Solution();

        solution.minFlipsMonoIncr("00110");
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 递归解法，不带缓存
     *
     */
    class Solution {
        public int minFlipsMonoIncr(String s) {
            int len = s.length();

            char[] chars = s.toCharArray();
            return Math.min(f(chars, len - 1), g(chars, len - 1));

        }

        //确保最后一个字符是1
        private int g(char[] chars, int i) {
            char ch = chars[i];
            if (i == 0) {
                if (ch == '1') {
                    return 0;
                } else {
                    return 1;
                }
            }

            if (ch=='1'){
                return g(chars, i - 1);
            }else return g(chars,i-1)+1;
        }


        //确保最后一个字符是0
        private int f(char[] chars, int i) {
            char ch = chars[i];
            if (i == 0) {
                if (ch == '0') {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                if (ch == '0') {
                    return f(chars, i - 1);
                } else {
                    return f(chars, i - 1) + 1;
                }
            }
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

}