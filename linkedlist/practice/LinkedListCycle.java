package linkedlist.practice;

import linkedlist.assignment.ListNode;

public class LinkedListCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode tortoise = head, hare = head;
        ListNode meeting = null;
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (hare == tortoise) {
                meeting = tortoise;
                break;
            }
        }
        if (meeting == null) {
            return null;
        }
        tortoise = head;
        hare = meeting;
        while (tortoise != hare) {
            tortoise = tortoise.next;
            hare = hare.next;
        }
        return tortoise;
    }
}
