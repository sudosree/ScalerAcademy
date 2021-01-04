package string.assignment;

public class ToUpper
{
    private static char[] solve(char[] A) {
        int n = A.length;
        char[] res = new char[n];
        for (int i=0;i<n;i++) {
            if (A[i] >= 'a' && A[i] <= 'z') {
                res[i] = (char)(A[i] - 'a' + 'A');
            } else {
                res[i] = A[i];
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        char[] ch = {'S', 'c', 'a', 'L', 'e', 'R', '#', '2', '0', '2', '0'};
        System.out.println(solve(ch));
    }
}
