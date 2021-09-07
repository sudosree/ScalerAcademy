package graph.practice;

import java.util.Arrays;

public class CheapestFlight {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prev = new int[n];
        int[] curr = new int[n];
        Arrays.fill(prev, Integer.MAX_VALUE);
        Arrays.fill(curr, Integer.MAX_VALUE);
        // shortest distance from src to src using at most 0 edge
        prev[src] = 0;

        for (int i=1;i<=k+1;i++) {
            curr[src] = 0;
            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];
                if (prev[u] != Integer.MAX_VALUE && prev[u] + w < curr[v]) {
                    curr[v] = prev[u] + w;
                }
            }
            prev = curr.clone();
        }
        return prev[dst] == Integer.MAX_VALUE ? -1 : prev[dst];
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0,1,1},
                {0,2,5},
                {1,2,1},
                {2,3,1},
        };
        int n = 4, src = 0, dst = 3, k = 1;
        System.out.println(findCheapestPrice(n, graph, src, dst, k));
    }
}
