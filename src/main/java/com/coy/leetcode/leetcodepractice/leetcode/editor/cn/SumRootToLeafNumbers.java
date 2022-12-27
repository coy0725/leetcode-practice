/**
 * 求根节点到叶节点数字之和
 */
//给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
// 
// 
// 每条从根节点到叶节点的路径都代表一个数字： 
//
// 
// 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。 
// 
//
// 计算从根节点到叶节点生成的 所有数字之和 。 
//
// 叶节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：25
//解释：
//从根到叶子节点路径 1->2 代表数字 12
//从根到叶子节点路径 1->3 代表数字 13
//因此，数字总和 = 12 + 13 = 25 
//
// 示例 2： 
//
// 
//输入：root = [4,9,0,5,1]
//输出：1026
//解释：
//从根到叶子节点路径 4->9->5 代表数字 495
//从根到叶子节点路径 4->9->1 代表数字 491
//从根到叶子节点路径 4->0 代表数字 40
//因此，数字总和 = 495 + 491 + 40 = 1026
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 1000] 内 
// 0 <= Node.val <= 9 
// 树的深度不超过 10 
// 
// 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 592 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Medium;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.BackTracing;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.DepthFirstSearch;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Tree;

/**
 * 129
 */
@Tree
@Medium
@DepthFirstSearch
@BackTracing
public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        Solution solution = new SumRootToLeafNumbers().new Solution();
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
        public int sumNumbers(TreeNode root) {
            //使用一个状态代表根节点到叶子节点的值，叶子节点即无孩子节点的节点
            //用什么保存这个数值的状态呢？一个数组？

            List<Integer> nums = new ArrayList<>();

            LinkedList<Integer> val = new LinkedList<>();

            dfs(nums, root, val);
            return nums.stream().mapToInt(Integer::intValue).sum();

        }

        private void dfs(List<Integer> nums, TreeNode root, LinkedList<Integer> val) {
            if (root == null) {
                return;
            }
            val.addLast(root.val);
            if (root.left == null && root.right == null) {
                nums.add(Integer.valueOf(val.stream().map(Object::toString).collect(Collectors.joining())));
            }
            dfs(nums, root.left, val);
            dfs(nums, root.right, val);
            val.removeLast();
        }
    }

    class Solution2 {
        int res = 0;
        public int sumNumbers(TreeNode root) {
            //使用非对象型变量，可以解决状态回溯问题
            backtrack(root,0);
            return res;

        }

        private void backtrack(TreeNode root, int sum) {
            if (root == null) {
                return;
            }
            sum = sum*10+root.val;
            if (root.left == null && root.right == null) {
                res = res + sum;
                return;
            }
            backtrack(root.left, sum);
            backtrack(root.right, sum);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}