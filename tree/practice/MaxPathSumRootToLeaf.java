package tree.practice;

import java.util.ArrayList;
import java.util.List;
import tree.TreeNode;

public class MaxPathSumRootToLeaf {

  public static int maxPathSum;

  /**
   * TC = O(n^2), SC = O(n)
   * @param root
   * @return
   */
  public static List<List<Integer>> findMaxPaths(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    maxPathSum = Integer.MIN_VALUE;
    List<List<Integer>> allPaths = new ArrayList<>();
    List<Integer> currPath = new ArrayList<>();
    findMaxPathsHelper(root, currPath, allPaths, 0);
    return allPaths;
  }

  private static void findMaxPathsHelper(TreeNode root, List<Integer> currPath, List<List<Integer>> allPaths, int currPathSum) {
    if (root == null) {
      return;
    }
    currPathSum += root.val;
    currPath.add(root.val);
    // check if it's a leaf node and the curr path sum is greater than the max path sum seen so far
    if (root.left == null && root.right == null && currPathSum >= maxPathSum) {
      maxPathSum = currPathSum;
      allPaths.add(new ArrayList<>(currPath));
    } else {
      findMaxPathsHelper(root.left, currPath, allPaths, currPathSum);
      findMaxPathsHelper(root.right, currPath, allPaths, currPathSum);
    }
    currPathSum -= root.val;
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
    root.right.right.left.right = new TreeNode(5);
    root.right.right.right = new TreeNode(1);
    System.out.println(findMaxPaths(root));
  }

}
