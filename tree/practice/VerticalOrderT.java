package tree.practice;

import java.util.*;

public class VerticalOrderT {

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

    private List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Map<Integer, List<Integer>> columnMap = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int minColIdx = Integer.MAX_VALUE, maxColIdx = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            TreeNode node = p.node;
            int columnIdx = p.colIndex;
            minColIdx = Math.min(minColIdx, columnIdx);
            maxColIdx = Math.max(maxColIdx, columnIdx);
            if (!columnMap.containsKey(columnIdx)) {
                columnMap.put(columnIdx, new ArrayList<>());
            }
            columnMap.get(columnIdx).add(node.val);
            if (node.left != null) {
                queue.offer(new Pair(node.left, columnIdx-1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, columnIdx+1));
            }
        }
        for (int i=minColIdx;i<=maxColIdx;i++) {
            List<Integer> l = columnMap.get(i);
            ans.add(l);
        }
        return ans;
    }
}
