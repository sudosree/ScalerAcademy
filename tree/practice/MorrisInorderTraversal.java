package tree.practice;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            // if no left subtree is present, then process the current node
            // and go to its right subtree
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                // find the inorder predecessor of the current node
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                }
                // completed processing the left subtree of the current node
                else {
                    pred.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(6);
        System.out.println(inorderTraversal(root));
    }
}
