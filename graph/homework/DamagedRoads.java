package graph.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DamagedRoads {

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

    public static int solve(int[] A, int[] B) {
        int n = A.length + 1, m = B.length + 1;
        List<Edge> edges = new ArrayList<>();

        // consider horizontal lines
        for (int i=1; i<=n*m; i+=m) {
            for (int j=i+1,k=1; j<i+m; j++,k++) {
                int src = j-1;
                int dest = j;
                int weight = B[k-1];
                Edge edge = new Edge(src, dest, weight);
                edges.add(edge);
            }
        }

        // consider vertical lines
        for (int j=1; j<=m; j++) {
            for (int i=j+m,k=1; i<=n*m; i+=m,k++) {
                int src = i-m;
                int dest = i;
                int weight = A[k-1];
                Edge edge = new Edge(src, dest, weight);
                edges.add(edge);
            }
        }

        Collections.sort(edges, new WeightComparator());
        createSet(n*m);
        int cost = 0;
        int mod = 1000000007;
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
            cost = (cost % mod + weight % mod) % mod;
        }
        return cost;
    }

    static class Pair {
        int cost;
        int type;
        Pair(int cost, int type) {
            this.cost = cost;
            this.type = type;
        }
    }

    static class CostComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            return p1.cost - p2.cost;
        }
    }

    /**
     * TC = O((n+m)log(n+m) + (n+m)) = O((n+m)log(n+m))
     * SC = O(n+m)
     * @param A
     * @param B
     * @return
     */
    public static int solve1(int[] A, int[] B) {
        List<Pair> pairs = new ArrayList<>();
        // vertical cost
        for (int i=0;i<A.length;i++) {
            pairs.add(new Pair(A[i], 1));
        }
        // horizontal cost
        for (int i=0;i<B.length;i++) {
            pairs.add(new Pair(B[i], 0));
        }
        Collections.sort(pairs, new CostComparator());
        // rows
        int n = A.length+1;
        // columns
        int m = B.length+1;
        int cost = 0, mod = 1000000007;
        for (Pair pair : pairs) {
            int costType = pair.type;
            // vertical cost
            if (costType == 1) {
                cost = (cost % mod + (m * pair.cost) % mod) % mod;
                n--;
            }
            // horizontal cost
            else {
                cost = (cost % mod + (n * pair.cost) % mod) % mod;
                m--;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3};
        int[] B = {4,5,6};
        System.out.println(solve(A,B));
    }
}
