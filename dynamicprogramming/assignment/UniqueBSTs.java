package dynamicprogramming.assignment;

public class UniqueBSTs {

    /**
     * TC = O(n^2), SC = O(n)
     */
    public int numTrees(int A) {
        int[] G = new int[A+1];
        // no. of unique BSTs that can be formed using 0 and 1 nodes
        G[0] = 1;
        G[1] = 1;
        for (int i=2;i<A+1;i++) {
            for (int j=1;j<=i;j++) {
                G[i] += G[j-1] * G[i-j];
            }
        }
        return G[A];
    }
}
