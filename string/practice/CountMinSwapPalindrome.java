package string.practice;

public class CountMinSwapPalindrome {

    private static int noOfSwaps(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int swapped = 0;
        if (isShuffledPalindrome(s)) {
            int l = 0, r = s.length()-1;
            char[] ch = s.toCharArray();
            while (l < r) {
                // if found a matching pair then shrink the window
                if (ch[l] == ch[r]) {
                    l++;
                    r--;
                }
                // no matching pair found
                else {
                    // find the matching pair
                    int k = r;
                    while (l < k && ch[l] != ch[k]) {
                        k--;
                    }
                    // no matching pair found
                    if (k == l) {
                        // swap with the adjacent character
                        swap(ch, l, l+1);
                        swapped++;
                    }
                    // matching pair found
                    else {
                        // swap until k reaches r
                        while (k < r) {
                            swap(ch, k, k+1);
                            k++;
                            swapped++;
                        }
                        l++;
                        r--;
                    }
                }
            }
        } else {
            return -1;
        }
        return swapped;
    }

    private static void swap(char[] ch, int l, int r) {
        char t = ch[l];
        ch[l] = ch[r];
        ch[r] = t;
    }

    private static boolean isShuffledPalindrome(String s) {
        int[] freq = new int[26];
        for (int i=0;i<s.length();i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int oddCount = 0;
        for (int i=0;i<26;i++) {
            if (freq[i] % 2 != 0)  {
                oddCount++;
            }
        }
        // the no. of odd ocuuring character should only be 1 or 0
        // 1 for odd length palindrome and 0 for even length palindrome
        return oddCount <= 1;
    }

    public static void main(String[] args) {
        String s = "aabcb";
        System.out.println(noOfSwaps(s));
    }
}
