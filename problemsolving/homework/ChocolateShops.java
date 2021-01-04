package problemsolving.homework;

public class ChocolateShops
{

    /**
     * TC = O(n^2), SC = O(1)
     */
    private static int solve(int A, int[] B) {
        int max = 0, sum;
        for (int i=0;i<B.length;i++) {
            sum = B[i];
            max = Math.max(max, sum);
            for (int j=i+1;j<B.length;j++) {
                if (B[j] < B[j-1]) {
                    break;
                }
                sum += B[j];
                max = Math.max(max,sum);
            }
        }
        return max;
    }

    /**
     * TC = O(n), SC = O(1)
     */
    private static int solve1(int A, int[] B) {
        int max = B[0], sum = B[0], prev = B[0];
        for (int i=1;i<B.length;i++) {
            if (B[i] < prev) {
                sum = B[i];
            } else {
                sum += B[i];
            }
            prev = B[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args)
    {
        int A = 6;
        int[] B = {2, 2, 1, 3, 4, 1};
        System.out.println(solve1(A,B));
    }
}
