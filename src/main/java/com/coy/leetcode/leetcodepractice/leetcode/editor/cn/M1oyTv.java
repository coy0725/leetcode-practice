/**
 * 含有所有字符的最短字符串
 */
//给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。 
//
// 如果 s 中存在多个符合条件的子字符串，返回任意一个。 
//
// 
//
// 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC" 
//解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C' 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3： 
//
// 
//输入：s = "a", t = "aa"
//输出：""
//解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//
// 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ 
//
// 
//
// 注意：本题与主站 76 题相似（本题答案不唯一）：https://leetcode-cn.com/problems/minimum-window-subs
//tring/ 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 64 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 剑指 Offer II 017
 */
public class M1oyTv {
    public static void main(String[] args) {
        Solution solution = new M1oyTv().new Solution();

        System.out.println(solution.minWindow("cabwefgewcwaefgcf",
            "cae"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow2(String s, String t) {
            String rlt = "";
            if (s.length() < t.length()) {
                return rlt;
            }
            HashMap<Character, Integer> tCharToCount = new HashMap<>();
            HashMap<Character, Integer> windowCharToCount = new HashMap<>();
            //step1:统计t字符串中字符出现次数
            for (int i = 0; i < t.length(); i++) {
                tCharToCount.put(t.charAt(i), tCharToCount.getOrDefault(t.charAt(i), 0)+1);
                windowCharToCount.put(s.charAt(i), windowCharToCount.getOrDefault(s.charAt(i), 0)+1);
            }
            if (isMatch(tCharToCount, windowCharToCount)) {
                return s.substring(0, t.length());
            }
            //step2：移动窗口，让窗口中的子串字符数量大于t中字符数量出现数量
            //窗口大小应该等于t字符串的长度，这题是有最小窗口大小的

            int left = 0;
            for (int right = t.length(); right < s.length(); right++) {
                windowCharToCount.put(s.charAt(right), windowCharToCount.getOrDefault(s.charAt(right), 0)+1);
                if (isMatch(tCharToCount, windowCharToCount)) {
                    rlt = s.substring(left, right + 1);


                }
                while (isMatch(tCharToCount, windowCharToCount)) {
                    if (rlt.length()>0&&right-left+1<rlt.length()){
                        rlt = s.substring(left, right + 1);
                    }
                    windowCharToCount.put(s.charAt(left), windowCharToCount.getOrDefault(s.charAt(left),0)-1);
                    left++;
                }
            }
            return rlt;

        }

        private boolean isMatch(HashMap<Character, Integer> tCharToCount,
            HashMap<Character, Integer> windowCharToCount) {
            for (final Map.Entry<Character, Integer> entry : tCharToCount.entrySet()) {
                Integer integer = windowCharToCount.get(entry.getKey());
                if (Objects.isNull(integer) || integer <entry.getValue()) {
                    return false;
                }
            }
            return true;
        }

        public String minWindow(String s, String t) {
            HashMap<Character,Integer> charToCount = new HashMap<>();
            for (final char c : t.toCharArray()) {
                charToCount.put(c,charToCount.getOrDefault(c,0)+1);
            }
            int count = charToCount.size();//重复字符种类数
            int start=0,end=0,minStart = 0,minEnd =0;
            int minLength = Integer.MAX_VALUE;
            while (end<s.length()||(count==0&&end==s.length())){
                if (count>0){
                    char endCh = s.charAt(end);
                    if (charToCount.containsKey(endCh)){
                        charToCount.put(endCh,charToCount.get(endCh)-1);
                        if (charToCount.get(endCh)==0){
                            count--;
                        }
                    }
                    end++;
                }else {
                    if (end-start<minLength){
                        minLength=end-start;
                        minStart=start;
                        minEnd=end;
                    }
                    char startCh = s.charAt(start);
                    if (charToCount.containsKey(startCh)){
                        charToCount.put(startCh,charToCount.get(startCh)+1);
                        if (charToCount.get(startCh)==1){
                            count++;
                        }
                    }
                    start++;
                }
            }

            return minLength<Integer.MAX_VALUE?s.substring(minStart,minEnd):"";

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}