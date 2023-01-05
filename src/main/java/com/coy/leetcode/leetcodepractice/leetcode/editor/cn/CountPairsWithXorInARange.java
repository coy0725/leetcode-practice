/**
 * 统计异或值在范围内的数对有多少
 */
//给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数：low 和 high ，请返回 漂亮数对 的数目。 
//
// 漂亮数对 是一个形如 (i, j) 的数对，其中 0 <= i < j < nums.length 且 low <= (nums[i] XOR nums[
//j]) <= high 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,4,2,7], low = 2, high = 6
//输出：6
//解释：所有漂亮数对 (i, j) 列出如下：
//    - (0, 1): nums[0] XOR nums[1] = 5 
//    - (0, 2): nums[0] XOR nums[2] = 3
//    - (0, 3): nums[0] XOR nums[3] = 6
//    - (1, 2): nums[1] XOR nums[2] = 6
//    - (1, 3): nums[1] XOR nums[3] = 3
//    - (2, 3): nums[2] XOR nums[3] = 5
// 
//
// 示例 2： 
//
// 输入：nums = [9,8,4,2,1], low = 5, high = 14
//输出：8
//解释：所有漂亮数对 (i, j) 列出如下：
//​​​​​    - (0, 2): nums[0] XOR nums[2] = 13
//    - (0, 3): nums[0] XOR nums[3] = 11
//    - (0, 4): nums[0] XOR nums[4] = 8
//    - (1, 2): nums[1] XOR nums[2] = 12
//    - (1, 3): nums[1] XOR nums[3] = 10
//    - (1, 4): nums[1] XOR nums[4] = 9
//    - (2, 3): nums[2] XOR nums[3] = 6
//    - (2, 4): nums[2] XOR nums[4] = 5 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// 1 <= nums[i] <= 2 * 104 
// 1 <= low <= high <= 2 * 104 
// 
// Related Topics 位运算 字典树 数组 
// 👍 151 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Hard;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.solution.BeHelped;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.BitOperation;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Tree;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Trie;

/**
 * 1803
 */
@Hard
@BitOperation
@Tree
@BeHelped
@Trie
public class CountPairsWithXorInARange {
    public static void main(String[] args) {
        Solution solution = new CountPairsWithXorInARange().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 字典树的根节点
        private Trie root = null;
        // 最高位的二进制位编号为 14
        private static final int HIGH_BIT = 14;

        public int countPairs(int[] nums, int low, int high) {
            return f(nums, high) - f(nums, low - 1);
        }

        public int f(int[] nums, int x) {
            root = new Trie();
            int res = 0;
            for (int i = 1; i < nums.length; i++) {
                add(nums[i - 1]);
                res += get(nums[i], x);
            }
            return res;
        }

        public void add(int num) {
            Trie cur = root;
            for (int k = HIGH_BIT; k >= 0; k--) {
                int bit = (num >> k) & 1;
                if (cur.son[bit] == null) {
                    cur.son[bit] = new Trie();
                }
                cur = cur.son[bit];
                cur.sum++;
            }
        }

        public int get(int num, int x) {
            Trie cur = root;
            int sum = 0;
            for (int k = HIGH_BIT; k >= 0; k--) {
                int r = (num >> k) & 1;
                if (((x >> k) & 1) != 0) {
                    if (cur.son[r] != null) {
                        sum += cur.son[r].sum;
                    }
                    if (cur.son[r ^ 1] == null) {
                        return sum;
                    }
                    cur = cur.son[r ^ 1];
                } else {
                    if (cur.son[r] == null) {
                        return sum;
                    }
                    cur = cur.son[r];
                }
            }
            sum += cur.sum;
            return sum;
        }
    }

    class Trie {
        // son[0] 表示左子树，son[1] 表示右子树
        Trie[] son = new Trie[2];
        int sum;

        public Trie() {
            sum = 0;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}