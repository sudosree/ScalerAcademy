package tree.practice;

import tree.TreeNode;

public class PathWithGivenSequence {

  public static boolean findPath(TreeNode root, int[] sequence) {
    if (root == null) {
      return sequence.length == 0;
    }
    return findPathHelper(root, sequence, 0);
  }

  private static boolean findPathHelper(TreeNode root, int[] sequence, int index) {
    if (root == null) {
      return false;
    }
    // if the sequence no. is less than the current path length or the index is out of bounds or if the
    // current node's value is not equal to the current sequence value, return false this path won't lead
    // to the solution, backtrack and explore other path
    if (index >= sequence.length || root.val != sequence[index]) {
      return false;
    }
    // check if the current node is the leaf node and if it's the last sequence element
    // then the sequence is present
    if (root.left == null && root.right == null && index == sequence.length-1) {
      return true;
    }
    return findPathHelper(root.left, sequence, index+1) || findPathHelper(root.right, sequence, index+1);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(4);
    root.right.right.left = new TreeNode(5);
    root.right.right.right = new TreeNode(1);
    int[] sequence = {5, 4, 3};
    System.out.println(findPath(root, sequence));
  }
}
