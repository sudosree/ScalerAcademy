package linkedlist.practice;

import linkedlist.practice.RotateListByKPlaces.ListNode;

public class RotateListByKPlacesRight {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
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
        return newHead;
    }

    private static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode head = rotateRight(listNode, 2);
        print(head);
    }
}
