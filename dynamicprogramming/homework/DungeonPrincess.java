package dynamicprogramming.homework;

import java.util.Arrays;

public class DungeonPrincess {

    private int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        return calculateMinimumHPHelper(dungeon, 0, 0, n, m);
    }

    private int calculateMinimumHPHelper(int[][] dungeon, int i, int j, int n, int m) {
        // base case, out of bound cases, minimum health will be infinity
        if (i == n || j == m) {
            return Integer.MAX_VALUE;
        }
        // when reached the destination, return the minimum health
        if (i == n-1 && j == m-1) {
            return dungeon[i][j] <= 0 ? 1 - dungeon[i][j] : 1;
        }

        // find the minimum health from right and down cell
        int minHealthRight = calculateMinimumHPHelper(dungeon, i, j+1, n, m);
        int minHealthDown = calculateMinimumHPHelper(dungeon, i+1, j, n, m);

        // find the minimum health of the current cell
        int minHealth = Math.min(minHealthRight, minHealthDown) - dungeon[i][j];
        return minHealth <= 0 ? 1 : minHealth;
    }

    private int[][] health;

    private int calculateMinimumHPMemo(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        health = new int[n][m];
        for (int i=0;i<n;i++) {
            Arrays.fill(health[i], -1);
        }
        return calculateMinimumHPMemoHelper(dungeon, 0, 0, n, m);
    }

    private int calculateMinimumHPMemoHelper(int[][] dungeon, int i, int j, int n, int m) {
        if (i == n || j == m) {
            return Integer.MAX_VALUE;
        }
        if (i == n-1 && j == m-1) {
            return dungeon[i][j] <= 0 ? 1 - dungeon[i][j] : 1;
        }
        if (health[i][j] != -1) {
            return health[i][j];
        }
        // find the minimum health from right and down cell
        int minHealthRight = calculateMinimumHPMemoHelper(dungeon, i, j+1, n, m);
        int minHealthDown = calculateMinimumHPMemoHelper(dungeon, i+1, j, n, m);

        // find the minimum health of the current cell
        int minHealth = Math.min(minHealthRight, minHealthDown) - dungeon[i][j];
        health[i][j] = minHealth <= 0 ? 1 : minHealth;
        return health[i][j];
    }

    /**
     * TC = O(n*m), SC = O(n*m)
     */
    public int calculateMinimumHPDP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] health = new int[n+1][m+1];
        for (int i=0;i<n+1;i++) {
            Arrays.fill(health[i], Integer.MAX_VALUE);
        }
        // base case
        health[n][m-1] = 1;
        health[n-1][m] = 1;

        for (int i=n-1; i>=0; i--) {
            for (int j=m-1; j>=0; j--) {
                int minHealthRight = health[i][j+1];
                int minHealthDown = health[i+1][j];
                int minHealth = Math.min(minHealthRight, minHealthDown) - dungeon[i][j];
                health[i][j] = minHealth <= 0 ? 1 : minHealth;
            }
        }
        return health[0][0];
    }
}
