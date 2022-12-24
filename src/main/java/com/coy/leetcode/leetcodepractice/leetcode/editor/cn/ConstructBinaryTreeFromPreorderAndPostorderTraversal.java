/**
 * 根据前序和后序遍历构造二叉树
 */
//给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵
//树的后序遍历，重构并返回二叉树。 
//
// 如果存在多个答案，您可以返回其中 任何 一个。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [1], postorder = [1]
//输出: [1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= preorder.length <= 30 
// 1 <= preorder[i] <= preorder.length 
// preorder 中所有值都 不同 
// postorder.length == preorder.length 
// 1 <= postorder[i] <= postorder.length 
// postorder 中所有值都 不同 
// 保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 290 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.HashMap;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.PreorderTraversal;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Tree;

/**
 * 889
 *
 * @see ConstructBinaryTreeFromPreorderAndInorderTraversal
 */
@Tree
@PreorderTraversal
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
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
        HashMap<Integer, Integer> valToIndex = new HashMap<>();

        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            for (int i = 0; i < postorder.length; i++) {
                valToIndex.put(postorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
        }

        private TreeNode build(int[] preorder, int preStart, int preEnd,
            int[] postorder, int postStart, int postEnd) {
            if (preStart > preEnd) {
                return null;
            }
            if (preStart == preEnd) {
                return new TreeNode(preorder[preStart]);
            }
            int rootVal = postorder[preStart];

            //怎么确定左子树的大小呢？前序遍历结果的第二个元素作为左子树的根节点的值

            int leftRootVal = preorder[preStart + 1];
            int index = valToIndex.get(leftRootVal);
            int leftSize = index - postStart + 1;
            TreeNode root = new TreeNode(rootVal);
            root.left = build(preorder, preStart + 1, preStart + leftSize,
                postorder, postStart, index);
            root.right = build(preorder, preStart + leftSize + 1, preEnd,
                postorder, index + 1, postEnd - 1);

            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}