package tree.assignment;

import tree.TreeNode;

public class CountingNodes {

    public static int solve(TreeNode A) {
        return countNodes(A, Integer.MIN_VALUE);
    }

    private static int countNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        if (root.val > max) {
            max = root.val;
            ans = 1;
        }
        ans += countNodes(root.left, max);
        ans += countNodes(root.right, max);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(7);
//        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);
        System.out.println(solve(root));
    }
}
