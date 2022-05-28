package tree.practice;

import tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeTree {

    // to split each nodes
    private static final String splitter = ",";
    // to keep track of null nodes
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private static void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NN).append(splitter);
            return;
        }
        // process the node
        sb.append(root.val).append(splitter);
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(splitter)));
        return buildTree(queue);
    }

    private static TreeNode buildTree(Queue<String> queue) {
        String data = queue.poll();
        if (data.equals(NN)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }

    public static String serialize1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(splitter);
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                sb.append(NN).append(splitter);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize1(String data) {
        String[] str = data.split(splitter);
        if (str[0].equals(NN)) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        queue.offer(root);
        int i=1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // create the left subtree
            if (!str[i].equals(NN)) {
                node.left = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(node.left);
            }
            i++;
            // create the right subtree
            if (!str[i].equals(NN)) {
                node.right = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String s = serialize(root);
        System.out.println(s);
        deserialize(s);
        String s1 = serialize1(root);
        System.out.println(s1);
        deserialize1(s1);
    }
}
