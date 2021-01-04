package string.assignment;

public class SimpleReverse
{
    private static String solve(String A) {
        char[] ch = A.toCharArray();
        int start = 0, end = A.length()-1;
        while (start < end) {
            char t = ch[start];
            ch[start] = ch[end];
            ch[end] = t;
            start++;
            end--;
        }
        return new String(ch);
    }

    public static void main(String[] args)
    {
        String A = "Scaler";
        System.out.println(solve(A));
    }
}
