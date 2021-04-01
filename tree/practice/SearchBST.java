package tree.practice;

import tree.TreeNode;

public class SearchBST {

    /**
     * TC = O(h) (as we are not iterating through each and every node)
     * (in average case - O(logn), worst case - O(n))
     * SC = O(h)
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }

    /**
     * TC = O(h) (as we are not iterating through each and every node)
     * (in average case - O(logn), worst case - O(n))
     * SC = O(1)
     */
    public TreeNode searchBST1(TreeNode root, int val) {
        TreeNode node = root;
        while (node != null && node.val != val) {
            if (val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }
}
