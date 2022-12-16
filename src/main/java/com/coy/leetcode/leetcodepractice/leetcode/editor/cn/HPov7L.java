/**
 * 二叉树每层的最大值
 */
//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。 
//
// 
//
// 示例1： 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
//解释:
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
//解释:
//          1
//         / \
//        2   3
// 
//
// 示例3： 
//
// 
//输入: root = [1]
//输出: [1]
// 
//
// 示例4： 
//
// 
//输入: root = [1,null,2]
//输出: [1,2]
//解释:      
//           1 
//            \
//             2     
// 
//
// 示例5： 
//
// 
//输入: root = []
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,104] 
// -231 <= Node.val <= 231 - 1 
// 
//
// 
//
// 注意：本题与主站 515 题相同： https://leetcode-cn.com/problems/find-largest-value-in-each
//-tree-row/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 32 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * 剑指 Offer II 044
 */
public class HPov7L {
    public static void main(String[] args) {
        HPov7L hPov7L = new HPov7L();
        hPov7L.test();

    }

    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node31 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        root.left = node3;
        root.right = node2;
        node3.left = node5;
        node3.right = node31;
        node2.right = node9;
        Solution solution = new HPov7L().new Solution();
        List<Integer> integers = solution.largestValues(root);
        System.out.println(integers);
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

    class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> rlt = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            //记录每一层节点个数：第一层肯定是1
            int currentLevelCount = 1;//当前层节点数量
            int nextLevelCount = 0;//下一层节点数量

            int levelMaxValue = Integer.MIN_VALUE;//记录每一层节点最大值
            while (Objects.nonNull(queue.peek())) {
                TreeNode poll = queue.poll();
                levelMaxValue = Math.max(levelMaxValue, poll.val);
                currentLevelCount--;

                if (poll.left != null) {
                    queue.offer(poll.left);
                    nextLevelCount++;
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    nextLevelCount++;
                }
                //当前层节点已经遍历完，记录当前层节点最大值，
                // 使用下一层节点数赋值当前遍历层节点数，下一层节点数重置为0
                if (currentLevelCount == 0) {
                    rlt.add(levelMaxValue);
                    levelMaxValue = Integer.MIN_VALUE;
                    currentLevelCount = nextLevelCount;
                    nextLevelCount = 0;
                }
            }
            return rlt;

        }

        public List<Integer> largestValues2(TreeNode root) {
            List<Integer> rlt = new ArrayList<>();
            Queue<TreeNode> queue1 = new LinkedList<>();
            Queue<TreeNode> queue2 = new LinkedList<>();

            int levelMaxValue = Integer.MIN_VALUE;//记录每层最大值
            queue1.offer(root);
            while (Objects.nonNull(queue1.peek())) {
                TreeNode node = queue1.poll();
                levelMaxValue = Math.max(levelMaxValue, node.val);

                if (node.left != null) {
                    queue2.offer(node.left);
                }
                if (node.right != null) {
                    queue2.offer(node.right);
                }

                //当前层节点已经遍历完了
                if (queue1.isEmpty()) {
                    rlt.add(levelMaxValue);
                    levelMaxValue = Integer.MIN_VALUE;
                    Queue<TreeNode> tmp = queue1;
                    queue1 = queue2;
                    queue2 = tmp;
                }
            }
            return rlt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    class Solution3 {


        public List<Integer> largestValues2(TreeNode root) {
            List<Integer> rlt = new ArrayList<>();
            Queue<TreeNode> currentLayer = new LinkedList<>();
            Queue<TreeNode> nextLayer = new LinkedList<>();

            int levelMaxValue = Integer.MIN_VALUE;//记录每层最大值
            currentLayer.offer(root);
            while (Objects.nonNull(currentLayer.peek())) {
                TreeNode node = currentLayer.poll();
                levelMaxValue = Math.max(levelMaxValue, node.val);
                if (node.left != null) {
                    nextLayer.offer(node.left);
                }
                if (node.right != null) {
                    nextLayer.offer(node.right);
                }

                //当前层访问完了，访问下一层
                if (currentLayer.isEmpty()) {
                    rlt.add(levelMaxValue);
                    levelMaxValue = Integer.MIN_VALUE;
                    Queue<TreeNode> tmp = currentLayer;
                    currentLayer = nextLayer;
                    nextLayer = tmp;
                }
            }
            return rlt;
        }
    }

}