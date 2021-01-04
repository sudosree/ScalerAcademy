package recursion.assignment;

import java.util.*;

public class SubsetWithDuplicate
{
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(List<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> choices = new ArrayList<>();
        result.add(choices);
        Collections.sort(A);
        subsetsWithDupHelper(A, 0, choices, result);
        return result;
    }

    private static void subsetsWithDupHelper(List<Integer> A, int index, ArrayList<Integer> choices, ArrayList<ArrayList<Integer>> result) {
        for (int i=index;i<A.size();i++) {
            // if the current element is equal to the previous element then do not add this element to the intermediate list
            // and also i>index instead of i>0 because if i>0 then 1,2,2 subset will never get created
            if (i>index && A.get(i).equals(A.get(i - 1))) {
                continue;
            }
            choices.add(A.get(i));
            result.add(new ArrayList<>(choices));
            subsetsWithDupHelper(A,i+1,choices,result);
            choices.remove(choices.size()-1);
        }
    }

    public static void main(String[] args)
    {
        List<Integer> A = Arrays.asList(2,1,2);
        System.out.println(subsetsWithDup(A));
    }
}
