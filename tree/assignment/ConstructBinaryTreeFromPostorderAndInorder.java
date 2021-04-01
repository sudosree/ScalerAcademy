package tree.assignment;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPostorderAndInorder {

    static int post_order_idx;
    static Map<Integer, Integer> map = new HashMap<>();

    static public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        for (int i=0;i<n;i++) {
            map.put(inorder[i], i);
        }
        post_order_idx = n-1;
        return constructTree(inorder, postorder, 0, n-1);
    }

    public static TreeNode constructTree(int[] inorder, int[] postorder,
                                  int left_in, int right_in) {

        if (left_in > right_in) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[post_order_idx]);
        // find the root's index in the inorder array
        int root_idx = map.get(postorder[post_order_idx]);
        post_order_idx--;

        root.right = constructTree(inorder, postorder, root_idx+1, right_in);
        root.left = constructTree(inorder, postorder, left_in, root_idx-1);
        return root;
    }

    static public TreeNode buildTree1(int[] inorder, int[] postorder) {
        int n = postorder.length;
        for (int i=0;i<n;i++) {
            map.put(inorder[i], i);
        }
        return constructTree1(inorder, postorder, 0, n-1, 0, n-1);
    }

    public static TreeNode constructTree1(int[] inorder, int[] postorder,
                                         int left_in, int right_in,
                                          int left_post, int right_post) {

        if (left_in > right_in || left_post > right_post) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[right_post]);
        // find the root's index in the inorder array
        int root_idx = map.get(postorder[right_post]);
        int count = root_idx - left_in;

        root.left = constructTree1(inorder, postorder, left_in, root_idx-1, left_post, left_post+count-1);
        root.right = constructTree1(inorder, postorder, root_idx+1, right_in, left_post+count, right_post-1);
        return root;
    }

    public static void main(String[] args) {
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};
        System.out.println(buildTree(inorder,postorder));
    }
}
