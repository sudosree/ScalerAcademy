package arrays.practice;

public class NumberDigitsAndSums {

  public static String findNumber(int N, int S) {
    // if the sum is zero
    if (S == 0) {
      // and the no. of digit is 1 then you can have only one no. i.e. 0
      if (N == 1) {
        return "0";
      }
      // else if the no. of digits are more than 1
      return "Not Possible";
    }
    // if the sum is out of bound
    if (S > 9 * N) {
      return "Not Possible";
    }
    StringBuilder sb = new StringBuilder();
    for (int i=1; i<=N; i++) {
      if (S >= 9) {
        sb.append(9);
        S -= 9;
      } else {
        sb.append(S);
        S = 0;
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    int N = 2, S = 18;
    System.out.println(findNumber(N, S));
  }
}
