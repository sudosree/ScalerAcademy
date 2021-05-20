package graph.practice;

import java.util.*;

public class KruskalMST {

    private static int[] parent;
    private static int[] size;

    private static void createSet(int A) {
        parent = new int[A+1];
        size = new int[A+1];
        for (int i=1;i<=A;i++) {
            parent[i] = i;
            size[i] = 1;
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
        if (size[u] < size[v]) {
            parent[u] = v;
            size[v] += size[u];
        } else if (size[v] < size[u]) {
            parent[v] = u;
            size[u] += size[v];
        } else {
            parent[u] = v;
            size[v] += size[u];
        }
    }

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

    /**
     * TC = O(ELogE + ELogV) = O(ELogV)
     * @param A
     * @param B
     */
    private static void solve(int A, int[][] B) {
        List<Edge> edges = new ArrayList<>();
        for (int i=0;i<B.length;i++) {
            int u = B[i][0];
            int v = B[i][1];
            int w = B[i][2];
            edges.add(new Edge(u,v,w));
        }
        Collections.sort(edges, new WeightComparator());
        createSet(A);
        List<Edge> result = new ArrayList<>();
        for (Edge e : edges) {
            int src = e.src;
            int dest = e.dest;
            int u = find(src);
            int v = find(dest);
            if (u == v) {
                continue;
            }
            union(u, v);
            result.add(e);
        }

        for (int i=0;i<result.size();i++) {
            System.out.println(result.get(i).src + " - " + result.get(i).dest + ": " + result.get(i).weight);
        }
    }

    public static void main(String[] args) {
        int A = 6;
        int[][] B = {
                {1,2,7},
                {1,6,8},
                {2,3,6},
                {2,6,3},
                {3,6,4},
                {3,4,5},
                {3,5,2},
                {4,5,5},
                {5,6,3}
        };
        solve(A, B);
    }
}
