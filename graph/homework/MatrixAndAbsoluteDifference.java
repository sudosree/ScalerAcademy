package graph.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MatrixAndAbsoluteDifference {

    static class Edge {
        int src;
        int dest;
        int weight;
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class WeightComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    private static int[] parent;
    private static int[] height;

    private static void createSet(int A) {
        parent = new int[A+1];
        height = new int[A+1];
        for (int i=1;i<=A;i++) {
            parent[i] = i;
            height[i] = 0;
        }
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y) {
        int u = find(x);
        int v = find(y);
        if (height[u] < height[v]) {
            parent[u] = v;
        } else if (height[v] < height[u]) {
            parent[v] = u;
        } else {
            parent[u] = v;
            height[v]++;
        }
    }

    public static int solve(int A, int B, int[][] C) {
        List<Edge> edges = new ArrayList<>();

        // consider horizontal lines
        for (int i=0,s=1; i<A && s<=A*B; i++,s+=B) {
            for (int j=1,d=s+1; j<B; j++,d++) {
                int src = d-1;
                int dest = d;
                int weight = Math.abs(C[i][j-1] - C[i][j]);
                Edge edge = new Edge(src, dest, weight);
                edges.add(edge);
            }
        }

        // consider vertical lines
        for (int j=0,s=1; j<B; j++,s++) {
            for (int i=1,d=s+B; i<A && d<=A*B; i++,d+=B) {
                int src = d-B;
                int dest = d;
                int weight = Math.abs(C[i-1][j] - C[i][j]);
                Edge edge = new Edge(src, dest, weight);
                edges.add(edge);
            }
        }
        Collections.sort(edges, new WeightComparator());
        createSet(A*B);
        int K = Integer.MIN_VALUE;
        for (Edge e : edges) {
            int src = e.src;
            int dest = e.dest;
            int weight = e.weight;
            int u = find(src);
            int v = find(dest);
            if (u == v) {
                continue;
            }
            union(u, v);
            K = Math.max(K, weight);
        }
        return K;
    }

    public static void main(String[] args) {
        int A = 3, B = 2;
        int[][] C = {
                {1,5},
                {10,7},
                {3,6},
        };
        System.out.println(solve(A,B,C));
    }
}
