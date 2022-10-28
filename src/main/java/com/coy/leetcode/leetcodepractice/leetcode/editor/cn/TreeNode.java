package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

/**
 * @author coy
 * @since 2022/10/28
 **/
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
