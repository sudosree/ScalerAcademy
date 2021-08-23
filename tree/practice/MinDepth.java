package tree.practice;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // find the min depth in left subtree
        int left = minDepth(root.left);
        // find the min depth in right subtree
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return Math.max(left, right) + 1;
        }
        return Math.min(left, right) + 1;
    }

    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.right.left.left = new TreeNode(9);

        System.out.println(minDepth(root));
    }

}
