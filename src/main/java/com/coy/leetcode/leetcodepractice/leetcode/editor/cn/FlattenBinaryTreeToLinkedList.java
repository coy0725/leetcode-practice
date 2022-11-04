/**
* 二叉树展开为链表
* 
*/
//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// Related Topics 栈 树 深度优先搜索 链表 二叉树 
// 👍 1334 👎 0
	
package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.Stack;

/**
* 114
*/
public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
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
class Solution {
    public void flatten(TreeNode root) {

        //先序遍历
        //使用两个变量保存当前访问节点，和当前访问节点上一个访问节点
        TreeNode cur = root;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                //当前访问节点的前一个节点的左节点置为null，右节点指向当前节点
                if (prev==null){
                    prev =cur;
                }else {
                    prev.left=null;
                    prev.right= cur;
                    prev = cur;
                }
                //访问当前节点
                stack.push(cur.right);
                cur = cur.left;
            }
            cur = stack.pop();
        }
        //最后一个访问节点的左节点置为null,怎么处理来着？
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}