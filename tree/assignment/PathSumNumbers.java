package tree.assignment;

import java.util.ArrayDeque;
import java.util.Deque;
import javafx.util.Pair;
import tree.TreeNode;

public class PathSumNumbers {

    public int totalPathSum;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        totalPathSum = 0;
        StringBuilder currPath = new StringBuilder();
        sumNumbersHelper(root, currPath);
        return totalPathSum;
    }

    private void sumNumbersHelper(TreeNode root, StringBuilder currPath) {
        if (root == null) {
            return;
        }
        currPath.append(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            int currNum = Integer.parseInt(currPath.toString());
            totalPathSum += currNum;
        } else {
            sumNumbersHelper(root.left, currPath);
            sumNumbersHelper(root.right, currPath);
        }
        currPath.deleteCharAt(currPath.length()-1);
    }

    public int sumNumbers1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        totalPathSum = 0;
        sumNumbersHelper1(root, 0);
        return totalPathSum;
    }

    private void sumNumbersHelper1(TreeNode root, int currNum) {
        if (root == null) {
            return;
        }
        currNum = currNum * 10 + root.val;
        if (root.left == null && root.right == null) {
            totalPathSum += currNum;
        }
        sumNumbersHelper1(root.left, currNum);
        sumNumbersHelper1(root.right, currNum);
    }

    public static int sumNumbers2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int totalPathSum = 0;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair(root, 0));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int currSum = pair.getValue();
            currSum = currSum * 10 + node.val;
            if (node.left == null && node.right == null) {
                totalPathSum += currSum;
            }
            if (node.right != null) {
                stack.push(new Pair(node.right, currSum));
            }
            if (node.left != null) {
                stack.push(new Pair(node.left, currSum));
            }
        }
        return totalPathSum;
    }

    private static int pathSumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return pathSumNumbersHelper(root, 0);
    }

    private static int pathSumNumbersHelper(TreeNode root, int pathSum) {
        if (root == null) {
            return 0;
        }
        pathSum = 10 * pathSum + root.val;
        if (root.left == null && root.right == null) {
            return pathSum;
        }
        return pathSumNumbersHelper(root.left, pathSum) + pathSumNumbersHelper(root.right, pathSum);
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
        System.out.println(sumNumbers2(root));
//        System.out.println(pathSumNumbers(root));
    }
}
