package com.alexbao.leetcode;

public class FindLastKthElement {
    public ListNode findLastKthElement(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        int count = 0;
        while (p1 != null) {
            if (count >= k) {
                p2 = p2.next;
            }

            p1 = p1.next;
            count += 1;
        }
        return p2;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(8);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        FindLastKthElement flk = new FindLastKthElement();
        ListNode element = flk.findLastKthElement(l1, 5);
        System.out.println(element.val);
    }
}


