package tree.practice;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorder {

    static Map<Integer, Integer> map = new HashMap<>();
    static int pre_order_idx;

    /**
     * TC = O(n), SC = O(n)
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i=0;i<n;i++) {
            map.put(inorder[i], i);
        }
        return constructTree(preorder, inorder, 0, n-1, 0, n-1);
    }

    public static TreeNode constructTree(int[] preorder, int[] inorder,
                                  int left_pre, int right_pre,
                                  int left_in, int right_in) {
        if (left_in > right_in || left_pre > right_pre) {
            return null;
        }
        // root is always the first element of the preorder array
        TreeNode root = new TreeNode(preorder[left_pre]);
        int root_idx = map.get(preorder[left_pre]);
        // count the no. of nodes between the root's index and the left index of inorder array
        // this is for the case when left subtree doesn't exist
        int count = root_idx - left_in;

        root.left = constructTree(preorder, inorder, left_pre+1, left_pre+count,
                left_in, root_idx-1);
        root.right = constructTree(preorder, inorder, left_pre+count+1, right_pre,
                root_idx+1, right_in);
        return root;
    }

    public static TreeNode buildTree1(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i=0;i<n;i++) {
            map.put(inorder[i], i);
        }
        pre_order_idx = 0;
        return constructTree1(preorder, inorder, 0, n-1);
    }

    public static TreeNode constructTree1(int[] preorder, int[] inorder,
                                         int left_in, int right_in) {
        if (left_in > right_in) {
            return null;
        }
        // root is always the first element of the preorder array
        TreeNode root = new TreeNode(preorder[pre_order_idx]);
        int root_idx = map.get(preorder[pre_order_idx]);
        pre_order_idx++;

        root.left = constructTree1(preorder, inorder, left_in, root_idx-1);
        root.right = constructTree1(preorder, inorder,root_idx+1, right_in);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1,2,3};
        int[] inorder = {2,3,1};
        System.out.println(buildTree(preorder, inorder));
    }
}
