package sorting.assignment;

/**
 * Problem Description
 *
 * Given an integer array A of size N.
 *
 * You need to sort the elements in increasing order using SelectionSort. Return a array containing the min value's index position before every iteration.
 *
 * NOTE:
 *
 * Consider 0 based indexing while looking for min value in each step of selection sort.
 * There will be total N - 1 iterations in selection sort so the output array will contain N - 1 integers.
 *
 *
 * Problem Constraints
 *
 * 2 <= N <= 104
 *
 * 1 <= A[i] <= 106
 *
 * All elements are distinct in array A.
 *
 *
 *
 * Input Format
 *
 * First and only argument is an integer array A.
 *
 *
 * Output Format
 *
 * Return an integer array containing N - 1 integers denoting min value's index position before every iteration.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [6, 4, 3, 7, 2, 8]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [4, 2, 2, 4, 4]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Explanation : 6 4 3 7 2 8 : Index of 1st min - 4
 *  After 1st Iteration : 2 4 3 7 6 8 : Index of 2nd min - 2
 *  After 2nd Iteration : 2 3 4 7 6 8 : Index of 3rd min - 2
 *  After 3rd Iteration : 2 3 4 7 6 8 : Index of 4th min - 4
 *  After 4th iteration : 2 3 4 6 7 8 : Index of 5th min - 4
 *  After 5th iteration. : 2 3 4 6 7 8.
 */
public class StepwiseSelectionSort
{
    /**
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     */
    private static int[] solve(int[] A) {
        int[] min = new int[A.length-1];
        for (int i=0,k=0; i<A.length && k<min.length; i++,k++) {
            int smallest = A[i], smallestIndex = i;
            for (int j=i+1;j<A.length;j++) {
                if (A[j] < smallest) {
                    smallest = A[j];
                    smallestIndex = j;
                }
            }
            min[k] = smallestIndex;
            if (smallestIndex != i) {
                int temp = A[i];
                A[i] = smallest;
                A[smallestIndex] = temp;
            }
        }
        return min;
    }

    public static void main(String[] args)
    {
        int[] A = {2,1,4,3,2};
        int[] ans = solve(A);
        for (int i=0;i<ans.length;i++) {
            System.out.println(ans[i]);
        }
    }
}
