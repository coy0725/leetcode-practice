/**
 * 字符串中的变位词
 */
//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 104 
// s1 和 s2 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 567 题相同： https://leetcode-cn.com/problems/permutation-in-string/ 
// Related Topics 哈希表 双指针 字符串 滑动窗口 
// 👍 67 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

/**
 * 剑指 Offer II 014
 * - 第一次解答，失败，思路没有理清
 * - 第二次解答，失败，窗口移动时，字符出现次数增加规则记反了
 * - 第三次解答，失败，没有考虑到子数组可能比目标数组还长的情况
 */
public class MPnaiL {
    public static void main(String[] args) {
        Solution solution = new MPnaiL().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s2.length() < s1.length()) {
                return false;
            }
            //step1:初始化滑动窗口left=0,right=s1Length-1
            int[] counts = new int[26];
            int s1Length = s1.length();
            for (int i = 0; i < s1Length; i++) {
                counts[s1.charAt(i) - 'a']++;
                counts[s2.charAt(i) - 'a']--;
            }
            if (areAllZero(counts)) {
                return true;
            }
            //step2：移动滑动窗口，滑动窗口左边界字符出现次数++，右边界字符出现次数--
            for (int i = s1Length; i < s2.length(); i++) {
                counts[s2.charAt(i - s1Length) - 'a']++;
                counts[s2.charAt(i) - 'a']--;
                if (areAllZero(counts)) {
                    return true;
                }
            }

            return false;
        }

        public boolean checkInclusion2(String s1, String s2) {
            int s1length = s1.length();
            if (s2.length() < s1length) {
                return false;
            }

            //step1 存储字符串1各字符出现数量,可以使用数组或者hashMap进行存储,
            // 可以使用一个数组的状态来表示当前字符子串是否是字符串1的异位词 字符串1中的字符出现，则加1，子字符串的字符出现，则-1
            int[] counts = new int[26];
            for (int i = 0; i < s1length; i++) {
                counts[s1.charAt(i)-'a']++;
                counts[s2.charAt(i)-'a']--;
            }
            if (areAllZero(counts)) {
                return true;
            }

            //step2 使用双指针来表示字符串2的子串，如果字符串2的子串是字符串1的异位词则返回true
            //需要将字符串2的子串中各字符出现的次数存储下来，如果与字符串1中各字符出现数量一致则是异位词
            //有一个隐含条件字符串2的子串长度是固定的
            for (int i = s1length; i < s2.length(); i++) {
                counts[s2.charAt(i - s1length) - 'a']++;
                counts[s2.charAt(i) - 'a']--;
                if (areAllZero(counts)) {
                    return true;
                }
            }
            return false;

        }

        private boolean areAllZero(int[] counts) {
            for (final int count : counts) {
                if (count != 0) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}