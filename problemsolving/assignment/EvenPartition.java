package problemsolving.assignment;

public class EvenPartition
{
    private static int solve(int A) {
        if (A == 2 || A == 4) {
            return 0;
        }
        return (A & 1) == 0 ? 1 : 0;
    }

    private static int solve1(int A) {
        if (A == 2 || A == 4) {
            return 0;
        }
        if (A%2 == 1) {
            return 0;
        }
        for (int i=2;i<A/2;i+=2) {
            if (i == A-i) {
                return 0;
            }
        }
        return 1;
    }

    private static int solve2(int A) {
        return (A > 5 && A%2 == 0) ? 1 : 0;
    }

    public static void main(String[] args)
    {
        int A = 23;
        System.out.println(solve2(A));
    }
}
