package problemsolving.assignment;

public class SumAllPossibleSubmatrices
{

    /**
     * TC = O(n^6)
     */
    public int solve(int[][] A) {
        int n = A.length;
        int sum = 0;
        // find all the possible top left corners
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                // find all the possible bottom right corners
                for (int p=i;p<n;p++) {
                    for (int q=j;q<n;q++) {
                        // find the sum of the submatrix comprising of top left and bottom right corners
                        for (int x=i;x<=p;x++) {
                            for (int y=j;y<=q;y++) {
                                sum += A[x][y];
                            }
                        }
                    }
                }
            }
        }
        return sum;
    }

    /**
     * TC = O(n^2) + O(n^2) + O(n^4) = O(n^4)
     */
    public static int solve1(int[][] A) {
        int n = A.length;
        int sum = 0;

        // find the prefix row sum
        for (int i=0;i<n;i++) {
            int row_sum = 0;
            for (int j=0;j<n;j++) {
                row_sum += A[i][j];
                A[i][j] = row_sum;
            }
        }

        // find the prefix column sum
        for (int i=0;i<n;i++) {
            int col_sum = 0;
            for (int j=0;j<n;j++) {
                col_sum += A[j][i];
                A[j][i] = col_sum;
            }
        }

        // find all the possible top left corners
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                // find all the possible bottom right corners
                for (int p=i;p<n;p++) {
                    for (int q=j;q<n;q++) {
                        // find the sum of the submatrix comprising of top left and bottom right corners
                        sum += A[p][q];
                        if (i > 0) {
                            sum -= A[i-1][q];
                        }
                        if (j > 0) {
                            sum -= A[p][j-1];
                        }
                        if (i > 0 && j > 0) {
                            sum += A[i-1][j-1];
                        }
                    }
                }
            }
        }
        return sum;
    }

    /**
     * TC = O(n^2)
     */
    public int solve2(int[][] A) {
        int n = A.length;
        int sum = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                // no. of ways by which we can choose the top_left corners
                int top_left = (i+1) * (j+1);
                // no. of ways by which we can choose the bottom_right corners
                int bottom_right = (n-i) * (n-j);
                // no. of submatrices in which A[i][j] will lie
                int total = top_left * bottom_right;
                sum += total * A[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args)
    {
        int[][] A = {
                {1,1},
                {1,1}
        };
        System.out.println(solve1(A));
    }
}
