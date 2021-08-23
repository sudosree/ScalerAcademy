package tree.practice;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPath {

    private static List<List<Integer>> printPath(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathHelper(root, path, ans);
        return ans;
    }

    private static void pathHelper(TreeNode root, List<Integer> path, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            ans.add(new ArrayList<>(path));
        }
        pathHelper(root.left, path, ans);
        pathHelper(root.right, path, ans);
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(printPath(root));

    }
}
