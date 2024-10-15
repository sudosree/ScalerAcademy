package tree.practice;

import java.util.Stack;
import tree.TreeNode;

public class BSTToGreaterTree {

  int sum = 0;

  public TreeNode convertBST(TreeNode root) {
    if (root == null) {
      return root;
    }
    convertBST(root.right);
    sum += root.val;
    root.val = sum;
    convertBST(root.left);
    return root;
  }

  public TreeNode convertBST1(TreeNode root) {
    if (root == null) {
      return root;
    }
    int sum = 0;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    while (curr != null || !stack.empty()) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.right;
      }
      curr = stack.pop();
      sum += curr.val;
      curr.val = sum;
      curr = curr.left;
    }
    return root;
  }
}
