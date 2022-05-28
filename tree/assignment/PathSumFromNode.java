package tree.assignment;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumFromNode {

    private static int countPathSumFromAnyNode(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // get the no. of paths that start from the current node
        // and whose sum is equal to the target sum
        int countPathSum = countPathSumFromRoot(root, 0, sum);
        int countLeftPathSum = countPathSumFromAnyNode(root.left, sum);
        int countRightPathSum = countPathSumFromAnyNode(root.right, sum);
        return countPathSum + countLeftPathSum + countRightPathSum;
    }

    private static int countPathSumFromRoot(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        sum += root.val;
        // if at any point of time the sum becomes equal to the target sum
        // then increment the count, you keep following the path, you do not need
        // to return as there can be another valid path down the path
        if (sum == targetSum) {
            count++;
        }
        count += countPathSumFromRoot(root.left, sum, targetSum);
        count += countPathSumFromRoot(root.right, sum, targetSum);
        return count;
    }

    private static int countPathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return countPathSumHelper(root, sum, 0, map);
    }

    private static int countPathSumHelper(TreeNode root, int sum, int prefixSum, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        prefixSum += root.val;
        if (map.containsKey(prefixSum - sum)) {
            count += map.get(prefixSum - sum);
        }
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        count += countPathSumHelper(root.left, sum, prefixSum, map);
        count += countPathSumHelper(root.right, sum, prefixSum, map);
        map.put(prefixSum, map.get(prefixSum) - 1);
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(-5);
        root.right.left.right = new TreeNode(4);
        root.right.left.right.left = new TreeNode(-6);
        root.right.left.right.left.right = new TreeNode(2);
        System.out.println(countPathSumFromAnyNode(root, 6));
        System.out.println(countPathSum(root, 6));
    }
}
