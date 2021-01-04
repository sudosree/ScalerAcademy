package problemsolving.homework;

import java.util.*;

public class AlternatePositiveNegative
{

    /**
     * TC = O(n), SC = O(n)
     */
    private static int[] solve(int[] A) {
        int[] ans = new int[A.length];
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        for (int i=0; i<A.length;i++) {
            if (A[i] < 0) {
                neg.add(A[i]);
            } else {
                pos.add(A[i]);
            }
        }
        int i=0,j=0,k=0;
        boolean flag = true;
        while (i<neg.size() && j<pos.size()) {
            if (flag) {
                ans[k] = neg.get(i);
                k++;
                i++;
                flag = false;
            } else {
                ans[k] = pos.get(j);
                k++;
                j++;
                flag = true;
            }
        }
        while (i<neg.size()) {
            ans[k] = neg.get(i);
            k++;
            i++;
        }
        while (j<pos.size()) {
            ans[k] = pos.get(j);
            k++;
            j++;
        }
        return ans;
    }

    /**
     * TC = O(n^2), SC = O(1)
     */
    private static int[] solve1(int[] A) {
        for (int i=0;i<A.length;i++) {
            // if the no. is positive and the index is even then
            // the no. is not at its right place
            if (A[i] >= 0 && i%2 == 0) {
                // find the first negative number index
                int neg = -1;
                for (int j=i+1;j<A.length;j++) {
                    if (A[j] < 0) {
                        neg = j;
                        break;
                    }
                }
                // if the negative index is found then left rotate the array starting from the
                // positive number's index i to negative number's index j
                if (neg != -1) {
                    int temp = A[neg];
                    for (int k=neg; k>=i+1; k--) {
                        A[k] = A[k-1];
                    }
                    A[i] = temp;
                }
            }
            // if the no. is negative and the index is odd then
            // the no. is not at its right place
            else if (A[i] < 0 && i%2 == 1) {
                // find the first positive number index
                int pos = -1;
                for (int j=i+1;j<A.length;j++) {
                    if (A[j] >= 0) {
                        pos = j;
                        break;
                    }
                }
                // if the positive index is found then left rotate the array starting from the
                // negative number's index i to positive number's index j
                if (pos != -1) {
                    int temp = A[pos];
                    for (int k=pos; k>=i+1; k--) {
                        A[k] = A[k-1];
                    }
                    A[i] = temp;
                }
            }
        }
        return A;
    }

    public static void main(String[] args)
    {
        int[] A = {5, -17, -100, -11};
        System.out.println(Arrays.toString(solve1(A)));
    }
}
