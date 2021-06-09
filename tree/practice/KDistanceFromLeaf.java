package tree.practice;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KDistanceFromLeaf {

    private static List<Integer> kDistanceFromLeaf(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();
        int[] ancestors = new int[1000];
        boolean[] visited = new boolean[1000];
        kDistanceFromLeafHelper(root, k, 0, ancestors, visited, ans);
        return ans;
    }

    private static void kDistanceFromLeafHelper(TreeNode root, int k, int pathLen, int[] ancestors, boolean[] visited, List<Integer> ans) {
        if (root == null) {
            return;
        }
        // add the root's data
        ancestors[pathLen] = root.val;
        visited[pathLen] = false;
        pathLen++;

        // if it is a leaf node then print the ancestor at a distance k from it
        // and also if it is not yet printed before
        if (root.left == null && root.right == null && pathLen - k - 1 >= 0 && !visited[pathLen-k-1]) {
            ans.add(ancestors[pathLen-k-1]);
            visited[pathLen-k-1] = true;
            return;
        }
        kDistanceFromLeafHelper(root.left, k, pathLen, ancestors, visited, ans);
        kDistanceFromLeafHelper(root.right, k, pathLen, ancestors, visited, ans);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        System.out.println(kDistanceFromLeaf(root, 2));
    }
}
