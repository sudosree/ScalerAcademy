package dynamicprogramming.assignment;

import java.util.*;

public class ValuableNodes {

    public static int solve(int[] A, int[] B) {

        // create a parent array such that p[i] is the parent of i
        int[] p = new int[A.length+1];
        for (int i=0;i<A.length;i++) {
            p[i+1] = A[i];
        }
        // create children list
        Map<Integer, List<Integer>> children = new HashMap<>();
        for (int i=1;i<A.length+1;i++) {
            if (!children.containsKey(p[i])) {
                children.put(p[i], new ArrayList<>());
            }
            children.get(p[i]).add(i);
        }

        // create great grandchildren list
        Map<Integer, List<Integer>> greatGrandChildren = new HashMap<>();
        for (int i=1;i<A.length+1;i++) {
            if (!greatGrandChildren.containsKey(p[p[p[i]]])) {
                greatGrandChildren.put(p[p[p[i]]], new ArrayList<>());
            }
            greatGrandChildren.get(p[p[p[i]]]).add(i);
        }
        int[] dp = new int[A.length+1];
        Arrays.fill(dp, -1);
        return findMaxSum(1, B, dp, children, greatGrandChildren, 1000000007);
    }

    private static int findMaxSum(int root, int[] B, int[] dp, Map<Integer, List<Integer>> childMap, Map<Integer, List<Integer>> ggChildMap, int mod) {
        if (dp[root] != -1) {
            return dp[root];
        }
        // when the root is not selected, you can select all it children
        int notSelect = 0;
        List<Integer> children = new ArrayList<>();
        if (childMap.containsKey(root)) {
            children = childMap.get(root);
        }
        for (int c : children) {
            notSelect = (notSelect + findMaxSum(c, B, dp, childMap, ggChildMap, mod)) % mod;
        }

        // when the root is selected, you can select all its great-grandchildren
        // but you cannot select its children and grandchildren
        int select = B[root-1];
        List<Integer> ggchildren = new ArrayList<>();
        if (ggChildMap.containsKey(root)) {
            ggchildren = ggChildMap.get(root);
        }
        for (int ggc : ggchildren) {
            select = (select + findMaxSum(ggc, B, dp, childMap, ggChildMap, mod)) % mod;
        }
        dp[root] = Math.max(notSelect, select);
        return dp[root];
    }

    public static void main(String[] args) {
        int[] A = {0, 1, 1, 1, 3, 3, 6, 6};
        int[] B = {100, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(solve(A, B));
    }
}
