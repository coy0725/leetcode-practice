/**
 * 含有重复元素集合的组合
 */
//给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
//。 
//
// candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。 
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
//
// 
//
// 注意：本题与主站 40 题相同： https://leetcode-cn.com/problems/combination-sum-ii/ 
// Related Topics 数组 回溯 
// 👍 36 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 082
 */
public class FourSjJUc {
    public static void main(String[] args) {
        Solution solution = new FourSjJUc().new Solution();
        System.out.println(solution.combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));

        Solution3 solution3 = new FourSjJUc().new Solution3();
        System.out.println(solution3.combinationSum(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {

            List<List<Integer>> res = new ArrayList<>();
            List<Integer> combination = new ArrayList<>();
            int sum = 0;
            int[] sorted = Arrays.stream(candidates).boxed().sorted().mapToInt(Integer::valueOf)
                .toArray();

            dfs(res, sorted, combination, target, sum, 0);
            return res;
        }

        private void dfs(List<List<Integer>> res, int[] candidates, List<Integer> combination,
            int target, int sum, int i) {

            if (target == sum && combination.size() != 0) {
                res.add(new ArrayList<>(combination));
            } else if (sum < target && i < candidates.length) {
                combination.add(candidates[i]);
                dfs(res, candidates, combination, target, sum + candidates[i], i + 1);
                combination.remove(combination.size() - 1);

                dfs(res, candidates, combination, target, sum, getNext(candidates, i));
            }
        }

        private int getNext(int[] nums, int index) {
            int next = index;
            while (next < nums.length && nums[next] == nums[index]) {
                next++;
            }
            return next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    class Solution2 {

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        int sum = 0;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            //为了将重复的数字都放到一起，所以先进行排序
            Arrays.sort(candidates);
            backTracking(candidates, target, 0);
            return res;
        }

        private void backTracking(int[] candidates, int target, int start) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = start; i < candidates.length && sum + candidates[i] <= target; i++) {
                //正确剔除重复解的办法
                //跳过同一树层使用过的元素
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                sum += candidates[i];
                path.add(candidates[i]);
                // i+1 代表当前组内元素只选取一次
                backTracking(candidates, target, i + 1);

                int temp = path.getLast();
                sum -= temp;
                path.removeLast();
            }
        }
    }

    class Solution3 {

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        int sum = 0;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            //为了将重复的数字都放到一起，所以先进行排序
            Arrays.sort(candidates);
            backTracking(candidates, target, 0);
            return res;
        }

        //candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
        private void backTracking(int[] candidates, int target, int start) {
            if (sum == target) {
                res.add(new LinkedList<>(path));
            }

            for (int i = start; i < candidates.length && sum + candidates[i] <= target; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                sum = sum + candidates[i];
                path.addLast(candidates[i]);
                backTracking(candidates, target, i + 1);
                int temp = path.getLast();
                sum -= temp;
                path.removeLast();
            }
        }

    }

}