package linkedlist.assignment;

public class GetNthNodeFromEnd {

    private static int getNthFromEnd(ListNode head, int n) {
        // find the length of the linked list then retrieve (len-n+1)th node
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        node = head;
        int i = 1;
        while (i < len-n+1) {
            i++;
            node = node.next;
        }
        return node.val;
    }

    private static int getNthFromEnd1(ListNode head, int n) {
        ListNode first = head, second = head;
        // move the first pointer by n nodes
        int i=0;
        while (i < n) {
            first = first.next;
            i++;
        }
        while (first != null) {
            second = second.next;
            first = first.next;
        }
        return second.val;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(getNthFromEnd(head, 3));
        System.out.println(getNthFromEnd1(head, 3));
    }
}
