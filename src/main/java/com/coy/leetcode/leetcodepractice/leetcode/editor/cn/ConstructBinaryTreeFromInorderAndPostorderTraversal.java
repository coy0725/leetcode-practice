/**
 * 从中序与后序遍历序列构造二叉树
 */
//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
//
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 899 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.HashMap;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.PreorderTraversal;

/**
 * 106
 * @see  ConstructBinaryTreeFromPreorderAndInorderTraversal
 */
@PreorderTraversal
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
        // 存储 inorder 中值到索引的映射
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for (int i = 0; i < inorder.length; i++) {
                valToIndex.put(inorder[i], i);
            }
            return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode build(int[] postorder, int postStart, int postEnd, int[] inorder,
            int inStart, int inEnd) {
            if (postStart > postEnd) {
                return null;
            }
            //root节点对应值是后续遍历数组最后一个元素
            int rootVal = postorder[postEnd];
            int index = valToIndex.get(rootVal);
            TreeNode root = new TreeNode(rootVal);
            int leftSize = index - inStart;
            root.left = build(postorder, postStart, postStart + leftSize-1,
                inorder, inStart, index - 1);
            root.right = build(postorder, postStart + leftSize, postEnd-1,
                inorder, index+1, inEnd);
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}