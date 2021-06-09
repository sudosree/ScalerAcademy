package tree.practice;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> pathsList = new ArrayList<>();
        List<Integer> pathNodes = new ArrayList<>();
        pathSumHelper(root, targetSum, pathNodes, pathsList);
        return pathsList;
    }

    private void pathSumHelper(TreeNode root, int remSum, List<Integer> pathNodes, List<List<Integer>> pathsList) {
        if (root == null) {
            return;
        }
        // add the current node to the path list
        pathNodes.add(root.val);
        // check if the sum == node's value for the leaf node
        // if it is then add the path list to the ans list
        if (root.left == null && root.right == null && remSum == root.val) {
            pathsList.add(new ArrayList<>(pathNodes));
        } else {
            pathSumHelper(root.left, remSum - root.val, pathNodes, pathsList);
            pathSumHelper(root.right, remSum - root.val, pathNodes, pathsList);
        }
        // once you process all of the subtree of the current node then pop out
        // the current node
        pathNodes.remove(pathNodes.size() - 1);
    }
}
