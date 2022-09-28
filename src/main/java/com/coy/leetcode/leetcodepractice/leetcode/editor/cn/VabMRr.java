/**
* 字符串中的所有变位词
* 
*/
//给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 变位词 指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
// 
//
// 示例 2： 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的变位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的变位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的变位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 104 
// s 和 p 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 438 题相同： https://leetcode-cn.com/problems/find-all-anagrams-in-a-str
//ing/ 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 36 👎 0
	
package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
* 剑指 Offer II 015
 * 第一次解答错误：起始索引位置错了，修改：rlt.add(i- s1Length)->rlt.add(i- s1Length+1);
*/
public class VabMRr {
    public static void main(String[] args) {
        Solution solution = new VabMRr().new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams( String p,String s) {
        List<Integer> rlt = new ArrayList<>();
        if (p.length()<s.length()){
            return rlt;
        }
        //step1:初始化滑动窗口left=0,right=s1Length-1
        int[] counts = new int[26];
        int s1Length = s.length();
        for (int i = 0; i < s1Length; i++) {
            counts[s.charAt(i)-'a']++;
            counts[p.charAt(i)-'a']--;
        }
        if (areAllZero(counts)){
            rlt.add(0);
        }
        //step2：移动滑动窗口，滑动窗口左边界字符出现次数++，右边界字符出现次数--
        for (int i = s1Length; i < p.length(); i++) {
            counts[p.charAt(i- s1Length)-'a']++;
            counts[p.charAt(i)-'a']--;
            if (areAllZero(counts)){
                rlt.add(i- s1Length+1);
            }
        }

        return rlt;

    }
        private boolean areAllZero(int[] counts) {
            for (final int count : counts) {
                if (count!=0){
                    return false;
                }
            }
            return true;
        }
}

//leetcode submit region end(Prohibit modification and deletion)

}