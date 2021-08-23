package linkedlist.practice;

import linkedlist.assignment.ListNode;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode firstHalfEnd = null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            firstHalfEnd = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // there are odd no. of nodes
        if (fast != null) {
            firstHalfEnd = slow;
            slow = slow.next;
        }

        // reverse the second half
        ListNode secondHalfStart = reverseSecondHalf(slow);
        // compare the first half and the second half, check if it is a palindrome or not
        boolean pal = true;
        ListNode l1 = head, l2 = secondHalfStart;
        while (l2 != null) {
            if (l1.val != l2.val) {
                pal = false;
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        // restore the list
        firstHalfEnd.next = reverseSecondHalf(secondHalfStart);
        // return the result
        return pal;
    }


    private ListNode reverseSecondHalf(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
