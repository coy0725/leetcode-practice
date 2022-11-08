/**
 * 出现频率最高的 k 个数字
 */
//给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// 
//
// 注意：本题与主站 347 题相同：https://leetcode-cn.com/problems/top-k-frequent-elements/ 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 
// 👍 42 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 剑指 Offer II 060
 */
public class G5c51o {
    public static void main(String[] args) {
        Solution solution = new G5c51o().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private PriorityQueue<Integer> minHeap;
        private int size;
        private HashMap<Integer,Integer> keyToCount;
        public int[] topKFrequent(int[] nums, int k) {
            minHeap = new PriorityQueue<>();
            size = k;
            keyToCount = new HashMap<>();
            for (final int num : nums) {
                keyToCount.put(num,keyToCount.getOrDefault(num,0)+1);
                Integer count = keyToCount.get(num);
                if (minHeap.size()<k){
                    minHeap.offer(num);
                }else {
                    Integer heapCount = keyToCount.get(minHeap.peek());
                    if (heapCount < count) {
                        minHeap.offer(num);
                        minHeap.poll();
                    }

                }
            }
            int[] rlt = new int[minHeap.size()];
            for (int i = 0; i < minHeap.size(); i++) {
                rlt[i] = minHeap.poll();
            }
            return rlt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}