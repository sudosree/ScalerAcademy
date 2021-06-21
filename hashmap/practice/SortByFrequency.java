package hashmap.practice;

import java.util.*;

public class SortByFrequency {

    static class Pair {
        int idx;
        int count;

        Pair(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }
    }

    /**
     * TC = O(n + mlogm)
     * @param A
     * @return
     */
    private static List<Integer> sortByFrequency(int[] A) {
        Map<Integer, Pair> map = new HashMap<>();
        for (int i=0;i<A.length;i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], new Pair(i, 1));
            } else {
                Pair p = map.get(A[i]);
                p.count = p.count + 1;
                map.put(A[i], p);
            }
        }
        // create a list from elements of hash map
        List<Map.Entry<Integer, Pair>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new MyComparator());
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Pair> entry : list) {
            int freq = entry.getValue().count;
            int key = entry.getKey();
            while (freq > 0) {
                ans.add(key);
                freq--;
            }
        }
        return ans;
    }

    static class MyComparator implements Comparator<Map.Entry<Integer, Pair>> {
        @Override
        public int compare(Map.Entry<Integer, Pair> o1, Map.Entry<Integer, Pair> o2) {
            if (o1.getValue().count == o2.getValue().count) {
                return o1.getValue().idx < o2.getValue().idx ? -1 : 1;
            }
            return o2.getValue().count < o1.getValue().count ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        int[] A = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
        System.out.println(sortByFrequency(A));
    }
}
