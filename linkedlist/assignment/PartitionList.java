package linkedlist.assignment;

public class PartitionList {

    public static ListNode partition(ListNode A, int B) {
        ListNode before_head = new ListNode(-1), after_head = new ListNode(-1);
        ListNode before = before_head, after = after_head;
        ListNode temp = A;
        while (temp != null) {
            if (temp.val < B) {
                before.next = temp;
                before = before.next;
            } else {
                after.next = temp;
                after = after.next;
            }
            temp = temp.next;
        }
        // last node of after list will be pointing to null
        after.next = null;
        before.next = after_head.next;
        return before_head.next;
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
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode node = partition(head, 3);
        printList(node);
    }
}
