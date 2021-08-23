package swiggy;

import linkedlist.assignment.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListIntersection {

    /**
     * TC = O(n+m), SC = O(m)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodes = new HashSet<>();
        ListNode currB = headB;
        while (currB != null) {
            nodes.add(currB);
            currB = currB.next;
        }
        ListNode currA = headA;
        while (currA != null) {
            if (nodes.contains(currA)) {
                return currA;
            }
            currA = currA.next;
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode currA = headA, currB = headB;
        while (currA != currB) {
            if (currA != null) {
                currA = currA.next;
            } else {
                currA = headB;
            }
            if (currB != null) {
                currB = currB.next;
            } else {
                currB = headA;
            }
        }
        return currA;
    }
}
