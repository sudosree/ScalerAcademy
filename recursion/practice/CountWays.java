package recursion.practice;

/**
 * Count the no. of ways to reach the nth stair
 */
public class CountWays
{

    /**
     * Top down approach
     * Time complexity - O(2^n)
     * Space complexity - O(1)
     */
    private static int path(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        return path(n-1) + path(n-2);
    }

    /**
     * Bottom up approach (Tabulization approach) - Dynamic Programming
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    private static int path1(int n) {
        int[] path = new int[n+1];
        path[0] = 0;
        path[1] = 1;
        path[2] = 2;
        for (int i=3;i<=n;i++) {
            path[i] = path[i-1] + path[i-2];
        }
        return path[n];
    }

    public static void main(String[] args)
    {
        int n = 4;
        System.out.println(path1(n));
    }
}
