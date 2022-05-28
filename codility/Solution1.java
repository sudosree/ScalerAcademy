package codility;

public class Solution1 {
    public static int solution(String S) {
        // write your code in Java SE 8
        long decimal = convertBinaryToDecimal(S);
        int count = 0;
        while (decimal != 0) {
            // if the no. is odd
            if ((decimal & 1) == 1) {
                decimal--;
            }
            // the no. is even
            else {
                decimal = (decimal >> 1);
            }
            count++;
        }
        return count;
    }

    private static long convertBinaryToDecimal(String s) {
        long ans = 0;
        int power = 0;
        for (int i=s.length()-1; i>=0; i--) {
            int num = s.charAt(i) - '0';
            if (num == 1) {
                ans += (num * Math.pow(2, power));
            }
            power++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(solution(s));
    }
}
