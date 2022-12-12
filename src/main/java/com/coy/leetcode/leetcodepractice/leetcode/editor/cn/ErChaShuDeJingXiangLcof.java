/**
 * 二叉树的镜像
 */
//请完成一个函数，输入一个二叉树，该函数输出它的镜像。 
//
// 例如输入： 
//
// 4 
// / \ 
// 2 7 
// / \ / \ 
//1 3 6 9 
//镜像输出： 
//
// 4 
// / \ 
// 7 2 
// / \ / \ 
//9 6 3 1 
//
// 
//
// 示例 1： 
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 316 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

/**
 * 剑指 Offer 27
 */
public class ErChaShuDeJingXiangLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaShuDeJingXiangLcof().new Solution();
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
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode left = mirrorTree(root.left);
            TreeNode right = mirrorTree(root.right);

            root.right = left;
            root.left = right;
            return root;
        }
    }

    class Solution2 {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {
                return root;
            }
            //将左子树镜像
            TreeNode left = mirrorTree(root.left);
            //将右子树镜像
            TreeNode right = mirrorTree(root.right);

            //左右子树互换
            root.right = left;
            root.left = right;
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}