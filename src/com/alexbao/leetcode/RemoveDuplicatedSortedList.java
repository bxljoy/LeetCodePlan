package com.alexbao.leetcode;

public class RemoveDuplicatedSortedList {
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.val == slow.val) {
                slow.next = fast.next;
                fast = fast.next;
            } else {
                slow = slow.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
