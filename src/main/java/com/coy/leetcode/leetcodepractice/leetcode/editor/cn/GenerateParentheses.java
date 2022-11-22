/**
 * 括号生成
 */
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 2973 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 22
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if (n == 0) {
                return res;
            }

            StringBuilder path = new StringBuilder();
            dfs(path, n, n, res);
            return res;
        }

        private void dfs(StringBuilder path, int left, int right, List<String> res) {
            if (left == 0 && right == 0) {
                res.add(path.toString());
            }

            //左括号要先用，所以左括号数量如果小于右括号说明是不符合题意的情况，需要剪枝，不再继续深度遍历
            if (left > right) {
                return;
            }

            if (left > 0) {
                path.append("(");
                dfs(path, left, right, res);
                path.deleteCharAt(path.length() - 1);
            }
            if (right > 0) {
                path.append(")");
                dfs(path, left, right, res);
                path.deleteCharAt(path.length() - 1);
            }


        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}