package com.alexbao.leetcode3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer, Integer> res = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        ListNode dummy = new ListNode(-1);
        while (cur != null) {
            int c = cur.val;
            res.put(c, res.getOrDefault(c, 0) + 1);
            cur = cur.next;
        }
        for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == 1) {
                list.add(key);
            }
        }
        Collections.sort(list);
        for (int i=0; i<list.size(); i++) {
            int key = list.get(i);
            if (i == 0) {
                cur = new ListNode(key);
                dummy.next = cur;
            } else {
                cur.next = new ListNode(key);
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
