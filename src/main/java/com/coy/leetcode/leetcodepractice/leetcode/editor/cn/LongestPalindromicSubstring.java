/**
 * 最长回文子串
 */
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 5774 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

/**
 * 5
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int startIndex = 0;
        int endIndex = 0;

        public String longestPalindrome(String s) {

            if (s == null || s.length() < 2) {
                return s;
            }

            for (int i = 0; i < s.length(); i++) {
                subLongestPalindrome(s, i, i);//以i为对称中心
                subLongestPalindrome(s, i, i + 1);//以i\i+1为对称中心
            }
            return s.substring(startIndex,endIndex+1);

        }
        //向外扩展获取当前能够获取的最长子串
        private void subLongestPalindrome(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right-left>endIndex-startIndex){
                    endIndex=right;
                    startIndex=left;
                }
                left--;
                right++;
            }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}