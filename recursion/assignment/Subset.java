package recursion.assignment;

import java.util.*;

/**
 * Problem Description
 *
 * Given a set of distinct integers, A, return all possible subsets.
 *
 * NOTE:
 *
 *     Elements in a subset must be in non-descending order.
 *     The solution set must not contain duplicate subsets.
 *     Also, the subsets should be sorted in ascending ( lexicographic ) order.
 *     The list is not necessarily sorted.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 16
 * INTMIN <= A[i] <= INTMAX
 *
 *
 * Input Format
 *
 * First and only argument of input contains a single integer array A.
 *
 *
 * Output Format
 *
 * Return a vector of vectors denoting the answer.
 *
 *
 * Example Input
 *
 * Input 1:
 *
 * A = [1]
 *
 * Input 2:
 *
 * A = [1, 2, 3]
 *
 *
 *
 * Example Output
 *
 * Output 1:
 *
 * [
 *     []
 *     [1]
 * ]
 *
 * Output 2:
 *
 * [
 *  []
 *  [1]
 *  [1, 2]
 *  [1, 2, 3]
 *  [1, 3]
 *  [2]
 *  [2, 3]
 *  [3]
 * ]
 *
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  You can see that these are all possible subsets.
 *
 * Explanation 2:
 *
 * You can see that these are all possible subsets.
 */
public class Subset
{

    /**
     * TC = O(n * 2^n)
     * SC = O(n)
     * @param A
     * @return
     */
    private static List<List<Integer>> subsets(List<Integer> A) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> choices = new ArrayList<>();
        // add empty list into the result list, empty list is also a subset
        result.add(choices);
        // sort the input array
        Collections.sort(A);
        subsetHelper(A, 0, choices, result);
        return result;
    }

    private static void subsetHelper(List<Integer> A, int index, List<Integer> choices, List<List<Integer>> result) {
        for (int i=index;i<A.size();i++) {
            // fix one element
            choices.add(A.get(i));
            // add the intermediate list to the result list
            result.add(new ArrayList<>(choices));
            // recur for the remaining elements
            subsetHelper(A, i + 1, choices, result);
            // backtrack i.e. remove the last element
            choices.remove(choices.size()-1);
        }
    }

    public static void main(String[] args)
    {
        List<Integer> A = Arrays.asList(2,4,6,8,10);
        System.out.println(subsets(A));
    }
}
