package com.alexbao.leetcode5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(-1000000);
        ListNode cur = head;
        List<Integer> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        Collections.sort(list);
        for (int i=0; i<list.size(); i++) {
            if (i == 0) {
                cur = new ListNode(list.get(i));
                dummy.next = cur;
            } else {
                cur.next = new ListNode(list.get(i));
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}