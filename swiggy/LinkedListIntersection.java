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

    public ListNode getIntersectionNodeUsingLen(ListNode headA, ListNode headB) {
        // if either of them is null then there is no intersection
        if (headA == null || headB == null) {
            return null;
        }
        // find the length of linked list A
        int lenA = 0;
        ListNode currA = headA;
        while (currA != null) {
            lenA++;
            currA = currA.next;
        }
        // find the length of linked list B
        int lenB = 0;
        ListNode currB = headB;
        while (currB != null) {
            lenB++;
            currB = currB.next;
        }
        currA = headA;
        currB = headB;
        // skip those many nodes in list A
        if (lenA > lenB) {
            for (int i=0; i<lenA-lenB; i++) {
                currA = currA.next;
            }
        }
        // skip those many nodes in list B
        else {
            for (int i=0; i<lenB-lenA; i++) {
                currB = currB.next;
            }
        }
        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }
}
