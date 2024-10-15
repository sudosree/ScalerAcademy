package heap;

public class MaxHeap {

  private int[] maxHeap;
  private int size;
  private int maxSize;

  public MaxHeap(int maxSize) {
    this.maxSize = maxSize;
    this.maxHeap = new int[maxSize+1];
    this.size = 0;
    maxHeap[0] = 0;
  }

  public int parent(int i) {
    return i/2;
  }

  public int leftChild(int i) {
    return 2*i;
  }

  public int rightChild(int i) {
    return 2*i+1;
  }

  public boolean isLeaf(int i) {
    return i>size/2;
  }

  // TC - O(logn)
  public void add(int element) {
    if (size > maxSize) {
      System.out.println("Size is full");
      return;
    }
    size++;
    // insert element at the leaf
    maxHeap[size] = element;
    percolateUp(size);
  }

  private void percolateUp(int i) {
    int p = parent(i);
    // if the child node is greater than the parent node
    // then keep on swapping the child node with the parent node
    while (i > 1 && maxHeap[i] > maxHeap[p]) {
      int temp = maxHeap[i];
      maxHeap[i] = maxHeap[p];
      maxHeap[p] = temp;
      i = p;
      p = parent(i);
    }
  }

  public int pop() {
    if (size < 1) {
      System.out.println("Heap is empty");
      return Integer.MIN_VALUE;
    }
    int removeElement = maxHeap[1];
    maxHeap[1] = maxHeap[size];
    maxHeap[size] = removeElement;
    size--;
    percolateDown(1, size);
    return removeElement;
  }

  public int peek() {
    return maxHeap[1];
  }

  public int getSize() {
    return size;
  }

  private void percolateDown(int i, int size) {
    // check for non-leaf nodes
    while (i <= size/2) {
      int left = leftChild(i);
      int right = rightChild(i);
      int largest = i;
      if (left < size+1 && maxHeap[i] < maxHeap[left]) {
        largest = left;
      }
      if (right < size+1 && maxHeap[largest] < maxHeap[right]) {
        largest = right;
      }
      if (largest != i) {
        int temp = maxHeap[i];
        maxHeap[i] = maxHeap[largest];
        maxHeap[largest] = temp;
        i = largest;
      } else {
        break;
      }
    }
  }

  public static void main(String[] args) {
    MaxHeap maxHeap1 = new MaxHeap(5);
    maxHeap1.add(1);
    maxHeap1.add(2);
    maxHeap1.add(3);
    System.out.println("Size: " + maxHeap1.getSize());
    for (int i=1;i< maxHeap1.size+1;i++) {
      System.out.print(maxHeap1.maxHeap[i] + " ");
    }
    System.out.println("Peek: " + maxHeap1.peek());
    // 3
    System.out.println(maxHeap1.pop());
    System.out.println(maxHeap1.pop());
    System.out.println(maxHeap1.pop());
    System.out.println("Size: " + maxHeap1.getSize());
    maxHeap1.add(4);
    maxHeap1.add(5);
    System.out.println("Size: " + maxHeap1.getSize());
    for (int i=1;i< maxHeap1.size+1;i++) {
      System.out.print(maxHeap1.maxHeap[i] + " ");
    }
  }

}
