package segmenttree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeMinimumQuery {

    // segment tree
    private static int[] tree;

    public static int[] solve(int[] A, int[][] B) {
        List<Integer> ans = new ArrayList<>();

        initializeTree(A.length);
        buildSegTree(A, 0, 0, A.length-1);
        for (int i=0;i<B.length;i++) {
            // min query
            if (B[i][0] == 1) {
                int min = minQuerySegTree(0, 0, A.length-1, B[i][1]-1, B[i][2]-1);
                ans.add(min);
            }
            // update query
            else {
                updateSegTree(0, 0, A.length-1, B[i][1]-1, B[i][2]);
            }
        }

        int[] res = new int[ans.size()];
        for (int i=0;i<ans.size();i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private static void initializeTree(int n) {
        // height of the tree
        int h = (int)Math.ceil(Math.log(n) / Math.log(2));
        // max no. of nodes
        int max = 2 * (int)Math.pow(2, h) - 1;
        tree = new int[max];
    }

    /**
     * TC = O(n)
     * @param A
     * @param treeIndex
     * @param low
     * @param high
     */
    private static void buildSegTree(int[] A, int treeIndex, int low, int high) {
        // leaf node
        if (low == high) {
            tree[treeIndex] = A[low];
            return;
        }
        int mid = low + (high-low)/2;
        // build left subtree
        buildSegTree(A, 2*treeIndex+1, low, mid);
        // build right subtree
        buildSegTree(A, 2*treeIndex+2, mid+1, high);
        // get the minimum of left and right child and store it in the parent node
        tree[treeIndex] = Math.min(tree[2*treeIndex+1], tree[2*treeIndex+2]);
    }

    /**
     * TC = O(logn)
     * @param treeIndex
     * @param low
     * @param high
     * @param x
     * @param y
     * @return
     */
    private static int minQuerySegTree(int treeIndex, int low, int high, int x, int y) {
        // range [x..y] goes outside the range
        if (x > high || y < low) {
            return 0;
        }
        // range [x..y] is completely inside the range [low..high]
        if (x <= low && y >= high) {
            return tree[treeIndex];
        }
        int mid = low + (high-low)/2;
        // range [x..y] lies completely on the left side
        if (y <= mid) {
            return minQuerySegTree(2*treeIndex+1, low, mid, x, y);
        }
        // range [x..y] lies completely on the right side
        if (x > mid) {
            return minQuerySegTree(2*treeIndex+2, mid+1, high, x, y);
        }
        int leftMin = minQuerySegTree(2*treeIndex+1, low, mid, x, mid);
        int rightMin = minQuerySegTree(2*treeIndex+2, mid+1, high, mid+1, y);
        return Math.min(leftMin, rightMin);
    }

    /**
     * TC = O(logn)
     * @param treeIndex
     * @param low
     * @param high
     * @param index
     * @param num
     */
    private static void updateSegTree(int treeIndex, int low, int high, int index, int num) {
        // leaf node
        if (low == high) {
            tree[treeIndex] = num;
            return;
        }
        int mid = low + (high-low)/2;
        // go to the left subtree
        if (index <= mid) {
            updateSegTree(2*treeIndex+1, low, mid, index, num);
        }
        // go to the right subtree
        else {
            updateSegTree(2*treeIndex+2, mid+1, high, index, num);
        }
        // update the min value of the parent node
        tree[treeIndex] = Math.min(tree[2*treeIndex+1], tree[2*treeIndex+2]);
    }

    public static void main(String[] args) {
        int[] A = {1,4,1};
        int[][] B = {
                {1, 1, 3},
                {0, 1, 5},
                {1, 1, 2}
        };
        System.out.println(Arrays.toString(solve(A, B)));
    }
}
