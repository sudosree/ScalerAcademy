package BitManipulation.practice;

public class CheckPowerOf2
{
    private static boolean solve(int n) {
        if (n == 1){
            return true;
        }
        while (n > 1) {
            if (n%2 != 0) {
                return false;
            }
            n /= 2;
        }
        return true;
    }

    private static boolean solve1(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count == 1;
    }

    private static boolean solve2(int n) {
        return n != 0 && ((n & (n-1)) == 0);
    }

    public static void main(String[] args)
    {
        int n = 10;
        System.out.println(solve2(n));
    }
}
