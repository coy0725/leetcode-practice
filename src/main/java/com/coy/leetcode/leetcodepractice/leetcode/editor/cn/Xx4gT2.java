/**
 * 数组中的第 k 大的数字
 */
//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//
//
// 示例 1:
//
//
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//
//
// 示例 2:
//
//
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
//
//
//
// 提示：
//
//
// 1 <= k <= nums.length <= 104
// -104 <= nums[i] <= 104
//
//
//
//
// 注意：本题与主站 215 题相同： https://leetcode-cn.com/problems/kth-largest-element-in-an-
//array/
// Related Topics 数组 分治 快速选择 排序 堆（优先队列）
// 👍 54 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.PriorityQueue;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Medium;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Heap;

/**
 * 剑指 Offer II 076
 */
@Medium
@Heap
public class Xx4gT2 {
    public static void main(String[] args) {
        Solution solution = new Xx4gT2().new Solution();
        System.out.println(solution.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            //最小堆
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for (final int num : nums) {
                if (minHeap.size() < k) {
                    minHeap.offer(num);
                } else {
                    if (num > minHeap.peek()) {
                        minHeap.poll();
                        minHeap.offer(num);
                    }
                }
            }
            return minHeap.peek();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}