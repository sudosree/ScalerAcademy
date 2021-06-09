package linkedlist.practice;

public class RotateListByKPlacesRight {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        // form a ring
        tail.next = head;
        if (k >= n) {
            k = k%n;
        }
        ListNode newTail = head, newHead;
        // new tail will be (n-k)th node and new head will be (n-k+1)th node
        for (int i=1;i<n-k;i++) {
            newTail = newTail.next;
        }
        newHead = newTail.next;
        newTail.next = null;
        head = newHead;
        return head;
    }
}
