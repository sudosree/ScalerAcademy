package graph.practice;

public class NoOfProvinces {

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSetUnion dsu = new DisjointSetUnion(n);

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (i != j && isConnected[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }

        return dsu.count;
    }

    static class DisjointSetUnion {
        int[] parent;
        int[] height;
        int count = 0;

        DisjointSetUnion(int n) {
            this.count = n;
            parent = new int[n];
            height = new int[n];
            for (int i=0;i<n;i++) {
                parent[i] = i;
                height[i] = 0;
            }
        }

        // using path compression technique
        private int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }

        private void union(int x, int y) {
            int u = find(x);
            int v = find(y);
            // no need to merge it
            if (u == v) {
                return;
            }
            if (height[u] < height[v]) {
                parent[u] = v;
            } else if (height[v] < height[u]) {
                parent[v] = u;
            } else {
                parent[v] = u;
                height[u]++;
            }
            count--;
        }

    }

    private static int findCircleNum1(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        int count = 0;
        for (int i=0;i<n;i++) {
            if (!visited[i]) {
                dfs(i, isConnected, visited);
                count++;
            }
        }
        return count;
    }


    private static void dfs(int u, int[][] isConnected, boolean[] visited) {
        visited[u] = true;
        for (int i=0;i< isConnected.length;i++) {
            if (isConnected[u][i] == 1 && !visited[i]) {
                dfs(i, isConnected, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = {
                {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                {0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},
                {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},
                {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
                {0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}
        };
        System.out.println(findCircleNum(isConnected));
        System.out.println(findCircleNum1(isConnected));
    }
}
