package tree.homework;

public class CheckBSTWithOneChild {

    /**
     * TC = O(n)
     */
    public String solve(int[] A) {
        int min = A[A.length-1], max = A[A.length-1];
        for (int i=A.length-2;i>=0;i--) {
            if (A[i] < min) {
                min = A[i];
            } else if (A[i] > max) {
                max = A[i];
            } else {
                return "NO";
            }
        }
        return "YES";
    }
}
