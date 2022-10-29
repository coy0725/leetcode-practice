/**
 * 二叉树的后序遍历
 */
//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
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
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 934 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145
 */
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorderTraversal(TreeNode root) {

            List<Integer> nodes = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;//当前访问节点
            TreeNode prev = null;//遍历过的前一个节点

            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.peek();
                //当前节点有右子节点，并且右子节点不是前一个遍历节点（最左节点，没有左子节点，有右子节点）
                if (cur.right != null && cur.right != prev) {
                    cur = cur.right;
                } else {
                    stack.pop();
                    nodes.add(cur.val);
                    prev = cur;
                    cur = null;
                }

            }
            return nodes;
        }

        public List<Integer> postorderTraversal2(TreeNode root){
            List<Integer> nodes = new ArrayList<>();
            TreeNode cur = root;
            TreeNode pre = null;
            Stack<TreeNode> stack = new Stack<>();

            while (cur!= null && !stack.isEmpty()){
                while (cur!=null){
                    stack.push(cur);
                    cur= cur.left;
                }

                if (cur.right!=null && cur.right!=pre){
                    stack.push(cur.right);
                    pre = cur.right;
                    cur = null;
                }else {
                    TreeNode node = stack.pop();
                    nodes.add(node.val);
                    pre = node;
                }

            }
            return nodes;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}