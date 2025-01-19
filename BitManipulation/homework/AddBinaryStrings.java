package BitManipulation.homework;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * Example:
 *
 * a = "100"
 *
 * b = "11"
 *
 * Return a + b = "111".
 */
public class AddBinaryStrings
{
    private static String addBinary(String A, String B) {
        if (A.length() < B.length()) {
            String temp = A;
            A = B;
            B = temp;
        }
        StringBuilder str = new StringBuilder();
        int i, j;
        int carry = 0, sum;
        for (i=A.length()-1, j=B.length()-1; i>=0 && j>=0; i--,j--) {
            int a = A.charAt(i) - '0';
            int b = B.charAt(j) - '0';
            sum = carry ^ a ^ b;
            str.append(sum);
            // if any two bits are 1 then carry is 1 else 0
            if (a == 1 && b == 1 || a == 1 && carry == 1 || b == 1 && carry == 1) {
                carry = 1;
            } else {
                carry = 0;
            }
        }
        for (int k = i; k>=0; k--) {
            int a = A.charAt(k) - '0';
            sum = carry ^ a;
            str.append(sum);
            // if both the bits are 1 then carry is 1 else 0
            if (a == 1 && carry == 1) {
                carry = 1;
            } else {
                carry = 0;
            }
        }
        // if carry is 1 add it to the result string
        if (carry == 1) {
            str.append(carry);
        }
        return str.reverse().toString();
    }

    private static String solve(String A, String B) {
        int sum, carry = 0;
        int i = A.length()-1, j = B.length()-1;
        StringBuilder str = new StringBuilder();
        while (i >= 0 || j >= 0) {
            sum = carry;
            if (i >= 0) {
                int a = A.charAt(i) - '0';
                sum += a;
            }
            if (j >= 0) {
                int b = B.charAt(j) - '0';
                sum += b;
            }
            carry = sum/2;
            sum = sum%2;
            i--;
            j--;
            str.append(sum);
        }
        if (carry == 1) {
            str.append(carry);
        }
        return str.reverse().toString();
    }

    public static String addBinary1(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int m = a.length(), n = b.length();
        int i = m - 1;
        int j = n - 1;
        int carry = 0, sum;

        while (i >= 0 || j >= 0 || carry == 1) {
            sum = 0;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            sum += carry;
            // compute the binary digit
            ans.append(sum % 2);
            // compute the carry
            carry = sum / 2;
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args)
    {
        String A = "11";
        String B = "1";
        System.out.println(addBinary1(A, B));
    }
}
