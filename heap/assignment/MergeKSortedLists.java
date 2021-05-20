package heap.assignment;

import linkedlist.assignment.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    /**
     * TC = O(klogk) + O(nlogk) = O(nlogk)
     * SC = O(k) + O(n) = O(n)
     */
    public ListNode mergeKLists(ArrayList<ListNode> a) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new MyComparator());

        // push all the heads of the linked list in the min heap
        for (ListNode node : a) {
            minHeap.offer(node);
        }

        // take the smallest element from the min heap and move to the next node
        // of the smallest element in the linked list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (minHeap.size() > 0) {
            tail.next = minHeap.poll();
            tail = tail.next;

            if (tail.next != null) {
                minHeap.offer(tail.next);
            }
        }
        return dummy.next;
    }

    static class MyComparator implements Comparator<ListNode> {

        @Override
        public int compare(ListNode l1, ListNode l2) {
            return l1.val - l2.val;
        }
    }
}
