package string.assignment;

public class ToLower
{
    private static char[] solve(char[] A) {
        int n = A.length;
        char[] res = new char[n];
        for (int i=0;i<n;i++) {
            if (A[i] >= 'A' && A[i] <= 'Z') {
                res[i] = (char) (A[i] - 'A' + 'a');
            } else {
                res[i] = A[i];
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        char[] A = {'S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0'};
        System.out.println(solve(A));
    }
}
