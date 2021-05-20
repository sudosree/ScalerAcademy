package greedy.assignment;

public class DistributeCandies {

    /**
     * TC = O(n), SC = O(n)
     */
    public static int candy(int[] A) {
        // first solve for the left neighbors
        int[] candies_left = new int[A.length];
        candies_left[0] = 1;
        for (int i=1;i<A.length;i++) {
            if (A[i] > A[i-1]) {
                candies_left[i] = candies_left[i-1]+1;
            } else {
                candies_left[i] = 1;
            }
        }
        // then solve for right neighbors
        int[] candies_right = new int[A.length];
        candies_right[A.length-1] = 1;
        for (int i=A.length-2;i>=0;i--) {
            if (A[i] > A[i+1]) {
                candies_right[i] = candies_right[i+1]+1;
            } else {
                candies_right[i] = 1;
            }
        }
        int total = 0;
        for (int i=0;i<A.length;i++) {
            total += Math.max(candies_left[i], candies_right[i]);
        }
        return total;
    }

    public static void main(String[] args) {
        int[] A = {3,4,1,5,2,1,7,2};
        System.out.println(candy(A));
    }
}
