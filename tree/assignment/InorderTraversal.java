package tree.assignment;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    /**
     * TC = O(n), SC = O(h) (worst case - O(n), average case - O(logn) )
     */
    public static ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        if (A == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        TreeNode node = A;
        while (!stack.empty()) {
            while (node.left != null) {
                node = node.left;
                stack.push(node);
            }
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            if (tmp.right != null) {
                stack.push(tmp.right);
                node = tmp.right;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(inorderTraversal(root));
    }
}
