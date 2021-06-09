package tree.practice;

import java.util.*;

public class MirrorNAryTree {

    static class TreeNode {
        int val;
        List<TreeNode> children;

        TreeNode(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    private static void mirrorNAry(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> children = root.children;
        int size = children.size();
        if (size < 2) {
            return;
        }
        for (int i=0;i<size;i++) {
            mirrorNAry(children.get(i));
        }
        Collections.reverse(children);
    }

    private static void mirrorNAryLevel(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            List<TreeNode> children = node.children;
            for (int i=0;i<children.size();i++) {
                queue.offer(children.get(i));
            }
            Collections.reverse(node.children);
        }
    }

    private static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            List<TreeNode> children = node.children;
            for (int i=0;i<children.size();i++) {
                queue.offer(children.get(i));
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode c1 = new TreeNode(2);
        TreeNode c2 = new TreeNode(3);
        TreeNode c3 = new TreeNode(4);
        TreeNode c4 = new TreeNode(5);
        TreeNode c5 = new TreeNode(6);
        TreeNode c6 = new TreeNode(7);
        TreeNode c7 = new TreeNode(8);
        TreeNode c8 = new TreeNode(9);
        TreeNode c9 = new TreeNode(10);

        root.children.add(c1);
        root.children.add(c2);
        root.children.add(c3);

        c1.children.add(c4);
        c1.children.add(c5);
        c2.children.add(c6);
        c3.children.add(c7);
        c3.children.add(c8);
        c3.children.add(c9);

//        mirrorNAry(root);
        mirrorNAryLevel(root);
        print(root);
    }
}
