package dynamicprogramming.assignment;

public class Party {

    int mod = 10003;

    public int solve(int A) {
        return waysToParty(A);
    }

    /**
     * TC = O(2^n), SC = O(2^n)
     * @param n
     * @return
     */
    private int waysToParty(int n) {
        if (n <= 2) {
            return n;
        }
        return (waysToParty(n-1) + (waysToParty(n-2) * (n-1)) % mod) % mod;
    }

    int[] ways;

    public int solve1(int A) {
        ways = new int[A+1];
        return waysToParty1(A);
    }

    /**
     * TC = O(n), SC = O(n)
     * @param n
     * @return
     */
    private int waysToParty1(int n) {
        if (n <= 2) {
            return n;
        }
        if (ways[n] > 0) {
            return ways[n];
        }
        ways[n] = (waysToParty1(n-1) + (waysToParty1(n-2) * (n-1)) % mod) % mod;
        return ways[n];
    }

    /**
     * TC = O(n), SC = O(n)
     */
    public int solve2(int A) {
        if (A <= 2) {
            return A;
        }
        int mod = 10003;
        int[] ways = new int[A+1];
        ways[1] = 1;
        ways[2] = 2;
        for (int i=3;i<A+1;i++) {
            ways[i] = (ways[i-1] + (ways[i-2] * (i-1)) % mod) % mod;
        }
        return ways[A];
    }
}
