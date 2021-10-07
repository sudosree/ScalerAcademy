package graph.practice;

/**
 * Using Path Compression and Union By Rank
 */
public class UnionFindPathOptimised {

    static class UnionFind {
        private int[] parent;
        // height of the tree
        private int[] rank;

        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i=0; i<size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        /**
         * TC = O(logn)
         * find the root node of a vertex
         * @param x
         * @return
         */
        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }

        /**
         * TC = O(logn)
         * @param x
         * @param y
         */
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[x] > rank[y]) {
                    parent[rootY] = rootX;
                } else if (rank[y] > rank[x]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }

        /**
         * TC = O(logn)
         * @param x
         * @param y
         * @return
         */
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}
