package problemsolving.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemsInContainers {

    private static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        List<Integer> ans = new ArrayList<>();
        int n = startIndices.size();
        for (int i=0;i<n;i++) {
            int start = startIndices.get(i);
            int end = endIndices.get(i);
            String str = s.substring(start-1, end);
            int open = -1, close = -1;
            int count = 0;
            for (int j=0;j<str.length();j++) {
                // first compartment
                if (str.charAt(j) == '|' && open == -1) {
                    open = j;
                } else if (str.charAt(j) == '|') {
                    close = j;
                    count += (close - open - 1);
                    open = j;
                }
            }
            ans.add(count);
        }
        return ans;
    }

    /**
     * TC = O(n + k) = O(n)
     * SC = O(n)
     * @param s
     * @param startIndices
     * @param endIndices
     * @return
     */
    private static List<Integer> numberOfItems1(String s, List<Integer> startIndices, List<Integer> endIndices) {

        int n = s.length();
        int[] memo = new int[n];

        int left = 0, right = 0;
        int count = 0;
        while (left <= right && right < n) {
            // when you are not finding any compartment
            if (s.charAt(left) != '|') {
                left++;
                right++;
            }
            if ((left == right && s.charAt(left) == '|') || (s.charAt(right) != '|')) {
                memo[right] = count;
                right++;
            } else if (s.charAt(left) == '|' && s.charAt(right) == '|') {
                count += (right-left-1);
                memo[right] = count;
                left = right;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i=0;i<startIndices.size();i++) {
            int start = startIndices.get(i)-1;
            int end = endIndices.get(i)-1;
            ans.add(memo[end] - memo[start]);
        }
        return ans;
    }

    public static void main(String[] args) {
        /*String s = "**|***|**|*|**";
        List<Integer> start = Arrays.asList(1,1,1,3,3,7);
        List<Integer> end = Arrays.asList(8,2,4,10,13,14);*/
        String s = "|**|*|*";
        List<Integer> start = Arrays.asList(1,1);
        List<Integer> end = Arrays.asList(5,6);
        System.out.println(numberOfItems(s, start, end));
        System.out.println(numberOfItems1(s, start, end));
    }
}
