/**
 * 组合总和 II
 */
//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 
// 👍 1171 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.BackTracing;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Math;

/**
 * 40
 */
@BackTracing
@Math
public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        solution.combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            int len = candidates.length;
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }

            Deque<Integer> path = new ArrayDeque<>();
            Arrays.sort(candidates);
            System.out.println(Arrays.toString(candidates));
            dfs(candidates, 0, len, target, path, res);
            return res;
        }

        private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path,
            List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
            }

            for (int i = begin; i < len; i++) {
                if (target - candidates[i] < 0) {
                    break;
                }

                if (i > begin && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                path.addLast(candidates[i]);
                //System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));
                dfs(candidates, i + 1, len, target - candidates[i], path, res);

                path.removeLast();
            }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}