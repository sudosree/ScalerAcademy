package recursion.assignment;

public class Fibonacci
{
    private static int findFibonacci(int A) {
        if (A == 0 || A == 1) {
            return A;
        }
        return findFibonacci(A-1) + findFibonacci(A-2);
    }

    public static void main(String[] args)
    {
        int A = 9;
        System.out.println(findFibonacci(A));
    }
}
