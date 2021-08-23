package tree.assignment;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    ArrayList<ArrayList<Integer>> levels = new ArrayList<>();

    /**
     * TC = O(n), SC = O(n)
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        if (A == null) {
            return levels;
        }
        // start with the level 0
        helper(A, 0);
        return levels;
    }

    private void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        // when you are in the new level
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(root.val);
        helper(root.left, level+1);
        helper(root.right, level+1);
    }

    /**
     * TC = O(n), SC = O(n)
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            // start the current level by adding empty list
            // into the output list levels
            levels.add(new ArrayList<>());
            // no. of elements in the current level
            int level_length = queue.size();
            for (int i=0;i<level_length;i++) {
                // pop out all the elements from the queue and
                // add them into the current level
                TreeNode node = queue.poll();
                levels.get(level).add(node.val);
                // push their child nodes into the queue for the next level
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
        }
        return levels;
    }

    private List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
