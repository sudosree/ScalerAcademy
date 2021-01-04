package problemsolving.assignment;

public class SquareGranites
{
    private static int solve(int A, int B, int C) {
        return (int) (Math.ceil((double) A / C) * Math.ceil((double) B / C));
    }

    public static void main(String[] args)
    {
        int A = 3, B = 6, C = 4;
        System.out.println(solve(A,B,C));
    }
}
