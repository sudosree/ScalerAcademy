package tree.assignment;

import tree.TreeNode;

import java.util.Stack;

public class KthSmallestElement {

    /**
     * TC = O(h+k) (where stack contains at least h+k elements, in worst case it
     * will be O(n+k) and average case will be O(logn+k) )
     * SC = O(h)
     */
    public int kthsmallest(TreeNode A, int B) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = A;
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                B--;
                if (B == 0) {
                    return node.val;
                }
                node = node.right;
            }
        }
        return -1;
    }

    private int ans;
    private int count;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        kthSmallestHelper(root);
        return ans;
    }

    private void kthSmallestHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        kthSmallestHelper(root.left);
        count--;
        if (count == 0) {
            ans = root.val;
            return;
        }
        kthSmallestHelper(root.right);
    }
}
