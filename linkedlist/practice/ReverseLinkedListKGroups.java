package linkedlist.practice;

import linkedlist.assignment.ListNode;

public class ReverseLinkedListKGroups {

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode ptr = head;

        // first check if there are atleast k nodes present in the linked list
        while (count < k && ptr != null) {
            ptr = ptr.next;
            count++;
        }

        // if there are at least k nodes present then reverse the k nodes
        if (count == k) {
            // reverse the k nodes in the linked list with head node
            ListNode reverseHead = reverseLinkedList(head, k);
            // after reversing the first k nodes re-wire the connection, the next pointer of
            // head will point to the reverse head of the next k groups and ptr is the head pointer
            // of the next k group
            head.next = reverseKGroup(ptr, k);
            return reverseHead;
        }
        // if the no. of nodes are less than k
        return head;
    }

    private ListNode reverseLinkedList(ListNode head, int k) {
        ListNode prev = null, curr = head;
        // there will be atleast k nodes in the linked list
        while (k > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        return prev;
    }
}
