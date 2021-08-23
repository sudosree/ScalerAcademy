package tree.practice;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> pathsList = new ArrayList<>();
        List<Integer> pathNodes = new ArrayList<>();
        pathSumHelper(root, targetSum, pathNodes, pathsList);
        return pathsList;
    }

    private static void pathSumHelper(TreeNode root, int remSum, List<Integer> pathNodes, List<List<Integer>> pathsList) {
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

    private void pathSumHelper1(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ans.add(new ArrayList<>(list));
        }
        pathSumHelper1(root.left, targetSum, list, ans);
        pathSumHelper1(root.right, targetSum, list, ans);
        list.remove(list.size() - 1);
        targetSum += root.val;
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

        System.out.println(pathSum(root, 22));
    }
}
