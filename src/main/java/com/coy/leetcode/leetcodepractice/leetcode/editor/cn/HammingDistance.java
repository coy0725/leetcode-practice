/**
 * 汉明距离
 */
//两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 1, y = 4
//输出：2
//解释：
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//上面的箭头指出了对应二进制位不同的位置。
// 
//
// 示例 2： 
//
// 
//输入：x = 3, y = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x, y <= 231 - 1 
// 
// Related Topics 位运算 
// 👍 652 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

/**
 * 461
 */
public class HammingDistance {
    public static void main(String[] args) {
        Solution solution = new HammingDistance().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hammingDistance(int x, int y) {
            int s = x ^ y;
            //计算一个整形二进制位1的个数
            int count = 0;
            while (s != 0) {
                count = count + s & 1;
                s = s >> 1;
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
    class Solution2 {
        public int hammingDistance(int x, int y) {
            //异或运算：相同为0不同为1
            int s = x ^ y;
            //计算一个整形二进制位1的个数
            int count = 0;

            // 计算s中有多少个为1的二进制位
            while (s != 0) {
                //与运算：相同为1，不同为0
                count = count + s & 1;
                //右移
                s = s >> 1;
            }
            return count;
        }
    }

}