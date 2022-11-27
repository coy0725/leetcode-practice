/**
 * 含有重复元素集合的全排列
 */
//给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// 
//
// 注意：本题与主站 47 题相同： https://leetcode-cn.com/problems/permutations-ii/ 
// Related Topics 数组 回溯 
// 👍 35 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 084
 */
public class SevenP8L0Z {
    public static void main(String[] args) {
        Solution solution = new SevenP8L0Z().new Solution();
        System.out.println(solution.permuteUnique(new int[] {1, 1, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            LinkedList<Integer> path = new LinkedList<>();
            boolean[] used = new boolean[nums.length];//标识数组中的数字是否使用过
            Arrays.sort(nums);
            dfs(nums, path, used, res);
            return res;
        }

        private void dfs(int[] nums, LinkedList<Integer> path, boolean[] used, List<List<Integer>> res) {
            if (path.size() == nums.length) {
                res.add(new LinkedList<>(path));
            } else {
                for (int i = 0; i < nums.length; i++) {
                    if (used[i] ) {
                        continue;
                    }
                    if (i > 0 && !used[i - 1] && nums[i - 1] == nums[i]) {
                        continue;
                    }
                    path.add(nums[i]);
                    used[i] = true;
                    dfs(nums, path, used, res);
                    path.removeLast();
                    used[i] = false;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}