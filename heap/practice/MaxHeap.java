package heap.practice;

public class MaxHeap {

    private int[] heap;
    private int size;
    private int maxSize;

    public MaxHeap(int n) {
        this.heap = new int[n];
        this.size = 0;
        this.maxSize = n;
    }

    public boolean isLeaf(int i) {
        return (i >= size/2 && i < size);
    }

    public int parent(int i) {
        return Math.floorDiv(i-1, 2);
    }

    public int leftChild(int i) {
        return 2*i+1;
    }

    public int rightChild(int i) {
        return 2*i+2;
    }

    /**
     * Iterative approach
     * TC = O(logn), SC = O(logn)
     */
    public void percolateDown(int[] arr, int i, int n) {
        // for non-leaf nodes
        while (i <= n/2 -1) {
            int left = leftChild(i);
            int right = rightChild(i);
            int greatest = i;

            if (left < n && arr[left] > arr[i]) {
                greatest = left;
            }
            if (right < n && arr[right] > arr[greatest]) {
                greatest = right;
            }
            if (greatest != i) {
                int temp = arr[i];
                arr[i] = arr[greatest];
                arr[greatest] = temp;
                i = greatest;
            } else {
                break;
            }
        }
    }

    /**
     * TC = O(logn), SC = O(logn)
     */
    public void percolateDownR(int[] arr, int i, int n) {
        if (isLeaf(i)) {
            return;
        }
        int left = leftChild(i);
        int right = rightChild(i);
        int greatest = i;
        if (left < n && arr[left] > arr[i]) {
            greatest = left;
        }
        if (right < n && arr[right] > arr[greatest]) {
            greatest = right;
        }
        if (greatest != i) {
            int temp = arr[i];
            arr[i] = arr[greatest];
            arr[greatest] = temp;
            percolateDownR(arr, greatest, n);
        }
    }

    /**
     * TC = O(logn), SC = O(logn)
     */
    public void percolateUp() {
        int parent = parent(size);
        int i = size;
        while (i > 0 && heap[i] > heap[parent]) {
            int temp = heap[i];
            heap[i] = heap[parent];
            heap[parent] = temp;
            i = parent;
            parent = parent(i);
        }
    }

    /**
     * TC = O(logn)
     */
    public void insert(int element) {
        if (size == maxSize) {
            System.out.println("Cannot insert " + element + " . Size is full.");
            return;
        }
        // insert element at the leaf
        heap[size] = element;
        percolateUp();
        size++;
    }

    /**
     * TC = O(n)
     */
    public void buildHeapDown(int[] arr) {
        int n = arr.length;
        // for non leaf nodes
        for (int i=n/2-1;i>=0;i--) {
            percolateDownR(arr, i, n);
        }
    }

    /**
     * TC = O(nlogn), SC = O(n) (creating heap)
     */
    public void buildHeapUp(int[] arr) {
        int n = arr.length;
        for (int i=0;i<n;i++) {
            insert(arr[i]);
        }
    }

    /**
     * TC = O(logn)
     */
    public int extractMax() {
        int temp = heap[0];
        heap[0] = heap[size-1];
        heap[size-1] = temp;
        size--;
        percolateDown(heap, 0, size);
        return temp;
    }

    public static void main(String[] args) {
        int[] A = {16,4,10,14,7,9,3,2,8,1};
        MaxHeap maxHeap = new MaxHeap(A.length);
        maxHeap.buildHeapDown(A);
        System.out.println("Build max heap using Percolate Down");
        for (int i=0;i<A.length;i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();

        System.out.println("Build max heap using Percolate Up");
        maxHeap.buildHeapUp(A);
        for (int i=0;i< maxHeap.size;i++) {
            System.out.print(maxHeap.heap[i] + " ");
        }
        System.out.println();

        System.out.println("Extract Max");
        maxHeap.extractMax();
        for (int i=0;i< maxHeap.size;i++) {
            System.out.print(maxHeap.heap[i] + " ");
        }
        System.out.println();

        MaxHeap maxHeap1 = new MaxHeap(11);
        maxHeap1.insert(10);
        maxHeap1.insert(9);
        maxHeap1.insert(8);
        maxHeap1.insert(5);
        maxHeap1.insert(4);
        maxHeap1.insert(7);
        maxHeap1.insert(6);
        maxHeap1.insert(3);
        maxHeap1.insert(2);
        maxHeap1.insert(1);
        maxHeap1.insert(200);
        maxHeap1.insert(300);

        for (int i=0;i< maxHeap1.size;i++) {
            System.out.print(maxHeap1.heap[i] + " ");
        }
        System.out.println();
    }
}
