package string.assignment;

public class RotateString
{
    private static String solve(String A, int B) {
        int n = A.length();
        B = B%n;
        char[] ch = A.toCharArray();
        char[] res = new char[n];
        for (int i=0;i<n;i++) {
            res[i] = ch[(n-B+i)%n];
        }
        return new String(res);
    }

    private static String solve1(String A, int B) {
        int n = A.length();
        char[] ch = A.toCharArray();
        B = B%n;
        // reverse the whole string
        reverse(ch, 0, n-1);
        // reverse the first B characters
        reverse(ch, 0, B-1);
        // reverse the last n-B characters
        reverse(ch, B, n-1);
        return new String(ch);
    }

    private static void reverse(char[] ch, int start, int end) {
        while (start < end) {
            char t = ch[start];
            ch[start++] = ch[end];
            ch[end--] = t;
        }
    }

    public static void main(String[] args)
    {
        String A = "scaler";
        int B = 2;
        System.out.println(solve1(A,B));
    }
}
