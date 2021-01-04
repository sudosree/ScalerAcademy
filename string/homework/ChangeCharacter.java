package string.homework;

public class ChangeCharacter
{
    static class Pair {
        int min;
        int max;
        Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
    private static int solve(String A, int B) {
        int[] freq = new int[26];
        for (int i=0;i<A.length();i++) {
            freq[A.charAt(i)-'a']++;
        }
        int count = 0;
        while (B > 0) {
            // find the min-max pair
            Pair pair = findMinMax(freq);
            int min = pair.min;
            int max = pair.max;
            if (freq[min] <= B) {
                // replace the character with minimum frequency with the character
                // with maximum frequency
                freq[max] = freq[max] + freq[min];
                B -= freq[min];
                freq[min] = 0;
            } else {
                break;
            }
        }
        // check distinct characters
        for (int i=0;i<26;i++) {
            if (freq[i] != 0) {
                count++;
            }
        }
        return count;
    }

    private static Pair findMinMax(int[] a) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int minChar = -1, maxChar = -1;
        for (int i=0;i<26;i++) {
            if (a[i] != 0 && a[i] < min) {
                min = a[i];
                minChar = i;
            }
            if (a[i] != 0 && a[i] > max) {
                max = a[i];
                maxChar = i;
            }
        }
        return new Pair(minChar, maxChar);
    }

    public static void main(String[] args)
    {
        String A = "aabbbccefg";
        int B = 5;
        System.out.println(solve(A,B));
    }
}
