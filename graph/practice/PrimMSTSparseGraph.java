package graph.practice;

import java.util.*;

public class PrimMSTSparseGraph {

    static class Pair {
        int vertex;
        int weight;
        Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static class Node {
        int vertex;
        int key;
        Node(int vertex, int key) {
            this.vertex = vertex;
            this.key = key;
        }
    }

    static class KeyComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.key == o2.key) {
                return 0;
            }
            return o1.key < o2.key ? -1 : 1;
        }
    }

    /**
     * TC = O(ELogE + V), SC = O(V+E)
     * @param A
     * @param B
     */
    private static void solve(int A, int[][] B) {
        Map<Integer, Set<Pair>> graph = new HashMap<>();
        for (int i=1;i<=A;i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i=0;i<B.length;i++) {
            int u = B[i][0];
            int v = B[i][1];
            int w = B[i][2];
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }
        // keep track of vertices which are part of MST
        boolean[] mst = new boolean[A+1];
        int[] key = new int[A+1];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[1] = 0;
        int[] parent = new int[A+1];
        parent[1] = -1;
        // will store the vertices which are not part of MST
        PriorityQueue<Node> heap = new PriorityQueue<>(new KeyComparator());
        heap.offer(new Node(1, 0));

        while (!heap.isEmpty()) {
            Node node = heap.poll();
            int u = node.vertex;
            if (!mst[u]) {
                mst[u] = true;
                Set<Pair> neighbors = graph.get(u);
                for (Pair p : neighbors) {
                    int v = p.vertex;
                    int w = p.weight;
                    if (!mst[v] && w < key[v]) {
                        key[v] = w;
                        parent[v] = u;
                        heap.offer(new Node(v, key[v]));
                    }
                }
            }
        }

        for (int i=2;i<=A;i++) {
            System.out.println(parent[i] + " - " + i + ": " + key[i]);
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
