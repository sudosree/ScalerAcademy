package tree.assignment;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class DeserializeBinaryTree {

    public static TreeNode solve(int[] A) {
        TreeNode root = new TreeNode(A[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < A.length) {
            TreeNode node = queue.poll();
            // for left subtree
            if (A[i] == -1) {
                node.left = null;
            } else {
                node.left = new TreeNode(A[i]);
                queue.offer(node.left);
            }
            // for right subtree
            if (A[i+1] == -1) {
                node.right = null;
            } else {
                node.right = new TreeNode(A[i+1]);
                queue.offer(node.right);
            }
            i = i+2;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,-1,-1,4,5,-1,-1,-1,-1};
        TreeNode root = solve(A);
        SerializeBinaryTree sb = new SerializeBinaryTree();
        System.out.println(sb.solve(root));
    }
}
