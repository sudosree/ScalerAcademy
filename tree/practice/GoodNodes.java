package tree.practice;

import tree.TreeNode;

import java.util.Stack;

public class GoodNodes {

    private int goodNodes = 0;

    public int goodNodes(TreeNode root) {
        int maxSoFar = Integer.MIN_VALUE;
        goodNodesHelper(root, maxSoFar);
        return goodNodes;
    }

    private void goodNodesHelper(TreeNode root, int maxSoFar) {
        if (root == null) {
            return;
        }
        if (maxSoFar <= root.val) {
            maxSoFar = root.val;
            goodNodes++;
        }
        goodNodesHelper(root.left, maxSoFar);
        goodNodesHelper(root.right, maxSoFar);
    }

    static class Pair {
        TreeNode node;
        int maxSoFar;

        Pair(TreeNode node, int maxSoFar) {
            this.node = node;
            this.maxSoFar = maxSoFar;
        }
    }

    public int goodNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int goodNodes = 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, Integer.MIN_VALUE));

        while (!stack.empty()) {
            Pair p = stack.pop();
            TreeNode node = p.node;
            int maxSoFar = p.maxSoFar;

            if (maxSoFar <= node.val) {
                maxSoFar = node.val;
                goodNodes++;
            }

            if (node.left != null) {
                stack.push(new Pair(node.left, maxSoFar));
            }

            if (node.right != null) {
                stack.push(new Pair(node.right, maxSoFar));
            }
        }
        return goodNodes;
    }
}
