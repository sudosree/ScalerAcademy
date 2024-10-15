package tree.assignment;

import javafx.util.Pair;
import tree.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {

    static class Pair1 {
        TreeNode node;
        int level;

        public Pair1(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    /**
     * TC = O(n), SC = O(n)
     */
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (A == null) {
            return res;
        }

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        Queue<Pair1> queue = new LinkedList<>();
        queue.offer(new Pair1(A, 0));

        while (!queue.isEmpty()) {
            Pair1 pair = queue.poll();
            TreeNode node = pair.node;
            int level = pair.level;
            if (level < min) {
                min = level;
            }
            if (level > max) {
                max = level;
            }
            ArrayList<Integer> curr = new ArrayList<>();
            if (!map.containsKey(level)) {
                map.put(level, curr);
            }
            curr = map.get(level);
            curr.add(node.val);
            map.put(level, curr);
            if (node.left != null) {
                queue.offer(new Pair1(node.left, level-1));
            }
            if (node.right != null) {
                queue.offer(new Pair1(node.right, level+1));
            }
        }

        for (int i=min;i<=max;i++) {
            res.add(map.get(i));
        }
        return res;
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> columnMap = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int column = 0;
        queue.offer(new Pair(root, column));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode curr = pair.getKey();
            column = pair.getValue();
            if (!columnMap.containsKey(column)) {
                columnMap.put(column, new ArrayList<>());
            }
            columnMap.get(column).add(curr.val);
            if (curr.left != null) {
                queue.offer(new Pair(curr.left, column-1));
            }
            if (curr.right != null) {
                queue.offer(new Pair(curr.right, column+1));
            }
        }
        List<Integer> sortedKeys = new ArrayList<>(columnMap.keySet());
        Collections.sort(sortedKeys);
        List<List<Integer>> result = new ArrayList<>();
        for (int k : sortedKeys) {
            result.add(columnMap.get(k));
        }
        return result;
    }
}
