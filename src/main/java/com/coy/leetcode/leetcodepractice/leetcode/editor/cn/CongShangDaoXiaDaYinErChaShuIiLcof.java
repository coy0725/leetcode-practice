/**
 * 从上到下打印二叉树 II
 */
//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 256 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Easy;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.BFS;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Tree;

/**
 * 剑指 Offer 32 - II
 */
@Easy
@Tree
@BFS
public class CongShangDaoXiaDaYinErChaShuIiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiLcof().new Solution();
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> rlt = new ArrayList<>();
            if (root == null) {
                return rlt;
            }
            //使用两个队列来存储当前层和下一层要遍历的元素
            Queue<TreeNode> currentLayer = new LinkedList<>();
            Queue<TreeNode> nextLayer = new LinkedList<>();
            currentLayer.offer(root);
            rlt.add(currentLayer.stream().map(item -> item.val).collect(Collectors.toList()));
            while (!currentLayer.isEmpty() && currentLayer.peek() != null) {
                TreeNode node = currentLayer.poll();
                if (node.left != null) {
                    nextLayer.offer(node.left);
                }
                if (node.right != null) {
                    nextLayer.offer(node.right);
                }
                if (currentLayer.isEmpty() && !nextLayer.isEmpty()) {
                    rlt.add(nextLayer.stream().map(item -> item.val).collect(Collectors.toList()));
                    Queue<TreeNode> tmp = currentLayer;
                    currentLayer = nextLayer;
                    nextLayer = tmp;
                }
            }
            return rlt;
        }
    }

    class Solution2 {

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> rlt = new ArrayList<>();

            //使用两个队列来存储当前层和下一层要遍历的元素
            Queue<TreeNode> currentLayer = new LinkedList<>();
            if (root != null) {
                currentLayer.add(root);
            }
            while (!currentLayer.isEmpty()) {
                List<Integer> layerNodes = new ArrayList<>();
                //使用size大小来记录每一层的节点数量，很优秀，比两个queue转来转去优雅
                for (int i = 0; i < currentLayer.size(); i++) {
                    TreeNode node = currentLayer.poll();
                    layerNodes.add(node.val);
                    if (node.left != null) {
                        currentLayer.add(node.left);
                    }
                    if (node.right != null) {
                        currentLayer.add(node.right);
                    }
                }
                rlt.add(layerNodes);
            }
            return rlt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}