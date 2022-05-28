package linkedlist.assignment;

public class OddEvenLinkedList {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        ListNode old = head;
        ListNode even = head.next;
        while (old.next != null && old.next.next != null) {
            curr.next = old;
            old = old.next.next;
            curr = curr.next;
        }
        curr.next = old;
        curr = curr.next;
        while (even.next != null && even.next.next != null) {
            curr.next = even;
            even = even.next.next;
            curr = curr.next;
        }
        curr.next = even;
        curr = curr.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        oddEvenList(head);
    }
}
