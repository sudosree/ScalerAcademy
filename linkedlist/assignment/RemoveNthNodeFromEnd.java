package linkedlist.assignment;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode A, int B) {
        // find the size of the linked list
        ListNode temp = A;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        if (B >= size || size == 1) {
            A = A.next;
            return A;
        }
        temp = A;
        ListNode prev = null;
        int count = 1;
        // retrieve the (size-B+1)th node from the start of the linked list
        while (count != size-B+1) {
            count++;
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        return A;
    }

    public static ListNode removeNthFromEnd1(ListNode A, int B) {
        ListNode slow = A, fast = A, prev = null;
        for (int i=1;i<B && fast != null;i++) {
            fast = fast.next;
        }
        // move slow and fast pointer by one places when fast pointer
        // reaches the end, the node at which the slow pointer points
        // will be the desired node
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if (prev != null) {
            prev.next = slow.next;
        } else {
            A = A.next;
        }
        return A;
    }

    private static void printList(ListNode A) {
        ListNode temp = A;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode node = removeNthFromEnd1(head,2);
        printList(node);
    }
}
