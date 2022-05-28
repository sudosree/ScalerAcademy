package heap.practice;

import java.util.*;

public class TopKFrequentWordsNew {

    private static Map<String, Integer> freq = new HashMap<>();

    private static List<String> topKFrequentWords(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> minHeap = new PriorityQueue<>(new MyComparator());
        for (String word : freq.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        while (k > 0) {
            ans.add(0, minHeap.poll());
            k--;
        }
        return ans;
    }

    static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            if (freq.get(a) == freq.get(b)) {
                return b.compareTo(a);
            }
            return freq.get(a) < freq.get(b) ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        System.out.println(topKFrequentWords(words, k));
    }
}
