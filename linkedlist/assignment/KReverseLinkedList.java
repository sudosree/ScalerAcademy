package linkedlist.assignment;

public class KReverseLinkedList {

    /**
     * TC = O(n), SC = O(1)
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode ktail = null, ptr = head, newHead = null;
        while (ptr != null) {
            count = 0;
            // check if there are at least k nodes present
            while (count < k && ptr != null) {
                ptr = ptr.next;
                count++;
            }

            if (count == k) {
                ListNode revHead = reverseLinkedList(head, k);
                // this is the first set of k nodes
                if (newHead == null) {
                    newHead = revHead;
                }
                if (ktail != null) {
                    ktail.next = revHead;
                }
                ktail = head;
                head = ptr;
            }
        }
        // attach the unreversed portion to the ktail
        if (ktail != null) {
            ktail.next = head;
        }
        return newHead == null ? head : newHead;
    }

    private ListNode reverseLinkedList(ListNode head, int k) {
        ListNode prev = null, curr = head;
        // there will be atleast k nodes in the linked list
        while (k > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        return prev;
    }
}
