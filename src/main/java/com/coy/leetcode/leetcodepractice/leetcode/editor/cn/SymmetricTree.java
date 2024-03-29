/**
 * 对称二叉树
 */
//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 2221 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.error.WrongMethod;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.BFS;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Palindrome;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Tree;

/**
 * 101
 */
@BFS
@Tree
@Palindrome
public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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
    @WrongMethod
    class Solution {
        private ArrayList<Integer> left = new ArrayList<>();
        private ArrayList<Integer> right = new ArrayList<>();
        public boolean isSymmetric(TreeNode root) {
            //step 1 该题需要广度遍历整棵树，比较每一层的节点是否对称
            //step 2 将每一层的节点使用一个数组进行保存，判断该层数组中的值是否为回文？好像也不大对
            //在这个基础上再加一个限制条件，左右子树高度一样？？

            //换一种思路 前序遍历，先root，再left,后right  后者是先root 再right 再left


            dfsLeft(root);
            dfsRight(root);


            return isEquals();
        }

        private boolean isEquals() {
            for (int i = 0; i < left.size(); i++) {
                if (!left.get(i).equals(right.get(i))) {
                    return false;
                }
            }
            return true;
        }

        private void dfsRight(TreeNode root) {
            if (root == null) {
                return;
            }

            dfsRight(root.right);
            right.add(root.val);
            dfsRight(root.left);

        }

        private void dfsLeft(TreeNode root) {
            if (root == null) {
                return;
            }

            dfsLeft(root.left);
            left.add(root.val);
            dfsLeft(root.right);

        }
    }

    /**
     * 我们可以实现这样一个递归函数，通过「同步移动」两个指针的方法来遍历这棵树，
     * p 指针和 q 指针一开始都指向这棵树的根，随后 p 右移时，q 左移，p 左移时,q 右移。
     * 每次检查当前 p 和 q 节点的值是否相等，如果相等再判断左右子树是否对称。

     */
    class Solution2 {
        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }

        public boolean check(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}