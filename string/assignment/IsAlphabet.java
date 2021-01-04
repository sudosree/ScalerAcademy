package string.assignment;

public class IsAlphabet
{
    private static int solve(char[] A) {
        for (int i=0;i<A.length;i++) {
            if ((A[i] >= 'a' && A[i] <= 'z') || (A[i] >= 'A' && A[i] <= 'Z')) {
                continue;
            } else {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args)
    {
        char[] A = {'S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'};
        System.out.println(solve(A));
    }
}
