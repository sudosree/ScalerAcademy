package linkedlist.assignment;

public class ReorderList {

    /**
     * TC = O(n), SC = O(1)
     */
    public static ListNode reorderList(ListNode A) {
        // find the middle node of the linked list
        // slow node will contain the middle node of the linked list
        ListNode slow = A, fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the 2nd half of the linked list
        // prev node contains the reverse head
        ListNode prev = null, curr = slow, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // merge two list
        ListNode first = A, second = prev;
        while (second.next != null) {
            next = first.next;
            first.next = second;
            first = next;
            next = second.next;
            second.next = first;
            second = next;
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

    public void reorderList1(ListNode head) {
        // find the middle node of the list
        ListNode middle = findMiddleNode(head);
        // reverse the second half of the list
        ListNode second = reverse(middle);
        // merge the two list
        ListNode first = head;
        while (second.next != null) {
            ListNode next = first.next;
            first.next = second;
            first = next;
            next = second.next;
            second.next = first;
            second = next;
        }
    }

    private ListNode findMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode node = reorderList(head);
        printList(node);
    }
}
