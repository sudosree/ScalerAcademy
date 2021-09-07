package graph.practice;

import java.util.*;

public class DijkstraDirected {

    private static void dijkstra(int n, int[][] nums, int src) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            int u = nums[i][0];
            int v = nums[i][1];
            int w = nums[i][2];
            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList<>());
            }
            graph.get(u).add(new int[]{v,w});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new DistanceComparator());
        pq.offer(new int[]{src, 0});
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0];
            // if already visited
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            if (!graph.containsKey(u)) {
                continue;
            }
            List<int[]> neighbors = graph.get(u);
            for (int[] ne : neighbors) {
                int v = ne[0];
                int w = ne[1];
                if (!visited[v] && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        for (int i=0;i<n;i++) {
            System.out.println(src + " - " + i + ": " + dist[i]);
        }
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

    public static void main(String[] args) {
        int[][] nums = {
                {0,1,5},
                {0,2,2},
                {1,2,-10}
        };
        int src = 0;
        int n = 3;
        dijkstra(n, nums, src);
    }
}
