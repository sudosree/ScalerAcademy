package heap.assignment;

import linkedlist.assignment.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    /**
     * TC = O(k + (n-k)logk) = O(nlogk) (where O(k) - building min heap of size k
     * SC = O(k)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        // node with smallest value will be at the root of the tree
        PriorityQueue<ListNode> minQueue = new PriorityQueue<>(new MyComparator());
        // insert all the head nodes of the k linked lists into the min heap
        for (ListNode node : lists) {
            if (node != null) {
                minQueue.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (minQueue.size() > 0) {
            ListNode node = minQueue.poll();
            curr.next = node;
            if (node.next != null) {
                minQueue.offer(node.next);
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    static class MyComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode l1, ListNode l2) {
            return l1.val - l2.val;
        }
    }

    /**
     * TC = O(nk)
     * @param lists
     * @return
     */
    private ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode list = mergeTwoLists(lists[0], lists[1]);
        for (int i=2;i<lists.length;i++) {
            list = mergeTwoLists(list, lists[i]);
        }
        return list;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
        ListNode curr = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return head;
    }
}
