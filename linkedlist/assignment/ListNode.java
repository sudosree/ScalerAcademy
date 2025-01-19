package linkedlist.assignment;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() { }
    public ListNode(int x) { val = x; next = null; }

    public ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}
