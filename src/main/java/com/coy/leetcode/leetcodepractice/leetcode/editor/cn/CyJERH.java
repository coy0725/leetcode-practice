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

import java.util.Arrays;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.DynamicProgramming;

/**
 * 剑指 Offer II 092
 */
@DynamicProgramming
public class CyJERH {
    public static void main(String[] args) {
        Solution2 solution = new CyJERH().new Solution2();

        solution.minFlipsMonoIncr("010110");
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 递归解法，不带缓存
     */
    class Solution {
        public int minFlipsMonoIncr(String s) {
            int len = s.length();
            if (len <= 1) {
                return 0;
            }
            char[] chars = s.toCharArray();
            int min = Math.min(f(chars, len - 1), g(chars, len - 1));
            System.out.println(min);
            return min;

        }

        //确保字符i可以是1
        private int g(char[] chars, int i) {
            char ch = chars[i];
            if (i == 0) {
                return 0;
            }

            if (ch == '1') {
                return Math.min(g(chars, i - 1), f(chars, i - 1) + 1);
            } else {
                return Math.min(g(chars, i - 1) + 1, f(chars, i - 1));
            }
        }

        //确保字符i可以是0
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
    class Solution2 {
        public int minFlipsMonoIncr(String s) {
            int len = s.length();
            if (len <= 1) {
                return 0;
            }
            char[] chars = s.toCharArray();
            int[] fCounts = new int[s.length()];
            Arrays.fill(fCounts, -1);
            int[] gCounts = new int[s.length()];
            Arrays.fill(gCounts, -1);

            int min = Math.min(f(chars, len - 1, fCounts), g(chars, len - 1, fCounts, gCounts));
            System.out.println(min);
            return min;

        }

        //确保字符i可以是1
        private int g(char[] chars, int i, int[] fCounts, int[] gCounts) {
            char ch = chars[i];
            if (i == 0) {
                return 0;
            }
            int gCount;
            if (gCounts[i - 1] != -1) {
                gCount = gCounts[i - 1];
            } else {
                gCount = g(chars, i - 1, fCounts, gCounts);
                gCounts[i - 1] = gCount;
            }
            if (ch == '1') {
                return Math.min(gCount, f(chars, i - 1, fCounts) + 1);
            } else {
                return Math.min(gCount + 1, f(chars, i - 1, fCounts));
            }
        }

        //确保字符i可以是0
        private int f(char[] chars, int i, int[] fCounts) {
            char ch = chars[i];
            if (i == 0) {
                if (ch == '0') {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                int fCount;
                if (fCounts[i - 1] != -1) {
                    fCount = fCounts[i - 1];
                } else {
                    fCount = f(chars, i - 1, fCounts);
                    fCounts[i - 1] = fCount;
                }
                if (ch == '0') {
                    return fCount;
                } else {
                    return fCount + 1;
                }
            }
        }

    }

    class Solution3 {
        public int minFlipsMonoIncr(String s) {
            int len = s.length();
            if (len == 0) {
                return 0;
            }
            //，f（i）对应二维数组dp的第1行，g（i）对应dp的第2行。
            int[][] dp = new int[2][2];
            char ch = s.charAt(0);
            dp[0][0] = ch == '0' ? 0 : 1;
            dp[1][0] = ch == '1' ? 0 : 1;

            for (int i = 1; i < len; i++) {
                ch = s.charAt(i);
                int prev0 = dp[0][(i - 1) % 2];
                int prev1 = dp[1][(i - 1) % 2];
                dp[0][i % 2] = prev0 + (ch == '0' ? 0 : 1);//f(i)
                dp[1][i % 2] = Math.min(prev0, prev1) + (ch == '1' ? 0 : 1);//g(i)

            }
            return Math.min(dp[0][(len - 1) % 2], dp[1][(len - 1) % 2]);

        }

    }
}