package swiggy;

import linkedlist.assignment.ListNode;

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        // merge two list
        ListNode list = mergeTwoSortedList(lists[0], lists[1]);
        for (int i=2;i<lists.length;i++) {
            list = mergeTwoSortedList(list, lists[i]);
        }
        return list;
    }

    private ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode temp1 = l1, temp2 = l2;
        ListNode temp = head;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        temp.next = temp1 == null ? temp2 : temp1;
        return head;
    }
}
