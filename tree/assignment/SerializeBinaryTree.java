package tree.assignment;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {

    /**
     * TC = O(n), SC = O(n)
     */
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.val != -1) {
                if (node.left == null) {
                    queue.offer(new TreeNode(-1));
                } else {
                    queue.offer(node.left);
                }
                if (node.right == null) {
                    queue.offer(new TreeNode(-1));
                } else {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
