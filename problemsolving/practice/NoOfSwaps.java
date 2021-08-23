package problemsolving.practice;

public class NoOfSwaps {

    private static int noOfSwaps(int[] arr) {
        int count = 0;
        for (int i=0;i<arr.length;i++) {
            for (int j=i+1;j<arr.length;j++) {
                if (arr[i] > arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,1,2};
        System.out.println(noOfSwaps(arr));
    }
}
