package tree.assignment;

import tree.TreeNode;

public class FlattenBinaryTree {

    /**
     * TC = O(n), SC = O(n)
     */
    private TreeNode flattenHelper(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = flattenHelper(root.left);
        TreeNode right = flattenHelper(root.right);

        root.left = null;
        if (left == null) {
            root.right = right;
        } else {
            root.right = left;
            TreeNode node = root;
            while (node.right != null) {
                node = node.right;
            }
            node.right = right;
        }

        return root;
    }

    /**
     * TC = O(n) (traversing every node twice), SC = O(1)
     */
    public TreeNode flatten(TreeNode a) {
        if (a == null) {
            return null;
        }
        TreeNode curr = a;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode rightmost = curr.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                rightmost.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
        return a;
    }
}
