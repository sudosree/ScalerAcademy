package heap.assignment;

public class ConnectRopes {

    private static int size;

    /**
     * TC = O(n) + O(nlogn) = O(nlogn)
     * where O(n) is for building min heap
     */
    public static int solve(int[] A) {

        int minCost = 0;
        size = A.length;
        // build min heap from array A
        buildMinHeap(A);
        while (size > 1) {
            int num1 = extractMin(A);
            int num2 = extractMin(A);
            int costSum = num1 + num2;
            minCost += costSum;
            insert(A, costSum);
        }
        return minCost;
    }

    private static void buildMinHeap(int[] A) {
        int n = A.length;
        for (int i=n/2-1;i>=0;i--) {
            percolateDown(A, i);
        }
    }

    private static boolean isLeaf(int i) {
        return i >= size/2 && i < size;
    }

    private static void percolateDown(int[] A, int i) {

        if (isLeaf(i)) {
            return;
        }

        int left = 2*i+1;
        int right = 2*i+2;
        int smaller =  i;

        if (left < size && A[left] < A[i]) {
            smaller = left;
        }
        if (right < size && A[right] < A[smaller]) {
            smaller = right;
        }
        if (smaller != i) {
            int temp = A[i];
            A[i] = A[smaller];
            A[smaller] = temp;
            percolateDown(A, smaller);
        }
    }

    private static int extractMin(int[] A) {
        int temp = A[0];
        A[0] = A[size-1];
        A[size-1] = temp;
        size--;
        percolateDown(A, 0);
        return temp;
    }

    private static int getParent(int i) {
        return Math.floorDiv(i-1,2);
    }

    private static void insert(int[] A, int num) {
        A[size] = num;
        percolateUp(A);
        size++;
    }

    private static void percolateUp(int[] A) {
        int i = size;
        int parent = getParent(i);
        while (i > 0 && A[i] < A[parent]) {
            int t = A[i];
            A[i] = A[parent];
            A[parent] = t;
            i = parent;
            parent = getParent(i);
        }
    }

    public static void main(String[] args) {
        int[] A = {16, 7, 3, 5, 9, 8, 6, 15};
        System.out.println(solve(A));
    }
}
