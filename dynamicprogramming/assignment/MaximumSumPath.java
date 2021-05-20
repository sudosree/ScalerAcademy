package dynamicprogramming.assignment;

import tree.TreeNode;

public class MaximumSumPath {

    private int max_sum_path = Integer.MIN_VALUE;

    /**
     * TC = O(n), SC = O(h)
     * @param A
     * @return
     */
    public int maxPathSum(TreeNode A) {
        maxPathSumHelper(A);
        return max_sum_path;
    }

    private int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);

        // maximum sum path that from the subtree that will return to the parent
        int max_sum_single = Math.max(Math.max(left, right) + root.val, root.val);
        int max_sum_tree = Math.max(max_sum_single, left + root.val + right);
        max_sum_path = Math.max(max_sum_path, max_sum_tree);
        return max_sum_single;
    }
}
