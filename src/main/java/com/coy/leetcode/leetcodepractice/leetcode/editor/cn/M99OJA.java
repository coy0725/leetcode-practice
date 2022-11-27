/**
 * 分割回文子字符串
 */
//给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "google"
//输出：[["g","o","o","g","l","e"],["g","oo","g","l","e"],["goog","l","e"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出：[["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 131 题相同： https://leetcode-cn.com/problems/palindrome-partitioning/ 
// Related Topics 深度优先搜索 广度优先搜索 图 哈希表 
// 👍 43 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 086
 */
public class M99OJA {
    public static void main(String[] args) {
        Solution solution = new M99OJA().new Solution();
        System.out.println(Arrays.deepToString(solution.partition("google")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[][] partition(String s) {


            List<List<String>> result = new LinkedList<>();
            dfs(result, new LinkedList<>(), s, 0);
            // List<List<String>> 转 String[][]，这里不重要
            String[][] ans = new String[result.size()][];
            for (int i = 0; i < result.size(); i++) {
                ans[i] = new String[result.get(i).size()];
                for (int j = 0; j < ans[i].length; j++) {
                    ans[i][j] = result.get(i).get(j);
                }
            }
            return ans;


        }

        private void dfs(List<List<String>> result, LinkedList<String> subStrings, String s,
            int start) {
            if (start == s.length()) {
                result.add(new LinkedList<>(subStrings));
                return;
            }

            for (int i = start; i < s.length(); ++i) {
                if (isPalindrome(s, start, i)) {
                    subStrings.add(s.substring(start, i + 1));
                    dfs(result, subStrings, s, i + 1);
                    subStrings.removeLast();
                }
            }

        }

        private boolean isPalindrome(String s, int start, int end) {
            while (start < end) {
                if (s.charAt(start++) != s.charAt(end--)) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}