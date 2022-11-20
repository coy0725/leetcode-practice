/**
 * 子集
 */
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
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
// Related Topics 位运算 数组 回溯 
// 👍 1860 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 78
 */
public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {

            List<List<Integer>> result = new ArrayList<>();
            //step1:空集加入结果集
            result.add(new ArrayList<>());
            //step2:遍历数组，将每个数字生成的子集加入结果集
            for (final int num : nums) {
                Iterator<List<Integer>> iterator = result.iterator();
                //获取当前数字能生成的子集,也就是遍历结果集前一个状态下的所有子集，将当前元素加入进去
                List<List<Integer>> curNumLists = new ArrayList<>();
                while (iterator.hasNext()) {
                    ArrayList<Integer> integers = new ArrayList<>(iterator.next());
                    integers.add(num);
                    curNumLists.add(integers);
                }
                result.addAll(curNumLists);
            }

            //step3:返回结果集
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}