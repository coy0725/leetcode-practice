/**
 * 最长不含重复字符的子字符串
 */
//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 502 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.HashMap;

/**
 * 剑指 Offer 48
 */
public class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
        System.out.println(solution.lengthOfLongestSubstring3("abcabcabc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() <= 1) {
                return s.length();
            }
            int maxlength = 0;
            int left = 0;
            HashMap<Character, Integer> keyToCount = new HashMap<>();
            for (int right = 0; right < s.length(); right++) {

                keyToCount.put(s.charAt(right), keyToCount.getOrDefault(s.charAt(right), 0) + 1);
                while (left <= right && !areAllLessOne(keyToCount)) {

                    keyToCount.put(s.charAt(left), keyToCount.getOrDefault(s.charAt(left), 0) - 1);
                    left++;
                }
                maxlength = Math.max(maxlength, right - left + 1);
            }
            return maxlength;
        }

        //字节面试时做错的样子
        public int lengthOfLongestSubstring3(String s) {
            int left =0;
            int right =0;
            int maxLength=0;
            int duplicateCharCount=0;

            HashMap<Character,Integer> charToCount = new HashMap<>();
            for (right = 0; right <s.length() ; right++) {
                Integer count = charToCount.getOrDefault(s.charAt(right), 0);
                if (count==1){
                    duplicateCharCount++;
                }
                charToCount.put(s.charAt(right),count+1);
                if (duplicateCharCount<1){
                    maxLength = Math.max(maxLength,right-left+1);
                }else {
                    for (int i = left; i < right; i++) {
                        Integer n = charToCount.get(s.charAt(left));
                        if (n==2){
                            duplicateCharCount--;
                        }
                        charToCount.put(s.charAt(left),n-1);
                        if (duplicateCharCount<1){
                            maxLength=Math.max(maxLength,right-left+1);
                            break;
                        }
                        left++;
                    }
                }

            }
            return maxLength;
        }

        public int lengthOfLongestSubstring2(String s) {
            if (s.length() <= 1) {
                return s.length();
            }
            int maxlength = 0;
            int left = 0;
            int dupCount = 0;//重复字符数
            HashMap<Character, Integer> keyToCount = new HashMap<>();
            for (int right = 0; right < s.length(); right++) {
                Integer charCount = keyToCount.getOrDefault(s.charAt(right), 0);
                //字符出现次数1-》2,重复字符数++
                if (charCount == 1) {
                    dupCount++;
                }
                keyToCount.put(s.charAt(right), charCount + 1);
                while (left <= right && dupCount > 0) {
                    Integer charCount2 = keyToCount.getOrDefault(s.charAt(left), 0);
                    //字符出现次数2-》1,重复字符数--
                    if (charCount2 == 2) {
                        dupCount--;
                    }
                    keyToCount.put(s.charAt(left), charCount2 - 1);
                    left++;
                }
                maxlength = Math.max(maxlength, right - left + 1);
            }
            return maxlength;
        }

        private boolean areAllLessOne(HashMap<Character, Integer> keyToCount) {
            for (final Integer count : keyToCount.values()) {
                if (count > 1) {
                    return false;
                }
            }
            return true;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}