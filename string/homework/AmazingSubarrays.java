package string.homework;

public class AmazingSubarrays
{
    private static int solve(String A) {
        int count = 0;
        for (int i=0;i<A.length();i++) {
            char ch = A.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                count += A.length() - i;
            }
        }
        return count % 10003;
    }

    public static void main(String[] args)
    {
        String A = "ABEC";
        System.out.println(solve(A));
    }
}
