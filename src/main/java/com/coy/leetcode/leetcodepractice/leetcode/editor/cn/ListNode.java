package com.coy.leetcode.leetcodepractice.leetcode.editor.cn;

/**
 * @author coy
 * @since 2022/12/11
 **/
public class ListNode {
    public int val;
    public int min;//最小值
    public ListNode next;

    public ListNode(int val, int min, ListNode next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
    ListNode(int val) { this.val = val; }
}
