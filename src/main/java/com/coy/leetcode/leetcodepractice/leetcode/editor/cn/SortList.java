/**
 * 排序链表
 */
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// Related Topics 链表 双指针 分治 排序 归并排序 
// 👍 1854 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

/**
 * 148
 */
public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
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
    class Solution {
        public ListNode sortList(ListNode head) {
            //归并排序
            if (head == null || head.next == null) {
                return head;
            }
            //找到中间节点
            ListNode fast = head.next, slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode mid = slow.next;
            slow.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(mid);
            ListNode dummy = new ListNode(-1  );
            ListNode newHead =dummy;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    dummy.next = left;
                    left = left.next;
                } else {
                    dummy.next = right;
                    right = right.next;
                }
                dummy = dummy.next;
            }
            dummy.next = left != null ? left : right;
            return newHead.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}