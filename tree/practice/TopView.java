package tree.practice;

import tree.TreeNode;

import java.util.*;

public class TopView {

    static class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    private static List<Integer> topView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Pair p = queue.poll();
                TreeNode node = p.node;
                int level = p.level;
                min = Math.min(min, level);
                max = Math.max(max, level);
                if (!map.containsKey(level)) {
                    map.put(level, node.val);
                }
                if (node.left != null) {
                    queue.offer(new Pair(node.left, level-1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, level+1));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i=min; i<=max; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(topView(root));
    }
}
