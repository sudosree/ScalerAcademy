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

    class TreeNodeInfo {
        boolean isBST;  // subtree is BST or not
        int maxNode;    // max node in the subtree
        int minNode;    // min node in the subtree
        int maxSize;    // max BST size seen so far in the subtree

        public TreeNodeInfo(boolean isBST, int maxNode, int minNode, int maxSize) {
            this.isBST = isBST;
            this.maxNode = maxNode;
            this.minNode = minNode;
            this.maxSize = maxSize;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return largestBSTSubtreeHelper(root).maxSize;
    }

    private TreeNodeInfo largestBSTSubtreeHelper(TreeNode root) {
        // if the node is empty then it's a valid BST
        if (root == null) {
            return new TreeNodeInfo(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        TreeNodeInfo left = largestBSTSubtreeHelper(root.left);
        TreeNodeInfo right = largestBSTSubtreeHelper(root.right);

        // if both the left and right subtrees are valid BSTs then check if the tree
        // rooted at the current node is valid BST or not
        if (left.isBST && right.isBST) {
            // current node's val should be greater than the max val in the left subtree and
            // current node's val should be smaller than the min val in the right subtree
            // then tree at the current node is a valid BST
            if (root.val > left.maxNode && root.val < right.minNode) {
                return new TreeNodeInfo(true, Math.max(root.val, right.maxNode), Math.min(root.val, left.minNode), 1 + left.maxSize + right.maxSize);
            }
            // tree at the current node is not a BST
            return new TreeNodeInfo(false, Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.maxSize, right.maxSize));
        }

        // if either of the subtree is a valid BST then the tree at the current node
        // is not a valid BST
        if (left.isBST || right.isBST) {
            return new TreeNodeInfo(false, Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.maxSize, right.maxSize));
        }

        // if both the subtrees are not valid BSTs then the tree at the current node
        // is not a valid BST
        return new TreeNodeInfo(false, Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.maxSize, right.maxSize));
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
