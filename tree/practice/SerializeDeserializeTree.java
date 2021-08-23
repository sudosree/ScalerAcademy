package tree.practice;

import tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeTree {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private static void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("X").append(",");
            return;
        }
        sb.append(root.val).append(",");
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] str = data.split(",");
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(str));
        return buildTree(queue);
    }

    private static TreeNode buildTree(Queue<String> queue) {
        String s = queue.poll();
        if (s.equals("X")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        String s = serialize(root);
        System.out.println(s);
        deserialize(s);
    }
}
