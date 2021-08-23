package linkedlist.practice;

import linkedlist.assignment.ListNode;

public class FindMedian {

    private static double findMedian(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode slow = head, prev = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            return slow.val;
        } else {
            return (double)(slow.val + prev.val) / 2;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
        System.out.println(findMedian(head));
    }
}
