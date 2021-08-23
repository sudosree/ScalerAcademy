package tree.practice;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {

    private List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                // for even level add the nodes from left to right
                if (levels.size() % 2 == 0) {
                    level.add(node.val);
                }
                // for odd level add the nodes from right to left
                else {
                    level.add(0, node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            levels.add(level);
        }
        return levels;
    }

    private List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        if (root == null) {
            return levels;
        }
        zigzagLevelOrderHelper(root, 0);
        return levels;
    }

    private void zigzagLevelOrderHelper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        // new level
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }
        // for even level add the nodes from left to right
        if (level % 2 == 0) {
            levels.get(level).add(root.val);
        }
        // for odd level add the nodes from right to left
        else {
            levels.get(level).add(0, root.val);
        }
        zigzagLevelOrderHelper(root.left, level+1);
        zigzagLevelOrderHelper(root.right, level+1);
    }

}
