package contest;

public class AreaUnderHills
{
    private static String solve(int[] A) {
        long area = 0;
        for (int i=0;i<A.length;i++) {
            area += A[i];
        }
        return String.valueOf(area);
    }

    public static void main(String[] args)
    {
        int[] A = {5,3,1,6};
        System.out.println(solve(A));
    }
}
