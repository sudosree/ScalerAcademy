package tree.assignment;

import tree.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {

    static class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
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

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(A, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
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
                queue.offer(new Pair(node.left, level-1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, level+1));
            }
        }

        for (int i=min;i<=max;i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
