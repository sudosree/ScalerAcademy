package linkedlist.practice;

import linkedlist.assignment.ListNode;

public class RemoveDuplicatesFromSortedListII {

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode sentinel = new ListNode(0, head);
    // pred node is the last node before the duplicate sublist
    ListNode pred = sentinel;
    ListNode curr = head;
    while (curr != null) {
      // if it's the beginning of the duplicate sublist then skip all
      // the duplicates
      if (curr.next != null && curr.next.val == curr.val) {
        while (curr.next != null && curr.next.val == curr.val) {
          curr = curr.next;
        }
        // skip all duplicates
        pred.next = curr.next;
      } else {
        pred = pred.next;
      }
      curr = curr.next;
    }
    return sentinel.next;
  }
}
