package tree.assignment;

import tree.TreeNode;

public class PathSequence {

    private static boolean pathWithSequence(TreeNode root, int[] sequence) {
        if (root == null) {
            return false;
        }
        return helper(root, sequence, 0);
    }

    private static boolean helper(TreeNode root, int[] sequence, int pos) {
        if (root == null) {
            return false;
        }
        if (sequence[pos] != root.val) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return helper(root.left, sequence, pos+1) || helper(root.right, sequence, pos+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        int[] sequence = {1, 1, 6};
        System.out.println(pathWithSequence(root, sequence));
    }
}
