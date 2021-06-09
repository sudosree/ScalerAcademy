package tree.homework;

import tree.TreeNode;

public class DistanceBetweenTwoNodes {

    public static int solve(TreeNode A, int B, int C) {
        TreeNode lca = findLCA(A, B, C);
        return distance(lca, B) + distance(lca, C);
    }

    private static TreeNode findLCA(TreeNode root, int A, int B) {
        if (root == null) {
            return null;
        }
        // lca is the root node
        if (root.val == A || root.val == B) {
            return root;
        }
        // lca lies in the left subtree
        if (A < root.val && B < root.val) {
            return findLCA(root.left, A, B);
        }
        // lca lies in the right subtree
        if (A > root.val && B > root.val) {
            return findLCA(root.right, A, B);
        }
        // either A lies in left subtree and B lies in right subtree or vice versa
        // then the current node is the lca
        return root;
    }

    private static int distance(TreeNode root, int A) {
        if (root.val == A) {
            return 0;
        }
        if (A < root.val) {
            return 1 + distance(root.left, A);
        }
        return 1 + distance(root.right, A);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(3);
        root.left.right.right = new TreeNode(6);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(12);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(10);
        root.right.right.right = new TreeNode(13);

        System.out.println(solve(root, 1, 6));
    }
}
