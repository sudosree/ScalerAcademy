package heap.assignment;

public class WaysToFormMaxHeap {

    private static int mod = 1000000007;

    public static int solve(int A) {
        long[][] pascal = getPascalTree(A);
        return (int)getNumberOfMaxHeaps(A, pascal);
    }

    private static long getNumberOfMaxHeaps(int N, long[][] pascal) {
        if (N <= 1) {
            return 1;
        }
        int left = getNoOfLeftNodes(N);
        return ((pascal[N-1][left] * getNumberOfMaxHeaps(left, pascal)) % mod * getNumberOfMaxHeaps(N-left-1, pascal)) % mod;
    }

    private static int getNoOfLeftNodes(int N) {
        // height of a complete binary tree
        double res = Math.log(N)/Math.log(2);
        int h = (int)Math.floor(res);
        // max no. of nodes at the last level
        int maxNodes = (int)Math.pow(2,h);
        // no. of nodes in the left side in between the first and the last level
        int left = (maxNodes - 2)/2;
        // no. of nodes that are actually present at the last level
        int actualNodesAtLastLevel = N - (maxNodes - 1);
        // no. of nodes in the left side at the last level
        int leftLastLevel = maxNodes/2;

        if (actualNodesAtLastLevel > leftLastLevel) {
            left += leftLastLevel;
        } else {
            left += actualNodesAtLastLevel;
        }
        return left;
    }

    private static long[][] getPascalTree(int N) {
        long[][] pascal = new long[N+1][N+1];
        for (int n=0;n<=N;n++) {
            for (int r=0;r<=n;r++) {
                if (n == r || r == 0) {
                    pascal[n][r] = 1;
                } else {
                    pascal[n][r] = (pascal[n-1][r-1] + pascal[n-1][r]) % mod;
                }
            }
        }
        return pascal;
    }

    public static void main(String[] args) {
        int A = 10;
        System.out.println(solve(A));
    }
}
