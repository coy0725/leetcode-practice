/**
 * 从前序与中序遍历序列构造二叉树
 */
//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 1814 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.HashMap;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.PreorderTraversal;

/**
 * 105
 */
@PreorderTraversal
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        // 存储 inorder 中值到索引的映射
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                valToIndex.put(inorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

        }

        private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart,
            int inEnd) {
            if (preStart > preEnd) {
                return null;
            }
            //root 节点对应的值是前序遍历数组的第一个元素
            int rootVal = preorder[preStart];
            //找到中序遍历数组中rootVal所在的索引位置
            int index = valToIndex.get(rootVal);
            TreeNode root = new TreeNode(rootVal);
            int leftSize = index - inStart;//左子树节点个数
            root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
            root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);

            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}