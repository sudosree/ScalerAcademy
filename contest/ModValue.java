package contest;

import java.util.Arrays;

public class ModValue {

    public static int solve(int[] A, int B) {
        for (int i=0;i<A.length;i++) {
            if (A[i] < 0) {
                A[i] = modForNeg(A[i], B);
            } else {
                A[i] = A[i]%B;
            }
        }
        Arrays.sort(A);
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=A.length-1;i>=0;i--) {
            sum += A[i];
            if(sum % B > max) {
                max = sum % B;
            }
        }
        return max;
    }

    private static int modForNeg(int num, int B) {
        while (num < 0) {
            num += B;
        }
        return num%B;
    }

    public static void main(String[] args) {
        int[] A = {38361, 75847, 14913, 11499, 8297};
        int B = 10000;
        System.out.println(solve(A,B));
    }
}
