package string.practice;

public class MinAdjSwapsToMakePal {

    private static int minAdjacentSwapsToMakePal(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return -1;
        }
        int swaps = 0;
        if (isShuffledPal(s)) {
            char[] ch = s.toCharArray();
            int l = 0, r = s.length() - 1;
            while (l < r) {
                // shrink the window
                if (ch[l] == ch[r]) {
                    l++;
                    r--;
                } else {
                    // find the matching pair
                    int k = r;
                    while (k > l && ch[l] != ch[k]) {
                        k--;
                    }
                    // no matching pair found
                    if (k == l) {
                        swap(ch, l, l+1);
                        swaps++;
                    }
                    // matching pair found
                    else {
                        while (k < r) {
                            swap(ch, k, k+1);
                            swaps++;
                            k++;
                        }
                        l++;
                        r--;
                    }
                }
            }
            return swaps;
        }
        return -1;
    }

    private static void swap(char[] ch, int left, int right) {
        while (left < right) {
            char t = ch[left];
            ch[left] = ch[right];
            ch[right] = t;
            left++;
            right--;
        }
    }

    private static boolean isShuffledPal(String s) {
        int[] freq = new int[26];
        for (int i=0;i<s.length();i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int oddCount = 0;
        for (int i=0;i<26;i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }

    public static void main(String[] args) {
        String s = "ntiin";
        System.out.println(minAdjacentSwapsToMakePal(s));
    }
}
