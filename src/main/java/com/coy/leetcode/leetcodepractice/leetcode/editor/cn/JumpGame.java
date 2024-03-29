/**
 * 跳跃游戏
 */
//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 2133 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Medium;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.error.Timeout;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.solution.BeHelped;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.solveDate.December2022;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.DynamicProgramming;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Greedy;

/**
 * 55
 */
@Medium
@Greedy
@December2022
@DynamicProgramming
@BeHelped
public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    @Timeout
    class Solution {
        private boolean reached;
        public boolean canJump(int[] nums) {
            //该位置可以跳跃的最大长度：也就是说在该位置能有n种选择
            jump(0, nums);
            return reached;
        }

        //定义的状态变量不同，我定义的是能否跳到目标位置，存在大量重复计算
        //对手这个定义的是当前能跳到的最大位置，和当前位置取比较
        private void jump(int cur, int[] nums) {
            if (cur == nums.length - 1) {
                reached = true;
            }
            if (reached) {
                return;
            }
            int step = nums[cur];
            if (step + cur >= nums.length - 1) {
                reached = true;
                return;
            }
            //都贪心了，怎么还是过不了
            //先尝试从最远的跳
            for (int i = step; i > 0; i--) {
                jump(cur + i, nums);
            }
        }
    }

    /**
     * 如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点
     * 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新
     * 如果可以一直跳到最后，就成功了
     */
    class Solution2 {
        public boolean canJump(int[] nums) {

            int maxPosix = 0;
            //不断更新能跳到的最远位置
            for (int curPosix = 0; curPosix < nums.length; curPosix++) {
                if (curPosix > maxPosix) {
                    return false;
                }
                maxPosix = Math.max(maxPosix, curPosix + nums[curPosix]);
            }
            return true;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}