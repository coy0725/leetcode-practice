/**
 * 全排列 II
 */
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
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
// Related Topics 数组 回溯 
// 👍 1239 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47
 */
public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            int len = nums.length;
            //使用一个动态数组保存所有可能的全排列
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }
            boolean[] used = new boolean[len];
            List<Integer> path = new ArrayList<>();
            Arrays.sort(nums);
            dfs(nums, len, 0, path, used, res);
            return res;
        }

        void dfs(int[] nums, int len, int dePath, List<Integer> path,
            boolean[] used, List<List<Integer>> res) {
            if (dePath == len) {
                res.add(new ArrayList<>(path));
                return;
            }

            //在非叶子结点处产生不同的分支，
            // 这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
            for (int i = 0; i < len; i++) {
                if (used[i]) {
                    continue;
                }
                // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
                // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
                if (i>0 && nums[i] == nums[i-1] &&!used[i-1]){
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;

                dfs(nums,len,dePath+1,path,used,res);
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，
                // 代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}