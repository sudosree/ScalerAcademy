package heap.assignment;

public class ProductOf3 {

    /**
     * TC = O(nlogn)
     */
    public int[] solve(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        MaxHeap heap = new MaxHeap(n);

        for (int i=0;i<n;i++) {
            heap.insert(A[i]);
            if (i < 2) {
                B[i] = -1;
            } else {
                int a = heap.extractMax();
                int b = heap.extractMax();
                int c = heap.extractMax();
                B[i] = a*b*c;
                heap.insert(a);
                heap.insert(b);
                heap.insert(c);
            }
        }
        return B;
    }

    static class MaxHeap {

        private int[] heap;
        private int size;
        private int maxSize;

        public MaxHeap(int n) {
            this.heap = new int[n];
            this.size = 0;
            this.maxSize = n;
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

        public boolean isLeaf(int i) {
            return i >= size/2 && i < size;
        }

        public void insert(int num) {
            heap[size] = num;
            percolateUp();
            size++;
        }

        public void percolateUp() {
            int i = size;
            int p = parent(i);
            while (i > 0 && heap[i] > heap[p]) {
                int t = heap[i];
                heap[i] = heap[p];
                heap[p] = t;
                i = p;
                p = parent(i);
            }
        }

        public int extractMax() {
            int temp = heap[0];
            heap[0] = heap[size-1];
            heap[size-1] = temp;
            size--;
            percolateDown(0);
            return temp;
        }

        public void percolateDown(int i) {
            if (isLeaf(i)) {
                return;
            }
            int left = leftChild(i);
            int right = rightChild(i);
            int greater = i;
            if (left < size && heap[left] > heap[i]) {
                greater = left;
            }
            if (right < size && heap[right] > heap[greater]) {
                greater = right;
            }
            if (greater != i) {
                int t = heap[i];
                heap[i] = heap[greater];
                heap[greater] = t;
                percolateDown(greater);
            }
        }
    }
}
