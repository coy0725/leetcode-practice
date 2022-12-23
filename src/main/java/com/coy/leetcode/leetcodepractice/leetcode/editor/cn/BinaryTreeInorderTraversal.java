/**
 * 二叉树的中序遍历
 */
//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 1605 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.DepthFirstSearch;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Iterator;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Recursion;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Tree;

/**
 * 94
 */
@DepthFirstSearch
@com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Stack
@Tree
@Recursion
@Iterator
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> rlt = new ArrayList<>();
            dfs(root, rlt);
            return rlt;
        }

        private void dfs(TreeNode root, List<Integer> rlt) {
            if (root != null) {
                dfs(root.left, rlt);
                rlt.add(root.val);
                dfs(root.right, rlt);
            }
        }

        public List<Integer> inorderTraversal2(TreeNode root) {
            List<Integer> nodes = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            //定义一个当前正在访问的节点
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                //先访问到最下层的最左节点，
                cur = stack.pop();
                nodes.add(cur.val);//访问最左节点
                cur = cur.right;//这一句是什么意思呢，去掉和cur=null都是错误的
            }

            //先访问左子树，再访问根节点，再访问右子树

            return nodes;
        }

        public List<Integer> inorderTraversal3(TreeNode root) {
            List<Integer> nodes = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur;

            cur = root;

            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();//当前正在访问的节点
                nodes.add(cur.val);//访问当前节点
                cur = cur.right;//访问当前节点的右节点

            }
            return nodes;
        }

        public List<Integer> inorderTraversal4(TreeNode root) {
            List<Integer> nodes = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;

            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                nodes.add(cur.val);
                cur = cur.right;

            }

            return nodes;
        }

        public List<Integer> inorderTraversal5(TreeNode root) {

            List<Integer> nodes = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;

            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                nodes.add(cur.val);//访问当前节点
                cur = cur.right;//访问当前节点右节点
            }

            return nodes;
        }

        public List<Integer> inorderTraversal6(TreeNode root) {
            List<Integer> nodes = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                nodes.add(cur.val);
                cur = cur.right;

            }

            return nodes;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Solution5 {
        //左子树-根节点-右子树
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> nodes = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curVisit = root;
            while (curVisit != null || !stack.isEmpty()) {
                while (curVisit != null) {
                    stack.push(curVisit);
                    curVisit = curVisit.left;
                }
                TreeNode pop = stack.pop();
                //访问最左节点
                nodes.add(pop.val);
                curVisit = pop.right;
            }
            return nodes;
        }

    }
}