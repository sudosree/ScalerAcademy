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

    private static void flatten1(TreeNode root) {
        flattenHelper1(root);
    }

    private static TreeNode flattenHelper1(TreeNode root) {
        if (root == null) {
            return null;
        }
        // for leaf nodes return the node as it is
        if (root.left == null && root.right == null) {
            return root;
        }
        // flatten out the left subtree and return the left tail of the subtree
        TreeNode leftTail = flattenHelper1(root.left);
        // flatten out the right subtree and return the right tail of the subtree
        TreeNode rightTail = flattenHelper1(root.right);

        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        // return the rightmost node after we are done wiring up the new connections
        return rightTail == null ? leftTail : rightTail;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        flatten1(root);
    }
}
