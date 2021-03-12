package queue.assignment;

import java.util.Deque;
import java.util.LinkedList;

public class PerfectNumber {

    /**
     * TC = O(n), SC = O(n)
     */
    public static String solve(int A) {
        Deque<String> queue = new LinkedList<>();
        queue.offer("1");
        queue.offer("2");
        int count = 0;
        String s = "";
        while (count != A) {
            s = queue.poll();
            queue.offer(s + "1");
            queue.offer(s + "2");
            count++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++) {
            sb.append(s.charAt(i));
        }
        for (int i=s.length()-1;i>=0;i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solve(4));
    }
}
