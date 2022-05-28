package tree.assignment;

import tree.TreeNode;

public class PathSumNumbers {

    private static int pathSumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return pathSumNumbersHelper(root, 0);
    }

    private static int pathSumNumbersHelper(TreeNode root, int pathSum) {
        if (root == null) {
            return 0;
        }
        pathSum = 10 * pathSum + root.val;
        if (root.left == null && root.right == null) {
            return pathSum;
        }
        return pathSumNumbersHelper(root.left, pathSum) + pathSumNumbersHelper(root.right, pathSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(9);
        System.out.println(pathSumNumbers(root));
    }
}
