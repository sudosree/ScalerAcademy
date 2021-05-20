package graph.practice;

public class DisjointSetUnion {

    private static int[] parent;
    private static int[] height;
    private static int[] size;

    private static void createSet(int A) {
        parent = new int[A+1];
        height = new int[A+1];
        size = new int[A+1];
        for (int i=1;i<=A;i++) {
            parent[i] = i;
            height[i] = 0;
            size[i] = 1;
        }
    }

    /**
     * TC = O(H) (in worst case it is O(n))
     * @param x
     * @return
     */
    private static int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    /**
     * TC = O(1) amortized (actual O(n))
     * @param x
     * @return
     */
    private static int find1(int x) {
        if (x == parent[x]) {
            return x;
        }
        parent[x] = find1(parent[x]);
        return parent[x];
    }

    /**
     * TC = O(n)
     * @param x
     * @param y
     * @return
     */
    private static boolean union(int x, int y) {
        int root_x = find(x);
        int root_y = find(y);
        // x and y belongs to the same set, no need to merge
        if (root_x == root_y) {
            return false;
        }
        // x and y belongs to different set
        parent[root_y] = root_x;
        return true;
    }

    /**
     * Union by height
     * TC = O(logn)
     * @param x
     * @param y
     * @return
     */
    private static boolean union1(int x, int y) {
        int u = find(x);
        int v = find(y);
        if (u == v) {
            return false;
        }
        if (height[u] < height[v]) {
            parent[u] = v;
        } else if (height[v] < height[u]) {
            parent[v] = u;
        } else {
            parent[u] = v;
            height[v]++;
        }
        return true;
    }

    /**
     * Union by size
     * TC = O(logn)
     * @param x
     * @param y
     * @return
     */
    private static boolean union2(int x, int y) {
        int u = find(x);
        int v = find(y);
        if (u == v) {
            return false;
        }
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
        return true;
    }

    public static void main(String[] args) {
        int A = 5;
        createSet(A);
        union(1,2);
        union(2,3);
        union(4,5);
        union(3,5);
    }
}
