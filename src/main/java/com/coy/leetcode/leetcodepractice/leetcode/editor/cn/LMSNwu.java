/**
 * 链表中的两数相加
 */
//给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
//
// 示例2：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
//
//
// 示例3：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。 
//
// 
//
// 注意：本题与主站 445 题相同：https://leetcode-cn.com/problems/add-two-numbers-ii/ 
// Related Topics 栈 链表 数学 
// 👍 67 👎 0

package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

/**
 * 剑指 Offer II 025
 */
public class LMSNwu {
    public static void main(String[] args) {
        Solution solution = new LMSNwu().new Solution();
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode reverseL1 = reverseList(l1);
            ListNode reverseL2 = reverseList(l2);
            ListNode rlt = new ListNode();
            ListNode head = rlt;
            int extra = 0;
            int sum = 0;
            while (reverseL1 != null || reverseL2 != null||extra!=0) {
                int a = reverseL1 == null ? 0 : reverseL1.val;
                int b = reverseL2 == null ? 0 : reverseL2.val;
                sum = a + b + extra;
                if (sum >= 10) {
                    extra = 1;
                    sum = sum - 10;
                } else {
                    extra = 0;
                }
                ListNode tem = new ListNode();
                tem.val = sum;
                head.next = tem;
                head = head.next;
                if (reverseL1 != null) {
                    reverseL1 = reverseL1.next;
                }
                if (reverseL2 != null) {
                    reverseL2 = reverseL2.next;
                }
            }
            return reverseList(rlt.next);
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