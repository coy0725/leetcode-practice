/**
 * 二叉树的最近公共祖先
 */
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 105] 内。 
// -109 <= Node.val <= 109 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 2076 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.PreorderTraversal;

/**
 * 236
 */
@PreorderTraversal
public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            //考虑通过递归对二叉树进行先序遍历，当遇到节点 p 或 q 时返回。从底至顶回溯，
            // 当节点 p, q 在节点 root 的异侧时，节点 root 即为最近公共祖先，则向上返回 root 。
            if (root == null || root == p || root == q) {
                return root;
            }
            //访问左子树
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            //访问右子树
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return root;
        }
    }

    /**
     * 适用于任意 k 个数的共同祖先的解法，时间空间都是O（n）
     *
     * 核心是：如果某节点遍历左右子树后k值由k变为0，表明该节点为所需节点
     */
    class Solution2 {
        private TreeNode res;
        private int k;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            k = 2;
            dfs(root, p, q);
            return res;
        }

        private void dfs(TreeNode root, TreeNode p, TreeNode q) {
            if (res != null || root == null || k == 0) return;
            int kOld = k;
            if (root.val == p.val || root.val == q.val) k--;
            dfs(root.left, p, q);
            dfs(root.right, p, q);
            if (kOld == 2 && k == 0 && res == null)
                res = root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}