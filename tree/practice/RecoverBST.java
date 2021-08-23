package tree.practice;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RecoverBST {

    public void recoverTree(TreeNode root) {
        // do the inorder traversal of the tree and store the
        // node's value in a list
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);

        // find the two swapped nodes from the list
        int[] swapped = findSwappedNodes(nums);

        // again traverse the tree and swap the two nodes
        swapNodes(root, 2, swapped[0], swapped[1]);
    }

    private void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    private int[] findSwappedNodes(List<Integer> nums) {
        int x = -1, y = -1;
        for (int i=0;i<nums.size()-1;i++) {
            if (nums.get(i+1) < nums.get(i)) {
                y = nums.get(i+1);
                if (x == -1) {
                    x = nums.get(i);
                } else {
                    break;
                }
            }
        }
        return new int[] {x, y};
    }

    private void swapNodes(TreeNode root, int count, int x, int y) {
        if (root == null) {
            return;
        }
        if (root.val == x || root.val == y) {
            root.val = root.val == x ? y : x;
            count--;
            // done swapping the nodes
            if (count == 0) {
                return;
            }
        }
        swapNodes(root.left, count, x, y);
        swapNodes(root.right, count, x, y);
    }

    public void recoverTree1(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode x = null, y = null, pred = null;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (pred != null && node.val < pred.val) {
                    y = node;
                    if (x == null) {
                        x = pred;
                    } else {
                        break;
                    }
                }
                pred = node;
                node = node.right;
            }
        }
        int t = x.val;
        x.val = y.val;
        y.val = t;
    }

    private TreeNode x = null, y = null, pred = null;

    public void recoverTree2(TreeNode root) {
        findSwappedNodes(root);
        int t = x.val;
        x.val = y.val;
        y.val = t;
    }

    // modified inorder traversal
    private void findSwappedNodes(TreeNode root) {
        if (root == null) {
            return;
        }
        findSwappedNodes(root.left);
        if (pred != null && root.val < pred.val) {
            y = root;
            if (x == null) {
                x = pred;
            } else {
                return;
            }
        }
        pred = root;
        findSwappedNodes(root.right);
    }

    public void recoverTree3(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode x = null, y = null, pred = null;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                if (pred != null && curr.val < pred.val) {
                    y = curr;
                    if (x == null) {
                        x = pred;
                    }
                }
                pred = curr;
                curr = curr.right;
            } else {
                TreeNode predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    if (pred != null && curr.val < pred.val) {
                        y = curr;
                        if (x == null) {
                            x = pred;
                        }
                    }
                    pred = curr;
                    predecessor.right = null;
                    curr = curr.right;
                }
            }
        }
        int t = x.val;
        x.val = y.val;
        y.val = t;
    }
}
