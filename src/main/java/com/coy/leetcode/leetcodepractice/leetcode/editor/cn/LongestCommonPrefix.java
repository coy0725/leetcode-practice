/**
 * 最长公共前缀
 */
//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 2585 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

/**
 * 14
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        solution.longestCommonPrefix(new String[] {""});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            //循环,每次往前推进一个字符
            StringBuilder commonPrefix = new StringBuilder();
            int index = 0;
            boolean end = false;
            if (strs.length < 1) {
                return "";
            }
            if (strs.length ==1) {
                return strs[0];
            }
            while (true) {
                for (int i = 0; i < strs.length - 1; i++) {
                    if (strs[i].length() - 1 < index || strs[i + 1].length() - 1 < index) {
                        end = true;
                        break;
                    }
                    if (strs[i].charAt(index) != strs[i + 1].charAt(index)) {
                        end = true;
                        break;
                    }
                }
                if (end) {
                    break;
                }
                commonPrefix.append(strs[0].charAt(index));
                index++;
            }

            return commonPrefix.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}