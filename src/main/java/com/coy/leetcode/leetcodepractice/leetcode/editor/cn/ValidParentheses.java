/**
* 有效的括号
* 
*/
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 3537 👎 0
	
package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Stack;

/**
* 20
*/
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //'('，')'，'{'，'}'，'['，']'
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put("(".charAt(0),")".charAt(0));
        map.put("{".charAt(0),"}".charAt(0));
        map.put("[".charAt(0),"]".charAt(0));
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                stack.push(c);
            } else if (stack.empty()||!map.get(stack.pop()).equals(c)) {
                return false;
            }
        }
        return stack.empty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}