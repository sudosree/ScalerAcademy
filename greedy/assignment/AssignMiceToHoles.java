package greedy.assignment;

import java.util.Arrays;

public class AssignMiceToHoles {

    public int mice(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int time = 0;
        for (int i=0;i<A.length;i++) {
            int dist = Math.abs(A[i] - B[i]);
            if (time < dist) {
                time = dist;
            }
        }
        return time;
    }
}
