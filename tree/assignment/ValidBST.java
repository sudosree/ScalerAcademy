package tree.assignment;

import tree.TreeNode;

import java.util.Stack;

public class ValidBST {

    /**
     * TC = O(n), SC = O(n)
     */
    public static int isValidBST(TreeNode A) {
        if (A == null) {
            return 1;
        }
        return validBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    private static boolean validBST(TreeNode root, int left, int right) {
        if (root == null) {
            return true;
        }
        if (root.val <= left || root.val >= right) {
            return false;
        }
        return validBST(root.left, left, root.val) && validBST(root.right, root.val, right);
    }

    /**
     * TC = O(n), SC = O(n)
     */
    public static boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root, prev = null;
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (prev != null && node.val <= prev.val) {
                    return false;
                }
                prev = node;
                node = node.right;
            }
        }
        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        // empty trees are valid BSTs
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> low = new Stack<>();
        Stack<Integer> high = new Stack<>();

        stack.push(root);
        low.push(null);
        high.push(null);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            Integer left = low.pop();
            Integer right = high.pop();
            if (left != null && node.val <= left || right != null && node.val >= right) {
                return false;
            }
            if (node.left != null) {
                stack.push(node.left);
                low.push(left);
                high.push(node.val);
            }
            if (node.right != null) {
                stack.push(node.right);
                low.push(node.val);
                high.push(right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        System.out.println(isValidBST(root));
    }
}
