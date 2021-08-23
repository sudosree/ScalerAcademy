package tree.practice;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Cousins {

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean xFound = false, yFound = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                if (node.val == x) {
                    xFound = true;
                } else if (node.val == y) {
                    yFound = true;
                }
                // check if the current node has children both x and y
                // if it has then return false they are not cousins, they are
                // siblings
                else {
                    if (node.left != null && node.right != null) {
                        if (node.left.val == x && node.right.val == y) {
                            return false;
                        }
                        if (node.left.val == y && node.right.val == x) {
                            return false;
                        }
                    }
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // if both nodes are found then return true
            if (xFound && yFound) {
                return true;
            }
            // if any one of them is found at the current level and the
            // other one is not found then return false
            if (xFound || yFound) {
                return false;
            }
        }
        return false;
    }
}
