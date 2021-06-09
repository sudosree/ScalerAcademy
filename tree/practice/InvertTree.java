package tree.practice;

import tree.TreeNode;

import java.util.*;

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

    private static TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            // we still have to traverse the subtree from this node
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            // we have completed traversing the left subtree, now we have to
            // traverse the right subtree
            else {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode node = invertTree2(root);
        System.out.println(inorderTraversal1(node));
    }
}
