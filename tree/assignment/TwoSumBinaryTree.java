package tree.assignment;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSumBinaryTree {

    public int t2Sum(TreeNode A, int B) {
        List<Integer> list = new ArrayList<>();
        inorder(A, list);
        int l = 0, r = list.size()-1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == B) {
                return 1;
            }
            if (sum < B) {
                l++;
            } else {
                r--;
            }
        }
        return 0;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public int t2Sum1(TreeNode A, int B) {
        Set<Integer> set = new HashSet<>();
        return t2SumHelper(A, B, set) ? 1 : 0;
    }

    private boolean t2SumHelper(TreeNode root, int B, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(B - root.val)) {
            return true;
        }
        set.add(root.val);
        return t2SumHelper(root.left, B, set) || t2SumHelper(root.right, B, set);
    }
}
