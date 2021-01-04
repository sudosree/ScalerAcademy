package problemsolving.assignment;

import java.util.Arrays;

/**
 Given an array of distinct integers A, find and return all elements in array which have at-least two greater elements than themselves.

 Note: The results should have the order in which they are present in the original array.


 Input Format

 The only argument given is the integer array A.

 Output Format

 Return the elements which have at-least two greater elements than themselves.

 Constraints

 3 <= length of the array <= 100000
 -10^9 <= A[i] <= 10^9

 For Example

 Input 1:
 A = [1, 2, 3, 4, 5]
 Output 1:
 [1, 2, 3]

 Input 2:
 A = [5, 17, 100, 11]
 Output 2:
 [5, 11]

 */
public class AtLeastTwoGreaterElements
{
    private static int[] solve(int[] A) {
        int[] res = new int[A.length-2];
        int[] copyArr = Arrays.copyOf(A, A.length);
        Arrays.sort(copyArr);
        int largest = copyArr[copyArr.length-1];
        int secondLargest = copyArr[copyArr.length-2];
        for (int i=0,j=0; i<res.length || j<A.length; j++) {
            if (A[j] != secondLargest && A[j] != largest) {
                res[i] = A[j];
                i++;
            }
        }
        return res;
    }

    private static int[] solve1(int[] A) {
        int[] res = new int[A.length-2];
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for (int i=0;i<A.length;i++) {
            if (A[i] > largest) {
                secondLargest = largest;
                largest = A[i];
            } else if (A[i] > secondLargest) {
                secondLargest = A[i];
            }
        }
        for (int i=0,j=0;i<res.length&&j<A.length;j++) {
            if (A[j] != secondLargest && A[j] != largest) {
                res[i] = A[j];
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] A = {391, 634, 740, 441, 75, 444, 65, 611, 679, 59, 878, 102, 42, 190, 801, 571, 79, 686, 523, 580, 199, 497, 879, 334, 200, 202, 991, 341, 479, 563, 112, 550, 494, 468, 56, 644, 53, 581, 836, 461, 905, 849, 838, 434, 818, 350, 585, 280, 252, 834, 510, 420, 395, 776, 118, 886, 19, 809, 534, 143, 933, 15, 999, 514, 230, 531, 666, 841, 861, 703, 972, 622, 640, 21, 811, 476, 751, 430, 308, 996, 165, 812, 424, 412, 903, 601, 226, 239, 728, 135};
        int[] arr = solve1(A);
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
