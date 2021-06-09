package linkedlist.practice;

public class RotateListByKPlaces {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static ListNode rotate(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode kthNode = null, curr = head;
        int count = 1;
        while (count <= k && curr != null) {
            kthNode = curr;
            curr = curr.next;
            count++;
        }
        // k >= n
        if (curr == null) {
            return head;
        }
        ListNode last = curr;
        while (last.next != null) {
            last = last.next;
        }
        last.next = head;
        if (kthNode != null) {
            kthNode.next = null;
        }
        head = curr;
        return head;
    }

    private static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        ListNode n1 = new ListNode(20);
        ListNode n2 = new ListNode(30);
        ListNode n3 = new ListNode(40);
        ListNode n4 = new ListNode(50);
        ListNode n5 = new ListNode(60);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode head1 = rotate(head, 4);
        print(head1);
    }
}
