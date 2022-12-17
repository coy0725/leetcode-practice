/**
 * 最大交换
 */
//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 108] 
// 
// Related Topics 贪心 数学 
// 👍 381 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

/**
 * 670
 */
public class MaximumSwap {
    public static void main(String[] args) {
        Solution solution = new MaximumSwap().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSwap(int num) {
            String numString = String.valueOf(num);
            int left = 0;
            int right = numString.length() - 1;
            //如果数字是单调递减的则不需要进行交换
            //优先交换最高位的
            while (left < right) {

            }
            return 0;
        }
    }

    class Solution2 {
        public int maximumSwap(int num) {
            char[] charArray = String.valueOf(num).toCharArray();
            int n = charArray.length;
            int maxIdx = n - 1;
            int idx1 = -1, idx2 = -1;
            //从右往左遍历
            for (int i = n - 1; i >= 0; i--) {
                //更新数值最大的数组下标位置
                if (charArray[i] > charArray[maxIdx]) {
                    maxIdx = i;
                    //说明不是单调递减的
                } else if (charArray[i] < charArray[maxIdx]) {
                    idx1 = i;
                    idx2 = maxIdx;
                }
            }

            if (idx1 >= 0) {
                swap(charArray, idx1, idx2);
                return Integer.parseInt(new String(charArray));
            } else {
                return num;
            }
        }

        private void swap(char[] charArray, int idx1, int idx2) {
            char temp = charArray[idx1];
            charArray[idx1] = charArray[idx2];
            charArray[idx2] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}