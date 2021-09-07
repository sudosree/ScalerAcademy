package hashmap.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationOfAInB {

    /**
     * TC = O((lB-lA) * 26)
     * @param A
     * @param B
     * @return
     */
    private static int findPermutation(String A, String B) {
        int lA = A.length(), lB = B.length();
        int[] freq = new int[26];
        for (int i=0;i<lA;i++) {
            freq[A.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<26;i++) {
            sb.append(freq[i]);
        }
        String sA = sb.toString();
        int count = 0;
        Arrays.fill(freq, 0);
        for (int i=0;i<lA;i++) {
            freq[B.charAt(i) - 'a']++;
        }
        sb = new StringBuilder();
        for (int i=0;i<26;i++) {
            sb.append(freq[i]);
        }
        String sB = sb.toString();
        if (sA.equals(sB)) {
            count++;
        }

        for (int i=1;i<lB-lA+1;i++) {
            // reduce the frequency of previous character
            freq[B.charAt(i-1) - 'a']--;
            // increase the frequency of next character
            freq[B.charAt(i+lA-1) - 'a']++;

            // create a string
            sb = new StringBuilder();
            for (int j=0;j<26;j++) {
                sb.append(freq[j]);
            }
            sB = sb.toString();
            if (sA.equals(sB)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String A = "abc";
        String B = "dfbcafecbdbac";
        System.out.println(findPermutation(A, B));

    }
}
