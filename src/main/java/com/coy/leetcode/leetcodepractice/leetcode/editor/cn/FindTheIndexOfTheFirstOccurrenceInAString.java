/**
 * 找出字符串中第一个匹配项的下标
 */
//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
// 
//
// 示例 2： 
//
// 
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 104 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 
// 👍 1679 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Medium;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.solution.BeHelped;

/**
 * 28
 * - 当匹配到j时发生了不匹配的情况，表示模式串[0,j-1]个字符与原字符串前j-1个字符匹配
 * - 如果[0,j-1] 这个字符串部分前缀与后缀相同的情况，则可以将前缀移动到后缀位置
 */
@BeHelped
@Medium
public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        Solution solution = new FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
        System.out.println(solution.strStr("sadbutsad", "sad"));

        Solution2 solution2 = new FindTheIndexOfTheFirstOccurrenceInAString().new Solution2();
        System.out.println(solution2.strStr("sadbutsad", "sad"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String ss, String patten) {
            if (patten.isEmpty()) {
                return 0;
            }
            int n = ss.length(), m = patten.length();
            //原串和匹配串前面都加空格，使其下标从1开始
            ss = " " + ss;
            patten = " " + patten;
            char[] s = ss.toCharArray();
            char[] p = patten.toCharArray();

            //构建next数组，数组长度为匹配串的长度（next数组是和匹配串相关的)
            int[] next = new int[m + 1];
            //构造过程 i=2,j=0 开始，i小于等于匹配串长度（构造i从2开始）
            for (int i = 2, j = 0; i <= m; i++) {
                //匹配不成功的话，j=next(j)
                while (j > 0 && p[i] != p[j + 1]) {
                    j = next[j];
                }
                if (p[i] == p[j + 1]) {
                    j++;
                }
                next[i] = j;
            }


            //匹配过程，i=1,j=0开始，i等于原串长度 匹配i从1开始
            for (int i = 1,j=0; i <=n ; i++) {
                while (j > 0 && s[i] != p[j + 1]) {
                    j = next[j];
                }
                if (s[i] == p[j + 1]) {
                    j++;
                }
                if (j == m) {
                    return i - m;
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    class Solution2 {
        public int strStr(String ss, String patten) {

            return kmp(ss.toCharArray(),patten.toCharArray());
        }

        public  int kmp(char[] t, char[] p) {
            int[] next = getNext(p);
            int i = 0;
            int j = 0;
            while (i < t.length && j < p.length) {
                if (j == -1 || t[i] == p[j]) {
                    i++;
                    j++;
                } else {
                    j = next[j];
                }
            }
            if (j == p.length) {
                return i - p.length;
            } else {
                return -1;
            }
        }

        public  int[] getNext(char[] p) {
            int[] next = new int[p.length];
            next[0] = -1;
            int j = 0;
            int k = -1;
            while (j < p.length - 1) {
                if (k == -1 || p[j] == p[k]) {
                    j++;
                    k++;
                    if (p[j] != p[k]) {
                        next[j] = k;
                    } else {
                        next[j] = next[k];
                    }
                } else {
                    k = next[k];
                }
            }
            return next;
        }

    }

}