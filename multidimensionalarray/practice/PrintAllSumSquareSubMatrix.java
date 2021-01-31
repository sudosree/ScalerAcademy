package multidimensionalarray.practice;

/**
 * Given an n x n square matrix, find sum of all sub-squares of size k x k
 */
public class PrintAllSumSquareSubMatrix
{

    /**
     * TC = O(n^2k^2)
     */
    private static void solve(int[][] A, int k) {
        int n = A.length;
        for (int i=0;i<n-k+1;i++) {
            for (int j=0;j<n-k+1;j++) {
                int sum = 0;
                for (int p=i;p<i+k;p++) {
                    for (int q=j;q<j+k;q++) {
                        sum += A[p][q];
                    }
                }
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }

    private static void solve1(int[][] A, int k) {
        
    }

    public static void main(String[] args)
    {
        int[][] A = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        solve(A,2);
    }
}
