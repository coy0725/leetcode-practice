/**
* 最多删除一个字符得到回文
* 
*/
//给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "aba"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abca"
//输出: true
//解释: 可以删除 "c" 字符 或者 "b" 字符
// 
//
// 示例 3: 
//
// 
//输入: s = "abc"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 105 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 680 题相同： https://leetcode-cn.com/problems/valid-palindrome-ii/ 
// Related Topics 贪心 双指针 字符串 
// 👍 52 👎 0
	
package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;
/**
* 剑指 Offer II 019
*/
public class RQku0D {
    public static void main(String[] args) {
        Solution solution = new RQku0D().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        int left =0;
        int right = s.length()-1;
        boolean isDeleted = false;
        while (left<right){
            char leftCh = s.charAt(left);
            char rightCh = s.charAt(right);
            if (leftCh==rightCh){
                left++;
                right--;
            }else {
                if (!isDeleted){
                    if (rightCh==s.charAt(left+1)){
                        left++;
                    }else if (leftCh==s.charAt(right+1)){
                        right--;
                    }else return false;

                    isDeleted=true;
                }else return false;
            }
        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}