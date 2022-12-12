/**
 * 展平二叉搜索树
 */
//给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
//输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [5,1,7]
//输出：[1,null,5,null,7]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的取值范围是 [1, 100] 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 注意：本题与主站 897 题相同： https://leetcode-cn.com/problems/increasing-order-search-tr
//ee/ 
// Related Topics 栈 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 45 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 剑指 Offer II 052
 */
public class NYBBNL {
    public static void main(String[] args) {
        Solution solution = new NYBBNL().new Solution();
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        node2.left = node1;
        node2.right = node4;
        node4.left = node3;
        solution.increasingBST(node2);
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
        public TreeNode increasingBST(TreeNode root) {
            //step1:通过中序遍历，将节点从小到大存储到链表里
            List<TreeNode> nodes = inOrderDfs(root);
            if (nodes.size() == 0 || nodes.size() == 1) {
                return root;
            }
            //step2:遍历链表里的节点，将节点左指针置空，右指针指向链表中的下一个节点
            for (int i = 0; i < nodes.size() - 1; i++) {
                TreeNode cur = nodes.get(i);
                TreeNode next = nodes.get(i + 1);
                cur.left = null;
                cur.right = next;
            }
            nodes.get(nodes.size() - 1).left = null;
            return nodes.get(0);
        }

        private List<TreeNode> inOrderDfs(TreeNode root) {
            List<TreeNode> nodes = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }

                cur = stack.pop();
                nodes.add(cur);
                cur = cur.right;
            }

            return nodes;
        }

        private TreeNode increasingBST2(TreeNode root) {

            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            TreeNode prev = null;
            TreeNode first = null;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }

                cur = stack.pop();
                if (prev == null) {
                    first = cur;
                } else {
                    prev.right = cur;
                }

                prev = cur;
                cur.left = null;
                cur = cur.right;
            }

            return first;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}