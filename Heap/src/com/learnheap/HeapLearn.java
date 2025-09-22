package com.learnheap;

import java.util.List;

public class HeapLearn {

    public static void main(String[] args) throws Exception {
        MinHeap<Integer> minHeap = new MinHeap<>();
        minHeap.insert(8);
        minHeap.insert(7);
        minHeap.insert(9);
        minHeap.insert(10);
        minHeap.insert(11);
        minHeap.insert(12);
        minHeap.insert(14);
        minHeap.insert(13);
        minHeap.insert(5);

        minHeap.print();

        System.out.println();

        List<Integer> data = minHeap.heapSort();
        System.out.println(data);

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.insert(5);
        maxHeap.insert(8);
        maxHeap.insert(9);
        maxHeap.insert(7);
        maxHeap.insert(11);
        maxHeap.insert(13);
        maxHeap.insert(2);
        maxHeap.insert(1);

        maxHeap.remove();
        maxHeap.print();
    }
}
