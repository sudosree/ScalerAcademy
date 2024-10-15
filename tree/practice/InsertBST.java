package tree.practice;

import tree.TreeNode;

public class InsertBST {

    /**
     * TC = O(h) (worst case - O(n), best case - O(logn))
     * SC = O(h) (worst case - O(n), best case - O(logn))
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    /**
     * TC = O(h) (worst case - O(n), best case - O(logn))
     * SC = O(1)
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        TreeNode curr = root;
        while (curr != null) {
            if (val < curr.val) {
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    return root;
                }
                curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    return root;
                }
                curr = curr.right;
            }
        }
        return new TreeNode(val);
    }

}
