/**
 * 旋转图像
 */
//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
// Related Topics 数组 数学 矩阵 
// 👍 1509 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Medium;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.solveDate.December2022;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Matrix;

/**
 * 48
 */
@Medium
@Matrix
@December2022
public class RotateImage {
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            //应该怎么变换矩阵呢,我知道他会变换成什么样子，那应该如何算程序语句来描述呢
            //m*n的矩阵
            //0,0--0,n-1
            //m-1--m-1,n-1
            //step1 旋转最外层
            for (int i = matrix.length; i > 1; i = i - 2) {
                rotation(matrix,matrix.length);
            }

        }

        //写起来好麻烦啊
        private void rotation(int[][] matrix, int length) {
            //step1 将上面旋转到右边


            //step2 将左边旋转到下面

            //step3 将下面旋转到左边

            //step3 将左边旋转到
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}