/**
* 重排链表
* 
*/
//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// L0 → L1 → … → Ln-1 → Ln 
//请将其重新排列后变为： 
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4]
//输出: [1,4,2,3] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 104] 
// 1 <= node.val <= 1000 
// 
//
// 
//
// 注意：本题与主站 143 题相同：https://leetcode-cn.com/problems/reorder-list/ 
// Related Topics 栈 递归 链表 双指针 
// 👍 75 👎 0
	
package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import java.util.List;

/**
* 剑指 Offer II 026
*/
public class LGjMqU {
    public static void main(String[] args) {
        Solution solution = new LGjMqU().new Solution();
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
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next=head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next;
            if (fast.next!=null){
                fast=fast.next;
            }
        }

        ListNode temp = slow.next;
        slow.next=null;
        link(head,reverseList(temp),dummy);

    }

    private void link(ListNode node1, ListNode node2, ListNode head) {
        ListNode prev =head;
        while (node1!=null&&node2!=null){
            ListNode temp = node1.next;//保存链表1的下一个节点
            prev.next=node1;
            node1.next=node2;
            prev=node2;

            node1=temp;
            node2=node2.next;
        }
        if (node1!=null){
            prev.next=node1;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode next = cur.next;//保存当前节点的下一个节点
            cur.next = pre;//反转当前节点的指向
            pre = cur;//记录下一个节点的前一个节点
            cur = next;//更新下一个节点的当前节点
        }
        return pre;
    }
}
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}