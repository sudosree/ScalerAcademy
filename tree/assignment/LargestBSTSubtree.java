package tree.assignment;

import tree.TreeNode;

public class LargestBSTSubtree {

    /**
     * TC = O(n^2), SC = O(n) (in worst case when the tree is skewed, recursive stack
     * will contain all the nodes)
     */
    public int solve(TreeNode A) {
        return largest(A);
    }

    private int largest(TreeNode root) {
        // check if the root node is valid BST or not
        if (isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return size(root);
        }
        // if the root node is not a valid BST then check if the left and right subtrees are valid BST
        // if they are then take the max among their sizes
        return Math.max(largest(root.left), largest(root.right));
    }

    private boolean isValidBST(TreeNode root, int low, int high) {
        // empty tree is a valid BST
        if (root == null) {
            return true;
        }
        // out of range
        if (root.val < low || root.val > high) {
            return false;
        }
        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
    }

    private int size(TreeNode root) {
        // size of empty tree is 0
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    static class TreeInfo {
        boolean isValidBST;
        int size;
        int min;
        int max;
        TreeInfo(boolean isValidBST, int size, int min, int max) {
            this.isValidBST = isValidBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public static int solve1(TreeNode A) {
        return largestBSTHelper(A).size;
    }

    private static TreeInfo largestBSTHelper(TreeNode root) {
        // for null nodes
        if (root == null) {
            return new TreeInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // check for left and right subtrees
        TreeInfo left = largestBSTHelper(root.left);
        TreeInfo right = largestBSTHelper(root.right);

        // then check for root node
        // case 1: when left and right subtrees are valid BST
        if (left.isValidBST && right.isValidBST) {
            if (root.val > left.max && root.val < right.min) {
                return new TreeInfo(true, left.size + right.size + 1, Math.min(left.min, root.val), Math.max(right.max, root.val));
            }
            return new TreeInfo(false, Math.max(left.size, right.size), -1, -1);
        }

        // case 2: when one of the subtrees are not valid BST
        if (!left.isValidBST || !right.isValidBST) {
            return new TreeInfo(false, Math.max(left.size, right.size), -1, -1);
        }

        // case 3: when both the subtrees are not valid BST
        if (!left.isValidBST && !right.isValidBST) {
            return new TreeInfo(false, Math.max(left.size, right.size), -1, -1);
        }

        // case 4: when right subtree is null
        if (right == null) {
            if (root.val > left.max) {
                return new TreeInfo(true, left.size + 1, left.min, root.val);
            }
            return new TreeInfo(false, left.size, -1, -1);
        }

        // case 5: when left subtree is null
        if (left == null) {
            if (root.val < right.min) {
                return new TreeInfo(true, right.size + 1, root.val, right.max);
            }
            return new TreeInfo(false, right.size, -1, -1);
        }
        return new TreeInfo(false, 0, -1, -1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
//        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(7);
        System.out.println(solve1(root));
    }
}
