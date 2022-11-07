/**
* 二叉搜索树中两个节点之和
* 
*/
//给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。 
//
// 
//
// 示例 1： 
//
// 
//输入: root = [8,6,10,5,7,9,11], k = 12
//输出: true
//解释: 节点 5 和节点 7 之和等于 12
// 
//
// 示例 2： 
//
// 
//输入: root = [8,6,10,5,7,9,11], k = 22
//输出: false
//解释: 不存在两个节点值之和为 22 的节点
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [1, 104]. 
// -104 <= Node.val <= 104 
// root 为二叉搜索树 
// -105 <= k <= 105 
// 
//
// 
//
// 注意：本题与主站 653 题相同： https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树 
// 👍 45 👎 0
	
package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
* 剑指 Offer II 056
*/
public class OpLdQZ {
    public static void main(String[] args) {
        Solution solution = new OpLdQZ().new Solution();

        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);

        node8.left=node6;
        node8.right=node10;
        node6.left=node5;
        node6.right=node7;
        node10.left=node9;
        node10.right=node11;
        System.out.println(solution.findTarget(node8, 12));

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
    public boolean findTarget(TreeNode root, int k) {
        boolean isFind = false;
        List<Integer> integers = inOrderTraversal(root);
        if (integers.isEmpty()||integers.size()<2){
            return isFind;
        }
        int left = 0;
        int right = integers.size()-1;

        while (left < right) {
            int sum = integers.get(left) + integers.get(right);
            if (sum ==k){
                isFind = true;
                break;
            }
            else if (sum>k){
                right--;
            }
            else if (sum<k){
                left++;
            }
        }


        return isFind;
    }


    public List<Integer> inOrderTraversal(TreeNode root){

        List<Integer> nodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur =root;

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

}
//leetcode submit region end(Prohibit modification and deletion)

}