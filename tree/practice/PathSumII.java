package tree.practice;

import java.util.Stack;
import javafx.util.Pair;
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

    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        TreeNode curr = root, prev = null;
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(new Pair(curr, targetSum - curr.val));
                path.add(curr.val);
                targetSum -= curr.val;
                curr = curr.left;
            }
            Pair<TreeNode, Integer> pair = stack.peek();
            TreeNode node = pair.getKey();
            int remainingSum = pair.getValue();
            // check if it's a leaf node and the remaining sum is 0 then add the current path
            // to the final list path
            if (node.left == null && node.right == null) {
                prev = node;
                stack.pop();
                if (remainingSum == 0) {
                    res.add(new ArrayList<>(path));
                }
                // remove the leaf node from the current path
                path.remove(path.size() - 1);
            }
            // if the node is not a leaf node
            else {
                // the right node of is not already visited
                if (node.right != null && node.right != prev) {
                    curr = node.right;
                    targetSum = remainingSum;
                }
                // the right node is already visited so pop the current node
                else {
                    prev = node;
                    stack.pop();
                    path.remove(path.size() - 1);
                }
            }
        }
        return res;
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
