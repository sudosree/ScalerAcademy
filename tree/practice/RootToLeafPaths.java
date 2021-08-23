package tree.practice;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RootToLeafPaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        binaryTreePathsHelper(root, sb, ans);
        return ans;
    }

    private void binaryTreePathsHelper(TreeNode root, StringBuilder sb, List<String> ans) {
        if (root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            ans.add(sb.toString());
        }
        sb.append("->");
        binaryTreePathsHelper(root.left, sb, ans);
        binaryTreePathsHelper(root.right, sb, ans);
        sb.setLength(len);
    }

    static class Pair {
        TreeNode node;
        String path;

        Pair(TreeNode node, String path) {
            this.node = node;
            this.path = path;
        }
    }

    public static List<String> binaryTreePaths1(TreeNode root) {
        List<String> ans = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, "" + root.val));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            TreeNode node = p.node;
            String path = p.path;
            if (node.left == null && node.right == null) {
                ans.add(path);
            }
            if (node.left != null) {
                queue.offer(new Pair(node.left, path + "->" + node.left.val));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, path + "->" + node.right.val));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(binaryTreePaths1(root));
    }
}
