/**
* 二叉树每层的最大值
* 
*/
//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。 
//
// 
//
// 示例1： 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
//解释:
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
//解释:
//          1
//         / \
//        2   3
// 
//
// 示例3： 
//
// 
//输入: root = [1]
//输出: [1]
// 
//
// 示例4： 
//
// 
//输入: root = [1,null,2]
//输出: [1,2]
//解释:      
//           1 
//            \
//             2     
// 
//
// 示例5： 
//
// 
//输入: root = []
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,104] 
// -231 <= Node.val <= 231 - 1 
// 
//
// 
//
// 注意：本题与主站 515 题相同： https://leetcode-cn.com/problems/find-largest-value-in-each
//-tree-row/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 32 👎 0
	
package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
* 剑指 Offer II 044
*/
public class HPov7L {
    public static void main(String[] args) {
        Solution solution = new HPov7L().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> rlt = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //记录每一层节点个数：第一层肯定是1
        int levelNodeCount = 1;//记录每一层节点个数，初始为1
        int levelMaxValue = Integer.MIN_VALUE;//记录每一层节点最大值
        while (Objects.nonNull(queue.peek())){
            TreeNode poll = queue.poll();
            levelMaxValue=Math.max(levelMaxValue,poll.val);
            levelNodeCount--;
            if (levelNodeCount==0){
                rlt.add(levelMaxValue);
            }
            if (poll.left!=null){
                queue.offer(poll.left);
                levelNodeCount++;
            }
            if (poll.right!=null){
                queue.offer(poll.right);
                levelNodeCount++;
            }
        }
        return rlt;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}