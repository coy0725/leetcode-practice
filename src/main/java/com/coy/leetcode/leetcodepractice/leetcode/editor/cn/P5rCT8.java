/**
* 二叉搜索树中的中序后继
* 
*/
//给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。 
//
// 节点 p 的后继是值比 p.val 大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [2,1,3], p = 1
//输出：2
//解释：这里 1 的中序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [5,3,6,2,4,null,null,1], p = 6
//输出：null
//解释：因为给出的节点没有中序后继，所以答案就返回 null 了。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 104] 内。 
// -105 <= Node.val <= 105 
// 树中各节点的值均保证唯一。 
// 
//
// 
//
// 注意：本题与主站 285 题相同： https://leetcode-cn.com/problems/inorder-successor-in-bst/ 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 65 👎 0
	
package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.Stack;

/**
* 剑指 Offer II 053
*/
public class P5rCT8 {
    public static void main(String[] args) {
        Solution solution = new P5rCT8().new Solution();
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        boolean found =false;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        TreeNode rlt = null;

        while (cur!=null || !stack.isEmpty()){
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (cur.val==p.val){
                found= true;
            }
            if (found){
                rlt =cur;
                break;
            }
            cur=cur.right;
        }
        return rlt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}