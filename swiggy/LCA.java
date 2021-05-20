package swiggy;

import tree.TreeNode;

import java.util.*;

public class LCA {

    private static int findLCA(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        stack.push(root);
        parent.put(root, null);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
                parent.put(node.left, node);
            }
            if (node.left != null) {
                stack.push(node.left);
                parent.put(node.left, node);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q.val;
    }


}
