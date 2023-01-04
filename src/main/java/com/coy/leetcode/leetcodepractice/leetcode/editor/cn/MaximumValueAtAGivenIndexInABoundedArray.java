/**
 * 有界数组中指定下标处的最大值
 */
//给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：
//
//
// nums.length == n
// nums[i] 是 正整数 ，其中 0 <= i < n
// abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
// nums 中所有元素之和不超过 maxSum
// nums[index] 的值被 最大化
//
//
// 返回你所构造的数组中的 nums[index] 。
//
// 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。
//
//
//
// 示例 1：
//
// 输入：n = 4, index = 2,  maxSum = 6
//输出：2
//解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
//
//
// 示例 2：
//
// 输入：n = 6, index = 1,  maxSum = 10
//输出：3
//
//
//
//
// 提示：
//
//
// 1 <= n <= maxSum <= 109
// 0 <= index < n
//
// Related Topics 贪心 二分查找
// 👍 159 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Medium;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.BinarySearch;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Greedy;

/**
 * 1802
 */
@Greedy
@BinarySearch
@Medium
public class MaximumValueAtAGivenIndexInABoundedArray {
    public static void main(String[] args) {
        Solution solution = new MaximumValueAtAGivenIndexInABoundedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 根据题意，需要构造一个长度为 nn 的数组 nums，所有元素均为正整数，元素之和不超过 maxSum，相邻元素之差不超过 1，
     * 且需要最大化 nums[index]。
     * 根据贪心的思想，可以使 nums[index] 成为数组最大的元素，并使其他元素尽可能小，即从 nums[index] 开始，
     * 往左和往右，下标每相差 1，元素值就减少 1，直到到达数组边界，或者减少到仅为 1 后保持为 11 不变。
     *
     * 根据这个思路，一旦 nums[index] 确定后，这个数组的和 numsSum 也就确定了。
     * 并且 nums[index] 越大，数组和 numsSum 也越大。据此，可以使用二分搜索来找出最大的使得  numsSum≤maxSum 成立的 nums[index]。
     *
     * 代码实现上，二分搜索的左边界为 11，右边界为 maxSum。函数 \textit{valid}valid 用来判断当前的 nums[index]
     * 对应的 numsSum 是否满足条件。numsSum 由三部分组成，nums[index]，nums[index] 左边的部分之和，
     * 和 nums[index] 右边的部分之和。\textit{cal}cal 用来计算单边的元素和，需要考虑边界元素是否早已下降到 11 的情况。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/solution/you-jie-shu-zu-zhong-zhi-ding-xia-biao-c-aav4/
     */
    class Solution {
        public int maxValue(int n, int index, int maxSum) {
            int left = 1, right = maxSum;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (valid(mid, n, index, maxSum)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        public boolean valid(int mid, int n, int index, int maxSum) {
            int left = index;
            int right = n - index - 1;
            return mid + cal(mid, left) + cal(mid, right) <= maxSum;
        }

        public long cal(int big, int length) {
            if (length + 1 < big) {
                int small = big - length;
                return (long) (big - 1 + small) * length / 2;
            } else {
                int ones = length - (big - 1);
                return (long) big * (big - 1) / 2 + ones;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}