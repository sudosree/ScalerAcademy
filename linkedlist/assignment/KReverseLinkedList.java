package linkedlist.assignment;

public class KReverseLinkedList {

    /**
     * TC = O(n), SC = O(1)
     */
    public ListNode reverseList(ListNode A, int B) {
        // keep track of the final new head to be returned
        ListNode new_head = null;
        ListNode ptr = A;
        // keep track of the tail node of the reversed list
        ListNode btail = null;
        while (ptr != null) {
            for (int i=0;i<B;i++) {
                ptr = ptr.next;
            }
            // reverse B nodes
            ListNode rev_head = reverse(A, B);
            if (new_head == null) {
                new_head = rev_head;
            }
            if (btail != null) {
                btail.next = rev_head;
            }
            btail = A;
            A = ptr;
        }
        return new_head;
    }

    private ListNode reverse(ListNode A, int B) {
        ListNode new_head = null, curr = A;
        while (B > 0 && curr != null) {
            ListNode next = curr.next;
            curr.next = new_head;
            new_head = curr;
            curr = next;
            B--;
        }
        return new_head;
    }
}
