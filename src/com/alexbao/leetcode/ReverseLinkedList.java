package com.alexbao.leetcode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = this.reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
