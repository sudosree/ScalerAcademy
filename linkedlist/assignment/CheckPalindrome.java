package linkedlist.assignment;

public class CheckPalindrome {

    /**
     * TC = O(n), SC = O(1)
     */
    public static int lPalin(ListNode A) {
        // find the middle node
        ListNode slow = A, fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the 2nd half of the list
        ListNode secondHalf = reverse(slow);
        // check both the lists
        ListNode first = A, second = secondHalf;
        int res = 1;
        while (first != null && second != null) {
            if (first.val == second.val) {
                first = first.next;
                second = second.next;
            } else {
                res = 0;
                break;
            }
        }
        // restore the list
        ListNode org_second_list = reverse(secondHalf);
        // if the list is odd length
        if (fast != null) {
            slow.next = org_second_list.next;
        } else {
            slow.next = org_second_list;
        }
        return res;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(lPalin(head));
    }
}
