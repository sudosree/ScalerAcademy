package tree.practice;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindPathBetweenTwoNodes {

    private static void printPathBetweenNodes(TreeNode root, int n1, int n2) {
        List<Integer> anc1 = new ArrayList<>();
        List<Integer> anc2 = new ArrayList<>();

        getPath(root, n1, anc1);
        getPath(root, n2, anc2);

        int i=0,j=0;
        int intersection = -1;
        while (i < anc1.size() && j < anc2.size()) {
            // as long as the ancestors are same, keep moving forward
            if (anc1.get(i) == anc2.get(j)) {
                i++;
                j++;
            } else {
                intersection = i-1;
                break;
            }
        }

        if (i == anc1.size()) {
            intersection = i-1;
        }
        if (j == anc2.size()) {
            intersection = j-1;
        }

        for (int k=anc1.size()-1; k>intersection; k--) {
            System.out.print(anc1.get(k) + " ");
        }
        for (int k=intersection; k<anc2.size(); k++) {
            System.out.print(anc2.get(k) + " ");
        }
    }

    private static boolean getPath(TreeNode root, int n, List<Integer> anc) {
        // no path exists
        if (root == null) {
            return false;
        }
        anc.add(root.val);
        // found the node n
        if (root.val == n) {
            return true;
        }
        // if not found then check if the node is present in the left or right subtree
        if (getPath(root.left, n, anc) || getPath(root.right, n, anc)) {
            return true;
        }
        // if the node is not found then remove the current node
        anc.remove(anc.size()-1);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        printPathBetweenNodes(root, 9, 6);
    }
}
