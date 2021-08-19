package sorting;

import binaryheap.BinaryHeap;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {2, 7, 3, 1, 4, 8, 9};
        HeapSort heapSort = new HeapSort(arr);
        heapSort.sort();
        heapSort.print(arr);
    }

    int[] arr = null;

    public HeapSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        BinaryHeap binaryHeap = new BinaryHeap(arr.length + 1);
        for(int i = 0; i < arr.length; i ++) {
            binaryHeap.insert(arr[i], "Min");
        }

        for(int i = 0; i < arr.length; i ++) {
            arr[i] = binaryHeap.extractHead("Min");
        }
    }

    void print(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
