package tree.practice;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindAncestors {

    public static List<Integer> findAllAncestors(TreeNode root, int B) {
        List<Integer> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        findAllAncestorsHelper(root, B, list, ans);
        return ans;
    }

    private static void findAllAncestorsHelper(TreeNode root, int n, List<Integer> list, List<Integer> ans) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.val == n) {
            ans.addAll(list);
            return;
        }
        findAllAncestorsHelper(root.left, n, list, ans);
        findAllAncestorsHelper(root.right, n, list, ans);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(15);
        root.right.left.right = new TreeNode(11);
        root.right.right.left = new TreeNode(14);

        System.out.println(findAllAncestors(root, 11));
    }
}
