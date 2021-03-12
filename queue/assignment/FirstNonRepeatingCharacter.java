package queue.assignment;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    /**
     * TC = O(n), SC = O(n)
     */
    public String solve(String A) {
        Deque<Character> queue = new LinkedList<>();
        Map<Character, Integer> freq = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<A.length();i++) {
            char c = A.charAt(i);
            freq.put(c, freq.getOrDefault(c,0) + 1);
            if (freq.get(c) == 1) {
                queue.offer(c);
            }
            while (!queue.isEmpty() && freq.get(queue.peek()) > 1) {
                queue.poll();
            }
            if (queue.isEmpty()) {
                sb.append('#');
            } else {
                sb.append(queue.peek());
            }
        }
        return sb.toString();
    }
}
