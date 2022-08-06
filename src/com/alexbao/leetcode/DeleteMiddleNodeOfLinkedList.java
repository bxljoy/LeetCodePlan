package com.alexbao.leetcode;

public class DeleteMiddleNodeOfLinkedList {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head, previous = head;
        while (fast != null && fast.next != null) {
            if (slow != head) {
                previous = previous.next;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        previous.next = slow.next;

        return head;
    }
}
