package recursion.assignment;

import java.util.*;

public class Subset
{

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
        List<Integer> A = Arrays.asList(3,2,1,4);
        System.out.println(subsets(A));
    }
}
