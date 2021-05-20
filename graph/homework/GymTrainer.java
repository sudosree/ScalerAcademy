package graph.homework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GymTrainer {

    private static int find(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }
        parent[x] = find(parent[x], parent);
        return parent[x];
    }

    private static void union(int x, int y, int[] parent, int[] height) {
        int u = find(x, parent);
        int v = find(y, parent);
        if (u == v) {
            return;
        }
        if (height[u] < height[v]) {
            parent[u] = v;
        } else if (height[v] < height[u]) {
            parent[v] = u;
        } else {
            parent[u] = v;
            height[v]++;
        }
    }

    public static int solve(int A, int[][] B, int[][] C) {
        char[] type = new char[A+1];
        Arrays.fill(type, 'E');

        // walk edge
        for (int i=0;i<B.length;i++) {
            int u = B[i][0];
            int v = B[i][1];
            if (type[u] == 'E') {
                type[u] = 'W';
            }
            if (type[v] == 'E') {
                type[v] = 'W';
            }
        }

        // talk edge
        for (int i=0;i<C.length;i++) {
            int u = C[i][0];
            int v = C[i][1];
            if (type[u] == 'E') {
                type[u] = 'T';
            }
            if (type[v] == 'E') {
                type[v] = 'T';
            }
            if (type[u] != 'E' && type[u] != 'T') {
                return 0;
            }
            if (type[v] != 'E' && type[v] != 'T') {
                return 0;
            }
        }

        int[] parent = new int[A+1];
        int[] height = new int[A+1];

        // create a DSU and find the group of friends
        for (int i=1;i<=A;i++) {
            parent[i] = i;
            height[i] = 0;
        }

        // add friends in DSU who walk together
        for (int i=0;i<B.length;i++) {
            int u = B[i][0];
            int v = B[i][1];
            union(u, v, parent, height);
        }

        // add friends in DSU who talk together
        for (int i=0;i<C.length;i++) {
            int u = C[i][0];
            int v = C[i][1];
            union(u, v, parent, height);
        }

        for (int i=1;i<=A;i++) {
            int x = i;
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            parent[i] = x;
        }

        int mod = 1000000007;
        Set<Integer> set = new HashSet<>();
        for (int i=1;i<=A;i++) {
            set.add(parent[i]);
        }
        int friends = set.size() % mod;
        int count = 1;
        for (int i=1;i<=friends;i++) {
            count = (count % mod * 2 % mod) % mod;
        }
        return count;
    }

    public static void main(String[] args) {
        int A = 20;
        int[][] B = {
                {1,5},
                {4,6},
                {18,3},
                {4,5},
                {15,9},
                {15,4},
        };
        int[][] C = {
                {13,20},
                {7,20},
                {8,19},
                {13,7},
                {13,8},
                {2,19},
        };
        System.out.println(solve(A,B,C));
    }
}
