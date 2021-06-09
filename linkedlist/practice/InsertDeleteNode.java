package linkedlist.practice;

public class InsertDeleteNode {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static Node insert(Node head, int val) {
        Node tmp = new Node(val);
        if (head == null) {
            head = tmp;
            return head;
        }
        // if there is only one node
        if (head.next == null) {
            if (head.val <= val) {
                head.next = tmp;
            } else {
                tmp.next = head;
                head = tmp;
            }
            return head;
        }
        Node prev = null, curr = head;
        while (curr != null && curr.val <= val) {
            prev = curr;
            curr = curr.next;
        }
        if (prev != null) {
            prev.next = tmp;
        } else {
            head = tmp;
        }
        tmp.next = curr;
        return head;
    }

    private static Node delete(Node head, int val) {
        if (head == null) {
            return head;
        }
        Node prev = null, curr = head;
        while (curr != null && curr.val != val) {
            prev = curr;
            curr = curr.next;
        }
        if (prev == null) {
            head = head.next;
        } else if (curr != null) {
            prev.next = curr.next;
        }
        return head;
    }

    private static void print(Node head) {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;

        Node node = insert(head, 4);
        print(node);
        System.out.println();
        Node node1 = delete(head, 4);
        print(node1);
    }
}
