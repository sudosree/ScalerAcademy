package linkedlist.assignment;

public class RemoveLoopFromLinkedList {

    public ListNode solve(ListNode A) {
        // first check if there exists a cycle or not
        ListNode meeting_point = intersection(A);
        // no cycle, so no point in removing the cycle
        if (meeting_point == null) {
            return A;
        }
        // find the entrance to the cycle
        ListNode prev = null;
        ListNode p1 = A, p2 = meeting_point;
        while (p1 != p2) {
            prev = p2;
            p2 = p2.next;
            p1 = p1.next;
        }
        prev.next = null;
        return A;
    }

    private ListNode intersection(ListNode A) {
        ListNode slow = A, fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
}
