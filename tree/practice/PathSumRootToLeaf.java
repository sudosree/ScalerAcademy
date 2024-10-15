package tree.practice;

import java.util.ArrayList;
import java.util.List;
import tree.TreeNode;

public class PathSumRootToLeaf {

  public static List<List<Integer>> findPaths(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<List<Integer>> allPaths = new ArrayList<>();
    List<Integer> currPath = new ArrayList<>();
    findPathsHelper(root, currPath, allPaths);
    return allPaths;
  }

  private static void findPathsHelper(TreeNode root, List<Integer> currPath, List<List<Integer>> allPaths) {
    if (root == null) {
      return;
    }
    // add the curr node to the curr path
    currPath.add(root.val);
    // check if it's a leaf node then add the current path to the final path
    if (root.left == null && root.right == null) {
      allPaths.add(new ArrayList<>(currPath));
    } else {
      findPathsHelper(root.left, currPath, allPaths);
      findPathsHelper(root.right, currPath, allPaths);
    }
    // pop the curr node as it's left and right subtrees are processed
    currPath.remove(currPath.size()-1);
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
    System.out.println(findPaths(root));
  }
}
