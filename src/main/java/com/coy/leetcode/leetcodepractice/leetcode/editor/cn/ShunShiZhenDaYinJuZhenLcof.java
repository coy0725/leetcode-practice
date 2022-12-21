/**
 * 顺时针打印矩阵
 */
//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 
// 👍 479 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * 剑指 Offer 29
 */
public class ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
    }
    //1 2 3
    //4 5 6
    //7 8 9
    //打印：1 2 3 6 9 8 7 4 5
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix.length == 0) {
                return new int[0];
            }
            LinkedList<Integer> list = new LinkedList<>();

            int left = 0;
            int right = matrix[0].length - 1;
            int top = 0;
            int bottom = matrix.length - 1;
            while (true) {
                //left->right
                for (int i = left; i <= right; i++) {
                    list.addLast(matrix[top][i]);
                }
                if (++top > bottom) {
                    break;
                }
                //top->bottom
                for (int i = top; i <= bottom; i++) {
                    list.addLast(matrix[i][right]);
                }
                if (left > --right) {
                    break;
                }
                //right->left
                for (int i = right; i >=left ; i--) {
                    list.addLast(matrix[bottom][i]);
                }
                if (top > --bottom) {
                    break;
                }
                //bottom->top
                for (int i = bottom; i >= top; i--) {
                    list.addLast(matrix[i][left]);
                }
                if (++left > right) {
                    break;
                }
            }


            return list.stream().mapToInt(t-> t).toArray();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}