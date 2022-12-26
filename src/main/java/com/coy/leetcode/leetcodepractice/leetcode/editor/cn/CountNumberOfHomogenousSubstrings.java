/**
 * 统计同构子字符串的数目
 */
//给你一个字符串 s ，返回 s 中 同构子字符串 的数目。由于答案可能很大，只需返回对 109 + 7 取余 后的结果。 
//
// 同构字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同构字符串。 
//
// 子字符串 是字符串中的一个连续字符序列。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abbcccaa"
//输出：13
//解释：同构子字符串如下所列：
//"a"   出现 3 次。
//"aa"  出现 1 次。
//"b"   出现 2 次。
//"bb"  出现 1 次。
//"c"   出现 3 次。
//"cc"  出现 2 次。
//"ccc" 出现 1 次。
//3 + 1 + 2 + 1 + 3 + 2 + 1 = 13 
//
// 示例 2： 
//
// 输入：s = "xy"
//输出：2
//解释：同构子字符串是 "x" 和 "y" 。 
//
// 示例 3： 
//
// 输入：s = "zzzzz"
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 105 
// s 由小写字符串组成 
// 
// Related Topics 数学 字符串 
// 👍 39 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Medium;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Math;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.StringTag;

/**
 * 1759
 */
@Math
@Medium
@StringTag
public class CountNumberOfHomogenousSubstrings {
    public static void main(String[] args) {
        Solution solution = new CountNumberOfHomogenousSubstrings().new Solution();
        System.out.println(solution.countHomogenous("abbcccaa"));
        System.out.println(solution.countHomogenous("xy"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public static final int CONSTANT = 1000000007;

        public int countHomogenous(String s) {
            //同构字符串的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同构字符串。
            int homogenousCount = 0;
            HashMap<String, Integer> homogenousCountMap = new HashMap<>();

            //一个字符->两个字符->三个字符
            for (int windowSize = 1; windowSize <= s.length(); windowSize++) {
                //确定字符串窗口大小

                //step1 确定窗口中的字符串是否是同构字符串
                for (int i = 0; i < s.length() - windowSize+1; i++) {
                    String substring = s.substring(i, i + windowSize);
                    if (isValid(substring)) {
                        int count =
                            (homogenousCountMap.getOrDefault(substring, 0) + 1) % CONSTANT;
                        homogenousCountMap.put(substring, count);
                    }
                }
            }
            for (final Map.Entry<String, Integer> entry : homogenousCountMap.entrySet()) {
                System.out.println(entry.getKey()+":"+entry.getValue());
                homogenousCount = (homogenousCount + entry.getValue()) % CONSTANT;
            }
            return homogenousCount;
        }

        /**
         * 是同构字符串
         * 通过hashMap缓存计算结果？
         */
        HashMap<String, Boolean> validResult = new HashMap<>();
        private boolean isValid(String substring) {
            Boolean result = validResult.get(substring);
            if (result != null) {
                return result;
            }
            if (substring.length() == 1) {
                validResult.put(substring, true);
                return true;
            } else {
                for (int i = 1; i < substring.length(); i++) {
                    if (!(substring.charAt(i) == substring.charAt(i - 1))) {
                        validResult.put(substring, false);
                        return false;
                    }
                }
            }
            validResult.put(substring, true);
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}