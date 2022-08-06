package com.alexbao.leetcode;

public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return this.reverseN(head, right);
        }

        head.next = this.reverseBetween(head.next, left-1, right-1);
        return head;
    }

    ListNode successor = null;

    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = this.reverseN(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
