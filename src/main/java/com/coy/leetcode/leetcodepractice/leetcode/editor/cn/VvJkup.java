/**
 * 没有重复元素集合的全排列
 */
//给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// 
//
// 注意：本题与主站 46 题相同：https://leetcode-cn.com/problems/permutations/ 
// Related Topics 数组 回溯 
// 👍 40 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 083
 */
public class VvJkup {
    public static void main(String[] args) {
        Solution solution = new VvJkup().new Solution();
        System.out.println(solution.permute(new int[] {1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            LinkedList<Integer> path = new LinkedList<>();
            int[] used = new int[nums.length];//标识数组中的数字是否使用过
            dfs(nums, path, used, res);
            return res;
        }

        private void dfs(int[] nums, LinkedList<Integer> path, int[] used, List<List<Integer>> res) {
            if (path.size() == nums.length) {
                res.add(new LinkedList<>(path));
            } else {
                for (int i = 0; i < nums.length; i++) {
                    if (used[i] == 1) {
                        continue;
                    }
                    path.add(nums[i]);
                    used[i] = 1;
                    dfs(nums, path, used, res);
                    path.removeLast();
                    used[i] = 0;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}