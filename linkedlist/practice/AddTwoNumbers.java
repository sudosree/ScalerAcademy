package linkedlist.practice;

import linkedlist.assignment.ListNode;

public class AddTwoNumbers {

    /**
     * TC = O(max(m, n))
     * SC = O(max(m, n))
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null || l2 != null) {
            int n1 = (l1 != null) ? l1.val : 0;
            int n2 = (l2 != null) ? l2.val : 0;
            int sum = carry + n1 + n2;
            carry = sum / 10;
            int num = sum % 10;
            curr.next = new ListNode(num);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            curr.next = new ListNode(1);
            curr = curr.next;
        }
        return dummy.next;
    }
}
