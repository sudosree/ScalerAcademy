package linkedlist.practice;

public class FlattenLinkedList {

    static class Node {
        int val;
        Node next;
        Node bottom;

        Node () {

        }

        Node (int val) {
            this.val = val;
            this.next = null;
            this.bottom = null;
        }
    }

    private static Node flatten(Node head) {
        // if the linked list is empty or it has only
        // one linked list return it
        if (head == null || head.next == null) {
            return head;
        }
        // flatten the next linked list
        head.next = flatten(head.next);
        // merge the flattened linked list with the current linked list
        head = merge(head, head.next);
        // after merging you get a new linked list
        return head;
    }

    private static Node merge(Node l1, Node l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Node dummy = new Node();
        Node temp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.bottom = l1;
                l1 = l1.bottom;
            } else {
                temp.bottom = l2;
                l2 = l2.bottom;
            }
            temp = temp.bottom;
        }
        temp.bottom = l1 == null ? l2 : l1;
        // set the next pointer of the final merged linked list to null
        dummy.bottom.next = null;
        return dummy.bottom;
    }

    private static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.bottom;
        }
    }

    public static void main(String[] args) {
        Node l1 = new Node(5);
        Node l2 = new Node(10);
        Node l3 = new Node(19);
        Node l4 = new Node(28);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l1.bottom = new Node(7);
        l1.bottom.bottom = new Node(8);
        l1.bottom.bottom.bottom = new Node(30);
        l2.bottom = new Node(20);
        l3.bottom = new Node(22);
        l3.bottom.bottom = new Node(50);
        l4.bottom = new Node(35);
        l4.bottom.bottom = new Node(40);
        l4.bottom.bottom.bottom = new Node(45);

        flatten(l1);
        print(l1);
    }
}
