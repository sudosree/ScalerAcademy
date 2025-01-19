package string.homework;

public class LongestCommonPrefix
{

    /**
     * Time Complexity - O(k) where k is the sum of length of all
     * the strings in the array
     * Space Complexity - O(k)
     */
    private static String solve(String[] A) {
        String[] prefix = new String[A.length];
        prefix[0] = A[0];
        for (int i=1;i<A.length;i++) {
            prefix[i] = commonPrefix(prefix[i-1],A[i]);
        }
        return prefix[prefix.length-1];
    }

    private static String commonPrefix(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int min = Math.min(s1.length(), s2.length());
        for (int i=0;i<min;i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            } else {
                sb.append(s1.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * Time Complexity - O(ln) where l is the length of the string with minimum
     * length and n is the no. of elements in the array
     * Space Complexity - O(1)
     */
    private static String solve1(String[] A) {
        // find string with min length
        int min = Integer.MAX_VALUE;
        String s = "";
        for (int i=0;i<A.length;i++) {
            if (A[i].length() < min) {
                min = A[i].length();
                s = A[i];
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i=0;i<min;i++) {
            char ch = s.charAt(i);
            for (int j=0;j<A.length;j++) {
                String t = A[j];
                if (t.charAt(i) != ch) {
                    return ans.toString();
                }
            }
            ans.append(ch);
        }
        return ans.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0) {
            return "";
        }
        // initially longest common prefix is the first word in the array
        String prefix = strs[0];
        for (int i=1; i<n; i++) {
            String word = strs[i];
            // check if the word starts with the longest common prefix seen so far
            // if it is not then remove the last letter from the prefix
            while (word.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
                // if we removed every letter then there is no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public String longestCommonPrefix1(String[] strs) {
        int n = strs.length;
        if (n == 0) {
            return "";
        }
        // initially longest common prefix is the first word in the array
        String prefix = strs[0];
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            for (int j=1; j<n; j++) {
                String word = strs[j];
                // check if the character at index i matches with the character at index i in
                // other strings or if the word starts with the prefix
                if (i == word.length() || c != word.charAt(i)) {
                    return prefix.substring(0, i);
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args)
    {
        String[] A = {"abedefgh", "abefghijk", "abcefgh", "abedrgrg"};
        System.out.println(solve1(A));
    }
}
