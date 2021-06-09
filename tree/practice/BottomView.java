package tree.practice;

import java.util.*;

public class BottomView {

    static class Pair {
        TreeNode node;
        int colIndex;

        Pair(TreeNode node, int colIndex) {
            this.node = node;
            this.colIndex = colIndex;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private static List<Integer> bottomView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Map<Integer, Integer> columnMap = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            TreeNode node = p.node;
            int hd = p.colIndex;
            min = Math.min(min, hd);
            max = Math.max(max, hd);
            columnMap.put(hd, node.val);
            if (node.left != null) {
                queue.offer(new Pair(node.left, hd-1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, hd+1));
            }
        }
        for (int i=min;i<=max;i++) {
            ans.add(columnMap.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);

        System.out.println(bottomView(root));
    }
}
