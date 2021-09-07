package hashmap.practice;

public class PermutationInString {

    /**
     * TC = O(l1 + (26 + l1) * (l2 - l1))
     * SC = O(1)
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 > l2) {
            return false;
        }
        // store the frequency of all the characters of s1 in freq1
        int[] freq1 = new int[26];
        for (int i=0; i<l1; i++) {
            char c = s1.charAt(i);
            freq1[c - 'a']++;
        }
        // store the frequency of every window of size l1 from s2 in freq2
        for (int i=0; i<=l2-l1; i++) {
            int[] freq2 = new int[26];
            for (int j=0; j<l1; j++) {
                char c = s2.charAt(i+j);
                freq2[c - 'a']++;
            }
            if (matches(freq1, freq2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * TC = O(l1 + 26 * (l2 - l1))
     * SC = O(1)
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion1(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 > l2) {
            return false;
        }
        // store the frequency of all the characters of s1 in freq1
        // store the frequency of first window of size l1 of s2 in freq2
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (int i=0; i<l1; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }
        if (matches(freq1, freq2)) {
            return true;
        }
        for (int i=1; i<l2-l1+1; i++) {
            freq2[s2.charAt(i-1) - 'a']--;
            freq2[s2.charAt(i + l1 -1) - 'a']++;
            if (matches(freq1, freq2)) {
                return true;
            }
        }
        return false;
    }

    private boolean matches(int[] freq1, int[] freq2) {
        for (int i=0; i<26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }
}
