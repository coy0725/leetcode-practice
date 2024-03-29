/**
 * 回文链表
 */
//给定一个链表的 头节点 head ，请判断其是否为回文链表。 
//
// 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [1,2,3,3,2,1]
//输出: true 
//
// 示例 2： 
//
// 
//
// 
//输入: head = [1,2]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 链表 L 的长度范围为 [1, 105] 
// 0 <= node.val <= 9 
// 
//
// 
//
// 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// 
//
// 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/ 
// Related Topics 栈 递归 链表 双指针 
// 👍 74 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.LinkedList;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.Palindrome;
import com.coy.leetcode.leetcodepractice.leetcode.annotation.topic.TwoPointers;

/**
 * 剑指 Offer II 027
 */
@Palindrome
@LinkedList
@TwoPointers
public class AMhZSa {
    public static void main(String[] args) {
        Solution solution = new AMhZSa().new Solution();
        ListNode a = new AMhZSa().new ListNode(1);
        ListNode b = new AMhZSa().new ListNode(0);
        ListNode c = new AMhZSa().new ListNode(1);
        a.next = b;
        b.next = c;
        solution.isPalindrome(a);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {

            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode fast = dummy;
            ListNode slow = dummy;
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
                if (fast.next != null) {
                    fast = fast.next;
                }
            }
            ListNode temp = slow.next;
            ListNode reverePart = reverseList(temp);
            while (head.next != null && reverePart != null) {
                if (head.val != reverePart.val) {
                    return false;
                }
                head = head.next;
                reverePart = reverePart.next;
            }
            return true;
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

    class Solution2 {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return false;
            }
            if (head.next == null) {
                return true;
            }
            //首先，我们需要找到链表的中点
            ListNode midNode = findMidNode(head);

            //然后将链表从中点拆分为两个链表,
            ListNode secondHead = midNode.next;
            midNode.next = null;
            //我们将第二个链表反转
            ListNode head2 = reverseList(secondHead);
            while (head != null && head2 != null) {
                if (head.val != head2.val) {
                    return false;
                }
                head = head.next;
                head2 = head2.next;
            }
            return true;

        }

        private ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode curVisit = head;
            ListNode preVisit = null;
            while (curVisit != null) {
                ListNode nextVisit = curVisit.next;
                curVisit.next = preVisit;
                preVisit = curVisit;
                curVisit = nextVisit;
            }
            return preVisit;
        }

        @TwoPointers
        private ListNode findMidNode(ListNode head) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode slow = dummy;
            ListNode fast = dummy;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

    }

    class ListNode {
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