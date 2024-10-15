package binarysearch.practice;

public class SquareRootNew {

  private static int mySqrt(int x) {
    // TODO: Write your code here
    // if x is 0 or 1 then return x
    if (x < 2) {
      return x;
    }
    int left = 2;
    int right = x/2;
    while (left <= right) {
      int mid = left + (right - left)/2;
      long num = (long) mid * mid;
      if (num > mid) {
        right = mid-1;
      } else if (num < mid) {
        left = mid+1;
      } else {
        return mid;
      }
    }
    return right;
  }

  public static void main(String[] args) {
    System.out.println(mySqrt(4));
  }
}
