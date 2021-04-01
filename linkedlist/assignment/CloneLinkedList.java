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

    Map<ListNode, ListNode> visited = new HashMap<>();

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
}
