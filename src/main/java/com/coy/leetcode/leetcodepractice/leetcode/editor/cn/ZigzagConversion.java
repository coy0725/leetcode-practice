/**
 * Z 字形变换
 */
//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 
// 👍 1913 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

/**
 * 6
 * @see ShunShiZhenDaYinJuZhenLcof
 */
public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            //我以为是Z,其实是N

            //step1 N字形排列
            //numRows了矩阵的高度,那么矩阵的长度怎么确定呢？
            // numRows+numRows-2=元素个数
            // 1+numRows-2
            // 列数 s.length/(numRows+numRows-2)*(1+numRows-2)

            char[][] matrix = new char[numRows][(s.length() / (numRows + numRows - 2) * (1 + numRows - 2))];

            //从上到下：[index++][left]
            //从下到上：[index--][left]
            //左下到右上：[index--][left++]

            int top = 0;
            int bottom = numRows - 1;
            int left = 0;
            int index = 0;
            while (true) {
                //从上到下：[index++][left]
                for (int i = 0; i <= bottom&&index<s.length(); i++) {
                    matrix[i][left] = s.charAt(index++);
                }
                if (index >= s.length()) {
                    break;
                }
                //左下到右上：[index--][left++]
                for (int i = bottom; i <= top&&index<s.length(); i--) {
                    matrix[i][left++] = s.charAt(index++);
                }
                if (index >= s.length()) {
                    break;
                }

            }


            //step2 Z字形扫描 从左往右一行行扫描
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j]!='\u0000'){
                        sb.append(matrix[i][j]);
                    }

                }
            }


            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}