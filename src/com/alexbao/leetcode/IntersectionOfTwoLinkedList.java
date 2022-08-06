package com.alexbao.leetcode;

public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == headB) {
            return headA;
        }

        int n = 1;
        ListNode p1 = headA, p2 = headB;
        ListNode na, nb;

        while (n > 0) {
            na = findLastKthElement(p1, n);
            nb = findLastKthElement(p2, n);
            if (na != nb) {
                break;
            }
            n += 1;
        }

        if (n == 1) {
            return null;
        } else {
            return findLastKthElement(p1, n-1);
        }
    }

    public ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
        if (headA == headB) {
            return headA;
        }

        int n = 1;
        ListNode p1 = headA, p2 = headB;

        while (n > 0) {
            p1 = findLastKthElement(headA, n);
            p2 = findLastKthElement(headB, n);
            if (p1 != p2) {
                break;
            }
            n += 1;
        }

        if (n == 1) {
            return null;
        } else {
            return findLastKthElement(headA, n-1);
        }
    }

    private ListNode findLastKthElement(ListNode head, int k) {
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

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        int lenA = 0, lenB = 0;
        for (ListNode p1 = headA; p1 != null; p1 = p1.next) {
            lenA ++;
        }
        for (ListNode p2 = headB; p2 != null; p2 = p2.next) {
            lenB ++;
        }

        ListNode p1 = headA, p2 = headB;
        if (lenA > lenB) {
            for (int i=0; i<lenA-lenB; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i=0; i<lenB-lenA; i++) {
                p2 = p2.next;
            }
        }

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
           if (p1 == null) {
               p1 = headB;
           } else {
               p1 = p1.next;
           }

           if (p2 == null) {
               p2 = headA;
           } else {
               p2 = p2.next;
           }
        }
        return p1;
    }
}
