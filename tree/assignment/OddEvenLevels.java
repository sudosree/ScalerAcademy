package tree.assignment;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class OddEvenLevels {

    /**
     * TC = O(n), SC = O(n)
     */
    public static int solve(TreeNode A) {
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        int curr_level = 1;
        while (!queue.isEmpty()) {
            int curr_level_size = queue.size();
            for (int i=0;i<curr_level_size;i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (curr_level % 2 == 0) {
                    ans -= node.val;
                } else {
                    ans += node.val;
                }
            }
            curr_level++;
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
        root.left.left.left = new TreeNode(8);
        System.out.println(solve(root));
    }
}
