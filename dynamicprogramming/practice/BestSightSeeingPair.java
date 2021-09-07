package dynamicprogramming.practice;

public class BestSightSeeingPair {

    public static int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int[] maxEndGain = new int[n];
        maxEndGain[n-1] = values[n-1] - (n-1);
        int maxScore = 0;
        for (int i=n-2; i>=0; i--) {
            maxEndGain[i] = Math.max(maxEndGain[i+1], values[i+1] - (i+1));
            maxScore = Math.max(maxScore, values[i] + i + maxEndGain[i]);
        }
        return maxScore;
    }

    public static void main(String[] args) {
        int[] values = {1,1,1};
        System.out.println(maxScoreSightseeingPair(values));
    }
}
