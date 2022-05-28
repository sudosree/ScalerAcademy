package heap.practice;

import java.util.*;

public class TopKFrequentWords {

    private Map<String, Integer> freq = new HashMap<>();

    /**
     * TC = O(n) + O(n) + O(klogn) = O(klogn)
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        for (int i=0; i<words.length; i++) {
            String word = words[i];
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> maxHeap = new PriorityQueue<>(new MyComparator());
        for (String word : freq.keySet()) {
            maxHeap.offer(word);
        }
        List<String> ans = new ArrayList<>();
        while (k > 0) {
            ans.add(maxHeap.poll());
            k--;
        }
        return ans;
    }

    class MyComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            if (freq.get(a) == freq.get(b)) {
                return a.compareTo(b);
            }
            return freq.get(a) > freq.get(b) ? -1 : 1;
        }
    }

    /**
     * TC = O(n + k + (n-k)logk + klogk) = O(nlogk)
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent1(String[] words, int k) {
        for (int i=0; i<words.length; i++) {
            String word = words[i];
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> minHeap = new PriorityQueue<>(new MyComparator1());
        for (String word : freq.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<String> ans = new ArrayList<>();
        while (k > 0) {
            ans.add(0, minHeap.poll());
            k--;
        }
        return ans;
    }

    class MyComparator1 implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            if (freq.get(a) == freq.get(b)) {
                return b.compareTo(a);
            }
            return freq.get(a) < freq.get(b) ? -1 : 1;
        }
    }
}
