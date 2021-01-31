package problemsolving.homework;

import java.util.*;

/**
 * Find duplicate rows in a binary matrix
 *
 * Given a binary matrix A of integers 0 and 1, of size N x M.
 *
 * Find and return the indices of the rows which are duplicate of rows which are already present in the matrix.
 *
 * If row[i] and row[j] are same and i < j then answer will contain only index j.
 *
 * Note: Rows are numbered from top to bottom and columns are numbered from left to right. There will be at least one duplicate row in the matrix.
 *
 *
 * Input Format
 *
 * The first argument given is the integer matrix A.
 *
 * Output Format
 *
 * Return the indices of the rows in the form of an integer array.
 *
 * Constraints
 *
 * 2 <= N, M <= 1000
 * 0 <= A[i] <= 1
 *
 * For Example
 *
 * Input 1:
 *     A = [   [1, 0, 0]
 *             [0, 1, 0]
 *             [0, 1, 0]   ]
 * Output 1:
 *     [3]
 *
 * Input 2:
 *     A = [   [1, 1, 1, 0]
 *             [0, 0, 0, 1]
 *             [1, 1, 1, 0]
 *             [0, 0, 0, 1]    ]
 * Output 2:
 *     [3, 4]
 */
public class FindDuplicateRows
{
    public static int[] solve(int[][] A) {
        int n = A.length, m = A[0].length;
        Map<Integer, Boolean> dup = new TreeMap<>();
        // for every row check if it is the same as any other row
        for (int i=0;i<n-1;i++) {
            if (!dup.containsKey(i+1)) {
                for (int j=i+1;j<n;j++) {
                    if (!dup.containsKey(j+1)) {
                        boolean same = true;
                        for (int k=0;k<m;k++) {
                            if (A[i][k] != A[j][k]) {
                                same = false;
                                break;
                            }
                        }
                        if (same) {
                            dup.put(j+1, false);
                        }
                    }
                }
            }

        }
        int[] ans = new int[dup.size()];
        int i=0;
        for (int num : dup.keySet()) {
            ans[i++] = num;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[][] A = {
                {1, 1, 1, 0},
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {1, 1, 1, 0}
        };
        System.out.println(Arrays.toString(solve(A)));
    }
}
