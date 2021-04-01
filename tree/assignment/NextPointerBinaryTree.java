package tree.assignment;

import tree.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

public class NextPointerBinaryTree {

    /**
     * TC = O(n), SC = O(1)
     */
    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        // no next pointers to be established for the root node
        TreeLinkNode leftmost = root;

        // when you reach the final level you are done, there is no next level for which
        // you have to establish the next pointer connection
        while (leftmost.left != null) {
            // traverse the nodes in the current level using the already established next pointer
            // in this level to establish the next pointer for the nodes on the next level
            TreeLinkNode head = leftmost;
            while (head != null) {

                // establish the 1st connection when both the nodes have the same parent
                head.left.next = head.right;

                // establish the 2nd connection when both the nodes have different parent
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // move to the next node in the same level
                head = head.next;
            }
            // move to the next level
            leftmost = leftmost.left;
        }
    }

    /**
     * TC = O(n), SC = O(1)
     */
    public static void connect1(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curr_level_size = queue.size();
            for (int i=0;i<curr_level_size;i++) {
                TreeLinkNode node = queue.poll();
                // if the node is the last node in the current level then
                // establish its next pointer to point to null
                if (i == curr_level_size-1) {
                    node.next = null;
                } else {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }
}
