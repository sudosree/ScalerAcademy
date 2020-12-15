package hashmap.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description
 *
 * Given two integer array A and B of size N and M respectively. Your task is to find all the common elements in both the array.
 *
 * NOTE:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 *
 *
 * Problem Constraints
 *
 * 1 <= N, M <= 105
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 *
 * First argument is an integer array A of size N.
 *
 * Second argument is an integer array B of size M.
 *
 *
 *
 * Output Format
 *
 * Return an integer array denoting the common elements.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *  A = [1, 2, 2, 1]
 *  B = [2, 3, 1, 2]
 *
 * Input 2:
 *
 *  A = [2, 1, 4, 10]
 *  B = [3, 6, 2, 10, 10]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [1, 2, 2]
 *
 * Output 2:
 *
 *  [2, 10]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
 *
 * Explantion 2:
 *
 *  Elements (2, 10) appears in both the array.
 */
public class CommonElements
{
    private static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<A.size();i++) {
            if (!map.containsKey(A.get(i))) {
                map.put(A.get(i), 1);
            } else {
                map.put(A.get(i), map.get(A.get(i))+1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<B.size();i++) {
            if (map.containsKey(B.get(i)) && map.get(B.get(i)) > 0) {
                map.put(B.get(i), map.get(B.get(i))-1);
                list.add(B.get(i));
            }
        }
        return list;
    }

    private static ArrayList<Integer> solve(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<A.length;i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            } else {
                map.put(A[i], map.get(A[i])+1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<B.length;i++) {
            if (map.containsKey(B[i]) && map.get(B[i]) > 0) {
                map.put(B[i], map.get(B[i])-1);
                list.add(B[i]);
            }
        }
        return list;
    }

    public static void main(String[] args)
    {
        int[] A = {2, 1, 4, 10};
        int[] B = {3, 6, 2, 10, 10};
        ArrayList<Integer> list = solve(A,B);
        for (int i=0;i<list.size();i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
