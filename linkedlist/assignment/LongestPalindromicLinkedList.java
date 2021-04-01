package linkedlist.assignment;

public class LongestPalindromicLinkedList {

    /**
     * TC = O(n^2), SC = O(1)
     */
    public int solve(ListNode A) {
        int max_len = 0;
        ListNode prev = null, curr = A, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            // check for odd length palindrome, do not include the curr
            max_len = Math.max(max_len, 2 * countCommon(prev, next) + 1);
            // check for even length palindrome, include the curr
            max_len = Math.max(max_len, 2 * countCommon(curr, next));
            prev = curr;
            curr = next;
        }
        return max_len;
    }

    private int countCommon(ListNode left, ListNode right) {
        int count = 0;
        while (left != null && right != null && left.val == right.val) {
            left = left.next;
            right = right.next;
            count++;
        }
        return count;
    }
}
