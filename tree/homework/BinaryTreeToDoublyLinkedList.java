package tree.homework;

import tree.TreeNode;

import java.util.Stack;

public class BinaryTreeToDoublyLinkedList {

    /**
     * TC = O(n), SC = O(n)
     * @param root
     * @return
     */
    public TreeNode solve (TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode first = null, last = null, curr = root;

        while (!stack.empty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (first == null) {
                    first = curr;
                }
                if (last != null) {
                    last.right = curr;
                    curr.left = last;
                }
                last = curr;
                curr = curr.right;
            }
        }
        last.right = first;
        first.left = last;
        return first;
    }

    /**
     * TC = O(n), SC = O(n) (recursive stack space)
     * @param root
     * @return
     */
    TreeNode solve1(TreeNode root) {
        return binaryTreeToDLL(root);
    }

    TreeNode binaryTreeToDLL(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftList = binaryTreeToDLL(root.left);
        TreeNode rightList = binaryTreeToDLL(root.right);

        // point the left and right pointers of root to point to itself
        root.left = root.right = root;

        return concatenate(concatenate(leftList, root), rightList);
    }

    TreeNode concatenate(TreeNode leftList, TreeNode rightList) {
        if (leftList == null) {
            return rightList;
        }
        if (rightList == null) {
            return leftList;
        }
        TreeNode leftLast = leftList.left;  // last node of the left circular DLL
        TreeNode rightLast = rightList.left; // last node of the right circular DLL

        if (leftLast != null) {
            leftLast.right = rightList; // next ptr of last node of left circular DLL should point to the first node of the right circular DLL
        }
        rightList.left = leftLast;  // prev ptr of first node of right circular DLL should point to the last node of the left circular DLL

        if (rightLast != null) {
            rightLast.right = leftList;
        }
        leftList.left = rightLast;
        return leftList;
    }
}
