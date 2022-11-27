/**
 * 生成匹配的括号
 */
//正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
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
//
// 
//
// 注意：本题与主站 22 题相同： https://leetcode-cn.com/problems/generate-parentheses/ 
// Related Topics 字符串 动态规划 回溯 
// 👍 52 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 085
 */
public class IDBivT {
    public static void main(String[] args) {
        Solution solution = new IDBivT().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String left = "(";
        String right = ")";

        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            String path = "";
            int leftCount = 0;
            int rightCount =0;
            dfs(res,path,n,leftCount,rightCount);
            return res;
        }

        private void dfs(List<String> res, String path, int n, int leftCount, int rightCount) {

            if (leftCount == n && rightCount == n) {
                res.add(path);
                return;
            }
            if (leftCount < n) {
                dfs(res, path + left, n, leftCount+1, rightCount);
            }
            if (leftCount > rightCount) {
                dfs(res,path+right,n,leftCount,rightCount+1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}