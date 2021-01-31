package problemsolving.practice;

public class EquilibriumIndex
{

    /**
     * TC = O(n), SC = O(1)
     */
    private static int solve(int[] A) {
        int left_sum = 0, right_sum = 0;
        for (int i=0;i<A.length;i++) {
            right_sum += A[i];
        }
        for (int i=0;i<A.length;i++) {
            right_sum -= A[i];
            if (right_sum == left_sum) {
                return i;
            }
            left_sum += A[i];
        }
        return -1;
    }

    /**
     * TC = O(n), SC = O(n)
     */
    private static int solve1(int[] A) {
        int[] prefix_sum = new int[A.length];
        prefix_sum[0] = A[0];
        for (int i=1;i<A.length;i++) {
            prefix_sum[i] = prefix_sum[i-1] + A[i];
        }
        // if the first index is an equilibrium index
        if (prefix_sum[A.length-1] - prefix_sum[0] == 0) {
            return 0;
        }
        for (int i=1;i<A.length-1;i++) {
            if (prefix_sum[i-1] == prefix_sum[A.length-1]-prefix_sum[i]) {
                return i;
            }
        }
        // if the last index is an equilibrium index
        if (prefix_sum[A.length-2] == 0) {
            return A.length-1;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] A = {-7,1,5,2,-4,3,0};
        System.out.println(solve1(A));
    }
}
