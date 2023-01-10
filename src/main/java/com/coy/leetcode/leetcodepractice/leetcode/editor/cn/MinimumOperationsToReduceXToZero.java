/**
 * 将 x 减到 0 的最小操作数
 */
//给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改
// 数组以供接下来的操作使用。 
//
// 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,4,2,3], x = 5
//输出：2
//解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,6,7,8,9], x = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,2,20,1,1,3], x = 10
//输出：5
//解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 104 
// 1 <= x <= 109 
// 
// Related Topics 数组 哈希表 二分查找 前缀和 滑动窗口 
// 👍 257 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Medium;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.error.WrongMethod;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.solution.BeHelped;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.BinarySearch;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.HashTable;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.SlidingWindow;

/**
 * 1658
 */
@HashTable
@SlidingWindow
@BinarySearch
@Medium
@BeHelped
public class MinimumOperationsToReduceXToZero {
    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToReduceXToZero().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    @WrongMethod
    class Solution {
        public int minOperations(int[] nums, int x) {
            //
            int left = 0, right = nums.length - 1;
            int count = 0;

            //判断左边界大还是右边界大，然后剪去较大的边界，感觉这个解法是有问题的，假设x是2 数组值是1 1 3 那就不应该选择后者，难道还要用回溯？
            while (left <= right) {
                if (x == 0) {
                    return count;
                }
                if (nums[left] > nums[right]) {
                    x = x - nums[left];
                    left++;

                } else {
                    x = x - nums[right];
                    right--;
                }
                count++;

            }
            return -1;
        }
    }

    @WrongMethod
    class Solution2 {
        public int minOperations(int[] nums, int x) {
           //i sum 表示 数组前i个元素之和
            Map<Integer, List<Integer>> sumToIndex = new HashMap<>();
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum = sum + nums[i];
                List<Integer> integers = sumToIndex.get(sum);
                if (integers != null) {
                    integers.add(i);
                } else {
                    List<Integer> integerList = new ArrayList<>();
                    integerList.add(i);
                    sumToIndex.put(i, integerList);
                }
            }

            List<Integer> integers = sumToIndex.get(x);
            if (integers != null) {
                return integers.get(0);
            }
            return -1;

        }
    }


    class Solution3 {
        public int minOperations(int[] nums, int x) {
            int n = nums.length;
            int sum = Arrays.stream(nums).sum();

            if (sum < x) {
                return -1;
            }

            int right = 0;
            int lsum = 0, rsum = sum;
            int ans = n + 1;

            for (int left = -1; left < n; ++left) {
                if (left != -1) {
                    lsum += nums[left];
                }
                while (right < n && lsum + rsum > x) {
                    rsum -= nums[right];
                    ++right;
                }
                if (lsum + rsum == x) {
                    ans = Math.min(ans, (left + 1) + (n - right));
                }
            }

            return ans > n ? -1 : ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}