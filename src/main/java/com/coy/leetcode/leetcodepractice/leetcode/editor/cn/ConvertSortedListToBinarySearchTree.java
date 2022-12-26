/**
 * 有序链表转换二叉搜索树
 */
//给定一个单链表的头节点 head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [-10,-3,0,5,9]
//输出: [0,-3,9,-10,null,5]
//解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
// 
//
// 示例 2: 
//
// 
//输入: head = []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// head 中的节点数在[0, 2 * 104] 范围内 
// -105 <= Node.val <= 105 
// 
// Related Topics 树 二叉搜索树 链表 分治 二叉树 
// 👍 785 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.ArrayList;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.difficulty.Medium;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.BinarySearchTree;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.LinkedList;

/**
 * 109
 * @see ConvertSortedArrayToBinarySearchTree
 */
@Medium
@BinarySearchTree
@LinkedList
public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedListToBinarySearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
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
        public TreeNode sortedListToBST(ListNode head) {
            //step1 将链表转为数组,也可以不转为数组，使用快慢指针找到链表中间节点
            ArrayList<Integer> arrayList = new ArrayList<>();
            ListNode cur = head;
            while (cur != null) {
                arrayList.add(cur.val);
                cur = cur.next;
            }
            //step2 将有序数组转为平衡二叉搜索树
            return buildTree(arrayList, 0, arrayList.size()-1);
        }

        private TreeNode buildTree(ArrayList<Integer> arrayList, int start, int end) {
            if (start > end) {
                return null;
            }
            if (start == end) {
                return new TreeNode(arrayList.get(start));
            }
            int mid = start + (end - start) / 2;
            TreeNode root = new TreeNode(arrayList.get(mid));
            root.left = buildTree(arrayList, start, mid - 1);
            root.right = buildTree(arrayList, mid + 1, end);
            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}