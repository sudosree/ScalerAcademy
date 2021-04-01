package tree.homework;

import tree.TreeNode;

import java.util.Stack;

public class BSTNodesInRange {

    public int solve(TreeNode A, int B, int C) {
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = A;
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (node.val >= B && node.val <= C) {
                    count++;
                }
                node = node.right;
            }
        }
        return count;
    }
}
