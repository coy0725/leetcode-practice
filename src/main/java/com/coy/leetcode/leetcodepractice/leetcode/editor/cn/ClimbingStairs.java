/**
 * 爬楼梯
 */
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 2674 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.HashMap;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.DynamicProgramming;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.HashTable;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Math;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Memoization;

/**
 * 70
 */
@DynamicProgramming
@Math
@Memoization
@HashTable
public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        System.out.println(solution.climbStairs(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<Integer, Integer> nToCount = new HashMap<>();

        public int climbStairs(int n) {
            if (nToCount.get(n) != null) {
                return nToCount.get(n);
            } else if (n == 1) {
                nToCount.put(1, 1);
                return 1;
            } else if (n == 2) {
                nToCount.put(2, 2);
                return 2;
            } else if (n > 2) {
                nToCount.put(n - 1, climbStairs(n - 1));
                nToCount.put(n - 2, climbStairs(n - 2));
                return climbStairs(n - 1) + climbStairs(n - 2);
            }
            return 0;
        }

        public int climbStairs2(int n) {
            int p = 0;
            int q = 0;
            int r = 1;
            for (int i = 0; i < n; i++) {
                p = q;
                q = r;
                r = p + q;
            }
            return r;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}