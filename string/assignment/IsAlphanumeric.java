package string.assignment;

public class IsAlphanumeric
{
    private static int solve(char[] A) {
        for (int i=0;i<A.length;i++) {
            if ((A[i] >= 'a' && A[i] <= 'z') || (A[i] >= 'A' && A[i] <= 'Z')
                || (A[i] >= '0' && A[i] <= '9')) {
                continue;
            } else {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args)
    {
        char[] A = {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0'};
        System.out.println(solve(A));
    }
}
