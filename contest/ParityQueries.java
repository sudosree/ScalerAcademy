package contest;

import java.util.*;

public class ParityQueries {

    public static int[] solve(char[] A, String[] B) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<B.length;i++) {
            String s = B[i];
            int len = s.length();
            for (int j=1;j<=18-len;j++) {
                s = '0' + s;
            }
            char[] ch = s.toCharArray();
            for (int j=s.length()-1;j>=s.length()-len;j--) {
                ch[j] = (char)('0' + (ch[j] - '0') % 2);
            }
            String st = String.valueOf(ch);
            if (A[i] == '+') {
                map.put(st, map.getOrDefault(st, 0) + 1);
            } else if (A[i] == '-') {
                map.put(st, map.get(st) - 1);
            } else {
                if (map.containsKey(st)) {
                    list.add(map.get(st));
                } else {
                    list.add(0);
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i=0;i<ans.length;i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        char[] A = {'+', '+', '?', '+', '-', '?'};
        String[] B = {"1", "241", "1", "361", "241", "101"};
        System.out.println(Arrays.toString(solve(A, B)));
    }
}
