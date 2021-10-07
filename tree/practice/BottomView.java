package tree.practice;

import java.util.*;

public class BottomView {

    static class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
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
            int hd = p.hd;
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

    private static List<Integer> bottomView1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            TreeNode node = p.node;
            int hd = p.hd;
            if (hd < min) {
                min = hd;
            }
            if (hd > max) {
                max = hd;
            }
            if (!map.containsKey(hd)) {
                map.put(hd, new ArrayList<>());
            }
            map.get(hd).add(node.val);

            if (node.left != null) {
                queue.offer(new Pair(node.left, hd-1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, hd+1));
            }
        }

        for (int i=min; i<=max; i++) {
            List<Integer> list = map.get(i);
            ans.add(list.get(list.size() - 1));
        }
        return ans;
    }

    private static List<Integer> bottomView2(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        Map<Integer, TreeNode> map = new HashMap<>();
        int minHd = Integer.MAX_VALUE, maxHd = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int hd = pair.hd;
                map.put(hd, node);
                minHd = Math.min(minHd, hd);
                maxHd = Math.max(maxHd, hd);
                if (node.left != null) {
                    queue.offer(new Pair(node.left, hd-1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, hd+1));
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i=minHd; i<=maxHd; i++) {
            ans.add(map.get(i).val);
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
        System.out.println(bottomView1(root));
        System.out.println(bottomView2(root));
    }
}
