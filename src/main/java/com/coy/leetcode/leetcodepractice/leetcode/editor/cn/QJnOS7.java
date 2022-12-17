/**
 * 最长公共子序列
 */
//给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//
// 
// 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。 
// 
//
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace" ，它的长度为 3 。
// 
//
// 示例 2： 
//
// 
//输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc" ，它的长度为 3 。
// 
//
// 示例 3： 
//
// 
//输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 和 text2 仅由小写英文字符组成。 
// 
//
// 
//
// 注意：本题与主站 1143 题相同： https://leetcode-cn.com/problems/longest-common-subsequenc
//e/ 
// Related Topics 字符串 动态规划 
// 👍 105 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

/**
 * 剑指 Offer II 095
 */
public class QJnOS7 {
    public static void main(String[] args) {
        Solution solution = new QJnOS7().new Solution();

        System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int longestCommonSubsequence(String text1, String text2) {
            if (text1.length() == 0 || text2.length() == 0) {
                return 0;
            }
            return dfs(text1, text2, text1.length() - 1, text2.length() - 1);

        }

        private int dfs(String text1, String text2, int i, int j) {
            if (i < 0 || j < 0) {
                return 0;
            }
            if (text1.charAt(i) == text2.charAt(j)) {
                return dfs(text1, text2, i - 1, j - 1)+1;
            } else {
                return  Math.max(dfs(text1,text2,i-1,j),dfs(text1,text2,i,j-1));
            }


        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}