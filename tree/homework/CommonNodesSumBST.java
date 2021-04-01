package tree.homework;

import tree.TreeNode;

import java.util.*;

public class CommonNodesSumBST {

    /**
     * TC = O(m+n), SC = O(m+n) (where m = no. of nodes in tree A and
     * n = no. of nodes in tree B)
     */
    public int solve(TreeNode A, TreeNode B) {
        List<Integer> listA = inorder(A);
        List<Integer> listB = inorder(B);

        Set<Integer> set = new HashSet<>();
        for (int i=0;i<listA.size();i++) {
            set.add(listA.get(i));
        }

        int sum = 0, mod = 1000000007;
        for (int i=0;i<listB.size();i++) {
            if (set.contains(listB.get(i))) {
                sum = (sum + listB.get(i)) % mod;
            }
        }
        return sum;
    }

    private List<Integer> inorder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                ans.add(node.val);
                node = node.right;
            }
        }
        return ans;
    }

    /**
     * TC = O(m+n) (where m = no. of nodes in tree A, n = no. of nodes in tree B)
     * SC = O(hA+hB) (where hA = height of tree A, hB = height of tree B)
     */
    public int solve1(TreeNode A, TreeNode B) {
        int sum = 0, mod = 1000000007;
        Stack<TreeNode> stackA = new Stack<>();
        Stack<TreeNode> stackB = new Stack<>();
        TreeNode nodeA = A, nodeB = B;
        while ((nodeA != null || !stackA.empty()) && (nodeB != null || !stackB.empty())) {
            // push the nodes from tree A in stack A
            if (nodeA != null) {
                stackA.push(nodeA);
                nodeA = nodeA.left;
            }
            // push the nodes from tree B in stack B
            else if (nodeB != null) {
                stackB.push(nodeB);
                nodeB = nodeB.left;
            }
            // if either of them is null
            else {
                TreeNode topA = stackA.peek();
                TreeNode topB = stackB.peek();
                if (topA.val == topB.val) {
                    sum = (sum + topA.val) % mod;
                    nodeA = stackA.pop();
                    nodeB = stackB.pop();
                    nodeA = nodeA.right;
                    nodeB = nodeB.right;
                } else if (topA.val < topB.val) {
                    nodeA = stackA.pop();
                    nodeA = nodeA.right;
                } else {
                    nodeB = stackB.pop();
                    nodeB = nodeB.right;
                }
            }
        }
        return sum;
    }
}
