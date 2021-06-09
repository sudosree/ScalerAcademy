package tree.practice;

import tree.TreeNode;

import java.util.*;

public class ConstructBinaryTreeFromPostorderAndInorder {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }
        return constructTreeHelper(postorder, map, postorder.length-1, 0, inorder.length-1);
    }

    private static TreeNode constructTreeHelper(int[] postorder, Map<Integer, Integer> map, int post, int in_left, int in_right) {
        // out of range
        if (post < 0 || in_left > in_right) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[post]);
        int root_idx = map.get(postorder[post]);
        // post - in_right - root_idx - 1 determines the root index for the left subtree in the postorder array
        root.left = constructTreeHelper(postorder, map, (post - (in_right - root_idx)) - 1, in_left, root_idx - 1);
        // post - 1 determines the root index for the right subtree in the postorder array
        root.right = constructTreeHelper(postorder, map, post - 1, root_idx + 1, in_right);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
    }
}
