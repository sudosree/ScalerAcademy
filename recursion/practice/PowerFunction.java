package recursion.practice;

public class PowerFunction
{

    /**
     * Time Complexity = O(n)
     * Recurrence relation - T(n) = T(n-1) + 1
     */
    private static int pow(int a, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return a;
        }
        if (a == 0) {
            return 0;
        }
        return a * pow(a,n-1);
    }

    /**
     * Time Complexity = O(n)
     * Recurrence relation - T(n) = 2T(n/2) + 1
     */
    private static int pow1(int a, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return a;
        }
        if (a == 0) {
            return 0;
        }
        // for n is even
        if (n%2 == 0) {
            return pow1(a, n/2) * pow1(a, n/2);
        }
        // for n is odd
        return a * pow1(a, n/2) * pow1(a, n/2);
    }

    /**
     * Time Complexity = O(logn)
     * Recurrence relation - T(n) = T(n/2) + 1
     */
    private static int pow2(int a, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return a;
        }
        if (a == 0) {
            return 0;
        }
        int k = pow2(a, n/2);
        if (n%2 == 0) {
            return k * k;
        }
        return a * k * k;
    }

    public static void main(String[] args)
    {
        int a = 2, n = 20;
        System.out.println(pow2(a,n));
    }
}
