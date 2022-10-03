/**
* 只出现一次的数字
* 
*/
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 数组 
// 👍 2597 👎 0
	
package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
* 136
*/
public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> numToCount = new HashMap<>();
        for (final int num : nums) {
            numToCount.put(num,numToCount.getOrDefault(num,0)+1);
        }
        for (final Map.Entry<Integer, Integer> entry : numToCount.entrySet()) {
            if (entry.getValue()==1){
                return entry.getKey();
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}