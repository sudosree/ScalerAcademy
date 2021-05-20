package segmenttree;

import java.util.ArrayList;
import java.util.List;

public class RangeSumQuery {

    private static int[] tree;

    private static List<Integer> solve(int[] A, int[][] B) {
        List<Integer> ans = new ArrayList<>();

        // height of segment tree
        int h = (int)Math.ceil(Math.log(A.length) / Math.log(2));
        // max size of segment tree
        int max = 2 * (int)Math.pow(2, h) - 1;
        tree = new int[max];

        constructSegmentTree(A, 0, 0, A.length-1);
        for (int i=0;i<B.length;i++) {
            // sum query
            if (B[i][0] == 1) {
                int sum = sumQuerySegmentTree(0, 0, A.length-1, B[i][1], B[i][2]);
                ans.add(sum);
            } else {
                updateValSegmentTree(0, 0, A.length-1, B[i][1], B[i][2]);
            }
        }
        return ans;
    }

    /**
     * TC = O(n)
     * @param A
     * @param treeIndex
     * @param low
     * @param high
     */
    private static void constructSegmentTree(int[] A, int treeIndex, int low, int high) {
        // leaf node
        if (low == high) {
            tree[treeIndex] = A[low];
            return;
        }
        int mid = low + (high - low)/2;
        // construct left tree
        constructSegmentTree(A, 2*treeIndex+1, low, mid);
        // construct right tree
        constructSegmentTree(A, 2*treeIndex+2, mid+1, high);
        // sum up the result of left and right child and store it in parent node
        tree[treeIndex] = tree[2*treeIndex+1] + tree[2*treeIndex+2];
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
    private static int sumQuerySegmentTree(int treeIndex, int low, int high, int x, int y) {
        // check if the range [x..y] is outside the range [low..high] or not
        if (y < low || x > high) {
            return 0;
        }
        // check if the range [x..y] is completely inside the range [low..high]
        if (x <= low && y >= high) {
            return tree[treeIndex];
        }
        // the range [x..y] is smaller than the range [low..high]
        int mid = low + (high-low)/2;
        // the range [x..y] lies completely on the left side
        if (y <= mid) {
            return sumQuerySegmentTree(2*treeIndex+1, low, mid, x, y);
        }
        // the range [x..y] lies completely on the right side
        if (x > mid) {
            return sumQuerySegmentTree(2*treeIndex+2, mid+1, high, x, y);
        }
        int leftSum = sumQuerySegmentTree(2*treeIndex+1, low, mid, x, mid);
        int rightSum = sumQuerySegmentTree(2*treeIndex+2, mid+1, high, mid+1, y);
        return leftSum + rightSum;
    }

    /**
     * TC = O(logn)
     * @param treeIndex
     * @param low
     * @param high
     * @param index
     * @param num
     */
    private static void updateValSegmentTree(int treeIndex, int low, int high, int index, int num) {
        // leaf node
        if (low == high) {
            tree[treeIndex] = num;
            return;
        }
        int mid = low + (high - low)/2;
        // go to the left subtree
        if (index <= mid) {
            updateValSegmentTree(2*treeIndex+1, low, mid, index, num);
        }
        // go to the right subtree
        else {
            updateValSegmentTree(2*treeIndex+2, mid+1, high, index, num);
        }
        // update the parent sum
        tree[treeIndex] = tree[2*treeIndex+1] + tree[2*treeIndex+2];
    }

    public static void main(String[] args) {
        int[] A = {1,10,8,7,6,3,2};
        int[][] B = {
                {1,0,3},
                {1,1,4},
                {1,3,6},
                {0,3,5},
                {1,2,4}
        };
        System.out.println(solve(A,B));
    }
}
