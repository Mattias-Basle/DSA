package algorithms.sorting;

import dataStructures.Trees.Heap;

import java.util.ArrayList;

public class HeapSort {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();

        heap.insert(34);
        heap.insert(45);
        heap.insert(22);
        heap.insert(89);
        heap.insert(76);

        ArrayList list1 = heap.heapSort();

        System.out.println(list1);
    }
}
