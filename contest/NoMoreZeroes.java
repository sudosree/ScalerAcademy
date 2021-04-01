package contest;

public class NoMoreZeroes {

    public static String solve(int A) {
        // count the no. of zeroes in A
        int count = countZeroes(A);
        // no zeroes
        if (count == 0) {
            count = countZeroes(A+1);
        }
        String s = "";
        while (count > 0) {
            s += "1";
            count--;
        }
        if (!s.isEmpty()) {
            int num = Integer.parseInt(s);
            return String.valueOf(A + num);
        }
        return String.valueOf(A + 1);
    }

    private static int countZeroes(int A) {
        int count = 0;
        while (A > 0) {
            int rem = A%10;
            if (rem == 0) {
                count++;
            }
            A /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        int A = 99;
        System.out.println(solve(A));
    }
}
