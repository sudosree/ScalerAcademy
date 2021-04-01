package tree.homework;

import tree.TreeNode;

public class SortedArrayToBalancedBST {

    /**
     * TC = O(n), SC = O(logn)
     */
    public TreeNode sortedArrayToBST(final int[] A) {
        return sortedArrayToBSTHelper(A, 0, A.length-1);
    }

    private TreeNode sortedArrayToBSTHelper(int[] A, int left, int right) {
        if (left > right) {
            return null;
        }
        // using left middle element as the root of the tree everytime
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = sortedArrayToBSTHelper(A, left, mid-1);
        root.right = sortedArrayToBSTHelper(A, mid+1, right);
        return root;
    }
}
