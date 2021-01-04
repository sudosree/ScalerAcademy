package string.homework;

public class CountOccurrences
{
    private static int solve(String A) {
        int count = 0;
        int i = 0, n = A.length();
        while (i < n) {
            if (A.startsWith("bob", i)) {
                count++;
                i += 2;
            } else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        String A = "bobob";
        System.out.println(solve(A));
    }
}
