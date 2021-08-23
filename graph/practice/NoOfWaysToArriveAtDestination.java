package graph.practice;

import java.util.*;

public class NoOfWaysToArriveAtDestination {

    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i=0; i<n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i=0; i<roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        int[] ways = new int[n];
        // there is only one way to reach a vertex from itself
        ways[0] = 1;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new DistanceComparator());
        minHeap.offer(new int[]{0, 0});

        int mod = 1000000007;

        while (!minHeap.isEmpty()) {
            int[] path = minHeap.poll();
            int u = path[0];
            int d = path[1];
            if (!visited[u]) {
                visited[u] = true;
                List<int[]> neighbors = graph.get(u);
                for (int[] p : neighbors) {
                    int v = p[0];
                    int w = p[1];
                    if (!visited[v] && dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                        ways[v] = ways[u];
                        minHeap.offer(new int[]{v, dist[v]});
                    } else if (!visited[v] && dist[u] + w == dist[v]) {
                        ways[v] = (ways[v] + ways[u]) % mod;
                    }
                }
            }
        }
        return ways[n-1];
    }

    static class DistanceComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if (a[1] == b[1]) {
                return 0;
            }
            return a[1] < b[1] ? -1 : 1;
        }
    }
}
