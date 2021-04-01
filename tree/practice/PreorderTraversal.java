package tree.practice;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    /**
     * TC = O(n), SC = O(h) (worst case - O(n), average case - O(logn) )
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        // it handles the empty tree condition check
        while (node != null || !stack.empty()) {
            // we still have to traverse the subtree from this node
            if (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
        return res;
    }
}
