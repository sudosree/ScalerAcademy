package problemsolving.homework;

import java.util.*;

/**
 * Kth Row of Pascal's Triangle
 *
 * Given an index k, return the kth row of the Pascal's triangle.
 *
 * Pascal's triangle : To generate A[C] in row R, sum up A'[C] and A'[C-1] from previous row R - 1.
 *
 * Example:
 *
 * Input : k = 3
 *
 * Return : [1,3,3,1]
 *
 *     NOTE : k is 0 based. k = 0, corresponds to the row [1].
 *
 * Note:Could you optimize your algorithm to use only O(k) extra space?
 */
public class KthRowOfPascalTriangle
{
    public static List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return Arrays.asList(1);
        }
        // get previous row
        List<Integer> prev_row = getRow(rowIndex-1);
        List<Integer> curr_row = new ArrayList<>();
        // first element of every row > 0 is 1
        curr_row.add(1);
        for (int i=1;i<prev_row.size();i++) {
            curr_row.add(prev_row.get(i-1) + prev_row.get(i));
        }
        // last element of every row > 0 is 1
        curr_row.add(1);
        return curr_row;
    }

    public List<Integer> getRow1(int rowIndex) {
        // base case
        if (rowIndex == 0) {
            return Arrays.asList(1);
        }
        List<Integer> prev_row = new ArrayList<>();
        // for the first row i.e. 0th row
        prev_row.add(1);
        for (int i=1;i<=rowIndex;i++) {
            List<Integer> curr_row = new ArrayList<>();
            // first element of every row is 1
            curr_row.add(1);
            for (int j=1;j<i;j++) {
                curr_row.add(prev_row.get(j) + prev_row.get(j-1));
            }
            // last element of every row is 1
            curr_row.add(1);
            prev_row = curr_row;
        }
        return prev_row;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> curr_row = new ArrayList<>();
        curr_row.add(1);
        for (int i=1;i<=rowIndex;i++) {
            int prev = curr_row.get(curr_row.size()-1);
            curr_row.add((int) ((prev * (long) (rowIndex - i + 1)) / i));
        }
        return curr_row;
    }
}
