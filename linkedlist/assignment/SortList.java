package linkedlist.assignment;

public class SortList {

    /**
     * TC = O(nlogn), SC = O(logn) (because of recursive call stack)
     * Top Down approach
     */
    public ListNode sortList(ListNode A) {
        // first check if the list is empty or if it contains
        // a single element or not
        if (A == null || A.next == null) {
            return A;
        }
        // find the middle node of the linked list
        ListNode mid = getMiddle(A);
        ListNode left = sortList(A);
        ListNode right = sortList(mid);
        return mergeList(left, right);
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode head;
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
        // if any one of them l1 or l2 is not null then simply add it to the final list
        curr.next = (l1 == null) ? l2 : l1;
        return head;
    }

    // lists are in sorted order
    private ListNode mergeList1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode t1 = l1, t2 = l2;
        while (t1 != null && t2 != null) {
            if (t1.val <= t2.val) {
                tail.next = t1;
                t1 = t1.next;
            } else {
                tail.next = t2;
                t2 = t2.next;
            }
            tail = tail.next;
        }
        tail.next = (t1 != null) ? t1 : t2;
        return dummy.next;
    }

    private ListNode getMiddle(ListNode A) {
        // if the list is empty or the list contains only one element
        // then return the head node
        if (A == null || A.next == null) {
            return A;
        }
        ListNode prev = null, slow = A, fast = A;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // split the list into two parts
        prev.next = null;
        return slow;
    }
}
