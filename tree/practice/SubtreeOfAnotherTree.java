package tree.practice;

import tree.TreeNode;

public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (sameTree(root, subRoot)) {
            return true;
        }
        // if the root's value are not same check if the subtree is present
        // on the left side or the right side
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean sameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return sameTree(s.left, t.left) && sameTree(s.right, t.right);
    }
}
