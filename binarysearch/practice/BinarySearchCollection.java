package binarysearch.practice;

import java.util.Collections;
import java.util.List;

public class BinarySearchCollection {

  private static int findFirstOccurrence(List<Integer> nums, int val) {
    return Collections.binarySearch(nums, val);
  }

  public static void main(String[] args) {
    List<Integer> nums = List.of(2, 4, 6, 8, 10);
    int val = 3;
    System.out.println(findFirstOccurrence(nums, val));
  }
}
