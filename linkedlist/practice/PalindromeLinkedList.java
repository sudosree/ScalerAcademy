package linkedlist.practice;

import linkedlist.assignment.ListNode;

public class PalindromeLinkedList {

    public static boolean isPalindrome1(ListNode head) {
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


    private static ListNode reverseSecondHalf(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode node = slow;
        // if the list contains odd no. of elements
        if (fast != null) {
            node = node.next;
        }
        ListNode revHead = reverseSecondHalf(node);
        ListNode l1 = head, l2 = revHead;
        while (l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
//        head.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }
}
