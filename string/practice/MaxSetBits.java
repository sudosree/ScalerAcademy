package string.practice;

public class MaxSetBits {

    private static int maxSetBits(String S, int K) {
        char[] ch = S.toCharArray();
        int max_set_bits = Integer.MIN_VALUE;
        int set_bits = 0;
        for (int i=0;i<K;i++) {
            if (ch[i] == '1') {
                set_bits++;
            }
        }
        max_set_bits = set_bits;
        for (int i=1;i<ch.length-K+1;i++) {
            if (ch[i-1] == '1') {
                set_bits--;
            }
            if (ch[i+K-1] == '1') {
                set_bits++;
            }
            max_set_bits = Math.max(max_set_bits, set_bits);
        }
        return max_set_bits;
    }

    public static void main(String[] args) {
        String S = "0000000";
        int K = 4;
        System.out.println(maxSetBits(S,K));
    }
}
