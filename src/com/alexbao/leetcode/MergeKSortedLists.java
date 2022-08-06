package com.alexbao.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        while (pq.size() != 0) {
            ListNode node = pq.poll();
            System.out.println(node.val);
            p.next = node;

            if (node.next != null) {
                pq.add(node.next);
            }

            p = p.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists mks = new MergeKSortedLists();
        ListNode[] lists = new ListNode[4];
        lists[0] = new ListNode(1);
        lists[1] = new ListNode(4);
        lists[2] = new ListNode(3);
        lists[3] = new ListNode(2);
        mks.mergeKLists(lists);
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}