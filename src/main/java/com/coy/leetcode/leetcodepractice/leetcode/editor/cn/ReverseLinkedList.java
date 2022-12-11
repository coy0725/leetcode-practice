/**
* 反转链表
* 
*/
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
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
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 
// 👍 2785 👎 0
	
package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;
/**
* 206
*/
public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
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
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;

        while (cur!=null){
            ListNode next=cur.next;//保存当前节点的下一个节点
            cur.next=pre;//反转当前节点的指向
            pre=cur;//记录下一个节点的前一个节点
            cur=next;//更新下一个节点的当前节点
        }
        return pre;
    }
}

    class Solution2 {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {

                //step1:保存当前节点的下一个节点
                //step2:当前节点指向反转
                //step3:更新当前节点遍历的节点，前一个节点
                ListNode nextVisit = cur.next;
                cur.next = pre;
                cur = nextVisit;
                pre = cur;
            }
            return pre;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
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
}