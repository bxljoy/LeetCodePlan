package com.alexbao.leetcode;

public class RemoveLastNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode res = head;
        ListNode p3 = new ListNode();

        for (int i=0; i<n; i++) {
            p1 = p1.next;
        }

        while (p1 != null) {
            if (p1.next == null) {
                p3 = p2;
            }
            p2 = p2.next;
            p1 = p1.next;
        }

        if (p2 == head) {
            res = p2.next;
        } else {
            p3.next = p2.next;
        }
        p2.next = null;

        return res;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode res = findFromEnd(dummy, n + 1);
        res.next = res.next.next;

        return dummy.next;
    }

    private ListNode findFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;

        for (int i=0; i<n; i++) {
            p1 = p1.next;
        }

        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        return p2;
    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p3 = new ListNode();

        for (int i=0; i<n; i++) {
            p1 = p1.next;
        }

        while (p1 != null) {
            if (p1.next == null) {
                p3 = p2;
            }
            p2 = p2.next;
            p1 = p1.next;
        }

        if (p2 == head) {
            dummy.next = p2.next;
        } else {
            p3.next = p2.next;
        }
        p2.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveLastNthNode rln = new RemoveLastNthNode();
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        head.next = second;

        ListNode res = rln.removeNthFromEnd(head, 1);
        System.out.println(res.val);
        if (res.next != null) {
            System.out.println(res.next.val);
        }
    }
}
