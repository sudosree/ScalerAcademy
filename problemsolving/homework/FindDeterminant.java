package problemsolving.homework;

public class FindDeterminant
{
    private static int solve(int[][] A) {
        int n = A.length;
        if (n == 2) {
            return A[0][0] * A[1][1] - A[0][1] * A[1][0];
        }
        // for n = 3
        int a = A[0][0], b = A[0][1], c = A[0][2];
        int ei = A[1][1] * A[2][2], fh = A[1][2] * A[2][1];
        int di = A[1][0] * A[2][2], fg = A[1][2] * A[2][0];
        int dh = A[1][0] * A[2][1], eg = A[1][1] * A[2][0];
        return a * (ei - fh) - b * (di - fg) + c * (dh - eg);
    }

    public static void main(String[] args)
    {
        int[][] A = {
                {6, 1, 1},
                {4, -2, 5},
                {2, 8, 7}
        };
        System.out.println(solve(A));
    }
}
