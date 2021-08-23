package linkedlist.assignment;

import java.util.HashMap;
import java.util.Map;

public class CloneLinkedList {

    static class ListNode {
        int val;
        ListNode next, random;
        ListNode(int x) {
            val = x;
            next = random = null;
        }
    }

    private static Map<ListNode, ListNode> visited = new HashMap<>();

    ListNode cloneList(ListNode A) {
        if (A == null) {
            return null;
        }
        // create a clone of the head node
        ListNode oldNode = A;
        ListNode newNode = new ListNode(oldNode.val);
        visited.put(oldNode, newNode);

        while (oldNode != null) {
            newNode.random = getClonedNode(oldNode.random);
            newNode.next = getClonedNode(oldNode.next);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return visited.get(A);
    }

    ListNode getClonedNode(ListNode node) {
        if (node != null) {
            if (visited.containsKey(node)) {
                return visited.get(node);
            }
            visited.put(node, new ListNode(node.val));
            return visited.get(node);
        }
        return null;
    }

    private static ListNode cloneLinkedList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (visited.containsKey(head)) {
            return visited.get(head);
        }
        ListNode node = new ListNode(head.val);
        visited.put(head, node);
        node.next = cloneLinkedList(head.next);
        node.random = cloneLinkedList(head.random);
        return node;
    }

    public ListNode copyRandomList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode oldNode = head;
        while (oldNode != null) {
            ListNode newNode = getCloneNode(oldNode);
            newNode.next = getCloneNode(oldNode.next);
            newNode.random = getCloneNode(oldNode.random);
            oldNode = oldNode.next;
        }
        return visited.get(head);
    }

    private ListNode getCloneNode(ListNode node) {
        if (node == null) {
            return null;
        }
        if (!visited.containsKey(node)) {
            visited.put(node, new ListNode(node.val));
        }
        return visited.get(node);
    }

    public ListNode copyRandomList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        // create a clone node of every node and insert it
        // after every node
        while (curr != null) {
            // create a clone node of the current node
            ListNode clone = new ListNode(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        // add the random pointer of clone node to point to the correct node using
        // the random pointer of the original node
        curr = head;
        while (curr != null) {
            curr.next.random = (curr.random != null) ? curr.random.next : null;
            curr = curr.next.next;
        }

        // unlink the next pointers of all nodes to create two seperate lists
        ListNode newNode = head.next;
        ListNode oldNode = head;
        ListNode cloneNode = head.next;

        while (oldNode != null) {
            oldNode.next = cloneNode.next;
            cloneNode.next = (cloneNode.next != null) ? cloneNode.next.next : null;
            oldNode = oldNode.next;
            cloneNode = cloneNode.next;
        }
        return newNode;
    }
}
