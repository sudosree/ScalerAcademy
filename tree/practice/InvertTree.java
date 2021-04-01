package tree.practice;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {

    /**
     * TC = O(n), SC = O(h) (worst case - O(n) )
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // invert the right subtree
        TreeNode right = invertTree(root.right);
        // invert the left subtree
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * TC = O(n), SC = O(n)
     */
    public TreeNode invertTree1(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return A;
    }
}
