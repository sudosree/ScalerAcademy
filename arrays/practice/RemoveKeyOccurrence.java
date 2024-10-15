package arrays.practice;

public class RemoveKeyOccurrence {

  private static int removeKey(int[] arr, int key) {
    // pos for next non key element
    int nextPos = 0;
    for (int i=0; i<arr.length; i++) {
      // check if the curr element is not equal to key
      if (arr[i] != key) {
        // copy the curr non key element to the next non key element pos
        arr[nextPos] = arr[i];
        nextPos++;
      }
    }
    return nextPos;
  }

  public static void main(String[] args) {
    int[] arr = {2, 11, 2, 2, 1};
    int key = 2;
    System.out.println(removeKey(arr, key));
  }
}
