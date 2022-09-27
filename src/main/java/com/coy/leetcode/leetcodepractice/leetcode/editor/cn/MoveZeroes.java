/**
 * 移动零
 */
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1236 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

/**
 * 283
 */
public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            //i与i+1比较，如果i+1为0，i不为0,则两个位置的元素进行交换
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] != 0 && nums[i + 1] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}