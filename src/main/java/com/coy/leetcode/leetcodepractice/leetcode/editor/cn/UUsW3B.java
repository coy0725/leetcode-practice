/**
 * 含有 k 个元素的组合
 */
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2: 
//
// 
//输入: n = 1, k = 1
//输出: [[1]] 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// 
//
// 注意：本题与主站 77 题相同： https://leetcode-cn.com/problems/combinations/ 
// Related Topics 数组 回溯 
// 👍 36 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 080
 */
public class UUsW3B {
    public static void main(String[] args) {
        Solution solution = new UUsW3B().new Solution();
        System.out.println(solution.combine(4, 2));

        Solution1 solution2 = new UUsW3B().new Solution1();
        System.out.println(solution2.combine(4, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {

            List<List<Integer>> res = new ArrayList<>();
            List<Integer> subSet = new ArrayList<>();
            dfs(subSet, k, 1, n, res);
            return res;
        }

        private void dfs(List<Integer> subSet, int k, int i, int n, List<List<Integer>> res) {
            //到达叶子节点
            if (subSet.size() == k) {
                res.add(new ArrayList<>(subSet));
                return;
            } else if (i <= n) {

                subSet.add(i);
                dfs(subSet, k, i + 1, n, res);
                subSet.remove(subSet.size() - 1);
                //不选择当前元素
                dfs(subSet, k, i + 1, n, res);
            }

        }
    }

    class Solution1 {
        public List<List<Integer>> combine(int n, int k) {

            List<List<Integer>> res = new ArrayList<>();
            LinkedList<Integer> subSet = new LinkedList<>();
            dfs(res, subSet, n, k, 1);
            return res;
        }

        private void dfs(List<List<Integer>> res, LinkedList<Integer> subSet, int n, int k, int i) {
            if (i > n) {
                return;
            }
            if (subSet.size() == k) {
                res.add(new LinkedList<>(subSet));
                return;
            }

            //当前元素加入集合
            subSet.addLast(i);
            dfs(res, subSet, n, k, i + 1);
            subSet.removeLast();
            //当前元素不加入集合
            dfs(res, subSet, n, k, i + 1);

        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}