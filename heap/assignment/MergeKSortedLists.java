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
        ListNode list = mergeLists(lists[0], lists[1]);
        for (int i=2;i<lists.length;i++) {
            list = mergeLists(list, lists[i]);
        }
        return list;
    }

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
