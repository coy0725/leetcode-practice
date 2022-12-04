/**
 * 所有子集
 */
//给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// 
//
// 注意：本题与主站 78 题相同： https://leetcode-cn.com/problems/subsets/ 
// Related Topics 位运算 数组 回溯 
// 👍 53 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 079
 * @see Subsets
 */
public class TVdhkn {
    public static void main(String[] args) {
        Solution1 solution = new TVdhkn().new Solution1();
        System.out.println(solution.subsets(new int[] {1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> subsets(int[] nums) {

            List<List<Integer>> res = new ArrayList<>();

            List<Integer> path = new ArrayList<>();//问题解的状态
            dfs(path, nums, 0, res);

            return res;
        }

        private void dfs(List<Integer> path, int[] nums, int i, List<List<Integer>> res) {
            //到达叶子节点
            if (i == nums.length ) {
                res.add(new ArrayList<>(path));
                return;
            }
            //选择将该元素加入集合
            path.add(nums[i]);
            i++;
            dfs(path, nums,i,res);
            i--;
            path.remove(path.size()-1);
            //不将该元素加入集合
            i++;
            dfs(path,nums,i,res);
            i--;

        }
    }

    class Solution1 {

        public List<List<Integer>> subsets(int[] nums) {

            List<List<Integer>> res = new ArrayList<>();//问题解的集合

            List<Integer> path = new ArrayList<>();//问题解
            dfs(path, nums, 0, res);

            return res;
        }

        private void dfs(List<Integer> path, int[] nums, int i, List<List<Integer>> res) {
            //if
            if (i == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }

            //不将该元素加入集合
            dfs(path, nums, i+1, res);

            //将该元素加入集合
            path.add(nums[i]);
            dfs(path, nums, i+1, res);
            path.remove(path.size() - 1);

        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}