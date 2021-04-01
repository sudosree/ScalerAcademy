package tree.assignment;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLCA {

    private static int ans = -1;

    public int lca(TreeNode A, int B, int C) {
        List<Integer> anc_B = new ArrayList<>();
        List<Integer> anc_C = new ArrayList<>();

        List<Integer> ans_B = new ArrayList<>();
        List<Integer> ans_C = new ArrayList<>();

        findAllAncestors(A, B, anc_B, ans_B);
        findAllAncestors(A, C, anc_C, ans_C);

        int i;
        for (i=0; i<ans_B.size() && i<ans_C.size(); i++) {
            if (ans_B.get(i) != ans_C.get(i)) {
                break;
            }
        }
        return i>0 ? ans_B.get(i-1) : -1;
    }

    private void findAllAncestors(TreeNode root, int n, List<Integer> list, List<Integer> ans) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.val == n) {
            ans.addAll(list);
            return;
        }
        findAllAncestors(root.left, n, list, ans);
        findAllAncestors(root.right, n, list, ans);
        list.remove(list.size()-1);
    }

    public static int lca1(TreeNode A, int B, int C) {
        TreeNode node = lcaHelper(A, B, C);
        return node != null ? node.val : -1;
    }

    private static TreeNode lcaHelper(TreeNode root, int B, int C) {
        if (root == null) {
            return null;
        }
        // if one of the node is the root node then lca will be the root node itself
        if (root.val == B || root.val == C) {
            return root;
        }
        // find the nodes in the left and right subtree
        TreeNode left = lcaHelper(root.left, B, C);
        TreeNode right = lcaHelper(root.right, B, C);

        // if one node is present in the left subtree and the other node is in the right
        // subtree then the lca will be the node for which this is true
        if (left != null && right != null) {
            return root;
        }

        // if both the nodes are in the left subtree then lca will be in the left subtree only
        if (left != null) {
            return left;
        }

        // if both the nodes are in the right subtree then lca will be in the right subtree only
        return right;
    }

    public static int lca2(TreeNode A, int B, int C) {
        if (!find(A, B) || !find(A, C)) {
            return -1;
        }
        TreeNode node = lcaHelper(A, B, C);
        return node.val;
    }

    private static boolean find(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (root.val == k) {
            return true;
        }
        return find(root.left, k) || find(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        /*root.right = new TreeNode(12);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(15);
        root.right.left.right = new TreeNode(11);
        root.right.right.left = new TreeNode(14);*/

        System.out.println(lca2(root, 1, 2));
    }
}
