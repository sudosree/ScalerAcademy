package twopointers.practice;

import java.util.ArrayList;

public class RemoveElementFromArray {

    public int removeElement(ArrayList<Integer> a, int b) {
        int i=-1;
        int len = 0;
        for (int j=0;j<a.size();j++) {
            if (a.get(j) != b) {
                i++;
                a.set(i, a.get(j));
            }
        }
        return i+1;
    }
}
