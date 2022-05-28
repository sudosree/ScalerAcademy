package heap.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> smallHeap;
    private PriorityQueue<Integer> largeHeap;

    public MedianFinder() {
        // max heap contains all the smaller elements
        smallHeap = new PriorityQueue<>(Comparator.reverseOrder());
        // min heap contains all the larger elements
        largeHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // everytime inserts element into the small heap
        smallHeap.offer(num);
        // if the top element in the small heap is greater than the
        // top element of the large heap then you need to remove the 
        // element from the small heap and add it to the large heap
        if (largeHeap.size() > 0 && smallHeap.peek() > largeHeap.peek()) {
            largeHeap.offer(smallHeap.poll());
        }
        // if the small heap contains 2 or more elements than remove the element
        // from the small heap and add it to the large heap
        if (smallHeap.size() > largeHeap.size() + 1) {
            largeHeap.offer(smallHeap.poll());
        }
        // if the large heap contains 2 or more elements than remove the element
        // from the large heap and add it to the small heap
        else if (largeHeap.size() > smallHeap.size() + 1) {
            smallHeap.offer(largeHeap.poll());
        }
    }

    public double findMedian() {
        // even no. of elements
        if (smallHeap.size() == largeHeap.size()) {
            return (smallHeap.peek() + largeHeap.peek()) / 2.0;
        }
        // odd no. of elements
        else {
            return smallHeap.size() > largeHeap.size() ? smallHeap.peek() : largeHeap.peek();
        }
    }
}