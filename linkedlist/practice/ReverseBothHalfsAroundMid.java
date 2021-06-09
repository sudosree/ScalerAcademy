package linkedlist.practice;

import linkedlist.assignment.ListNode;

public class ReverseBothHalfsAroundMid {

    private static ListNode reverseHalf(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // find the mid node and also the previous node and the next
        // node of the mid node
        // slow will be the mid
        ListNode slow = head, fast = head;
        ListNode next = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            next = slow.next;
            fast = fast.next.next;
        }

        // reverse the 1st half of the LL from head to prev
        // prevNode will be the head node for the new list
        ListNode prev = null, curr = head, n;
        while (curr != slow) {
            n = curr.next;
            curr.next = prev;
            prev = curr;
            curr = n;
        }
        // next pointer of the previous head node should point to the mid node
        head.next = slow;

        // reverse the 2nd half
        // the next node of the mid node
        curr = next;
        ListNode p = null;
        while (curr != null) {
            n = curr.next;
            curr.next = p;
            p = curr;
            curr = n;
        }
        // the next pointer of the mid node should point to the new head of the reversed 2nd half
        slow.next = p;
        return prev;
    }

    private static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        ListNode seventh = new ListNode(7);
        ListNode eighth = new ListNode(8);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next =  eighth;

        ListNode h = reverseHalf(head);
        printList(h);
    }
}
