package problemsolving.assignment;

public class SumOfAdjacentElements
{
    private static int solve(int[] A) {
        // count of odd and even elements
        int odd = 0, even = 0;
        for (int i=0;i<A.length;i++) {
            if (A[i]%2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(odd, even);
    }

    public static void main(String[] args)
    {
        int[] A = {5, 17, 100, 11};
        System.out.println(solve(A));
    }
}
