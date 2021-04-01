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
