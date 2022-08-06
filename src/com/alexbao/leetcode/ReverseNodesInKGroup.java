package com.alexbao.leetcode;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode a = head;
        ListNode b = head;

        for (int i=0; i<k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }

        ListNode newHead = this.reverse(a, b);
        a.next = this.reverseKGroup(b, k);
        return newHead;
    }

    private ListNode reverseAll(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = head;

        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    private ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = b;
        ListNode cur = a;
        ListNode nxt = a;

        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }


}
