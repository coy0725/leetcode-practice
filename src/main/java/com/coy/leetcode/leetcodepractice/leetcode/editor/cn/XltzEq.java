/**
* 有效的回文
* 
*/
//给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 本题中，将空字符串定义为有效的 回文串 。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串 
//
// 示例 2: 
//
// 
//输入: s = "race a car"
//输出: false
//解释："raceacar" 不是回文串 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 105 
// 字符串 s 由 ASCII 字符组成 
// 
//
// 
//
// 注意：本题与主站 125 题相同： https://leetcode-cn.com/problems/valid-palindrome/ 
// Related Topics 双指针 字符串 
// 👍 32 👎 0
	
package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;
/**
* 剑指 Offer II 018
*/
public class XltzEq {
    public static void main(String[] args) {
        Solution solution = new XltzEq().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        //空字符串是有效回文
        //判断是数字或子母:Character.isLetterOrDigit
        //忽略大小写进行判断:Character.toLowerCase
        int left = 0;
        int right = s.length()-1;
        while (left<right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!Character.isLetterOrDigit(leftChar)){
                left++;
            }else if (!Character.isLetterOrDigit(rightChar)){
                right--;
            }else {
                char leftCh = Character.toLowerCase(leftChar);
                char rightCh = Character.toLowerCase(rightChar);
                if (leftCh!=rightCh){
                    return false;
                }
                left++;
                right--;
            }

        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}