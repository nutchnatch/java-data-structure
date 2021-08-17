package binaryheap;

import java.util.Queue;

public class BinaryHeap {
    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap(5);
        binaryHeap.peek();

        binaryHeap.insert(10, "Min");
        binaryHeap.insert(5, "Min");
        binaryHeap.insert(15, "Min");
        binaryHeap.insert(1, "Min");
        binaryHeap.levelOrder();
        binaryHeap.extractHead("Min");
        binaryHeap.levelOrder();
        binaryHeap.deleteTree();
    }

    int[] arr;
    int sizeOfTree;

    public BinaryHeap(int size) {
        arr = new int[size];
        this.sizeOfTree = 0;
        System.out.println("Binary heap has been created.");
    }

    private boolean isEmpty() {
        if(sizeOfTree == 0) {
            return true;
        }
        return false;
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Binary heap is empty");
            return -1;
        }
        return arr[1];
    }

    private int size() {
        return sizeOfTree;
    }

    private void levelOrder() {
        for(int i = 1; i <= sizeOfTree; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // heapify for isert
    public void heapifyBottomToTop(int index, String heapType) {
        int parent = index / 2;
        if(index <= 1) {
            return;
        }
        if(heapType.equals("Min")) {
            if(arr[index] < arr[parent]) {
                int tmp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = tmp;
            }
        } else if(heapType.equals("Max")) {
            if(arr[index] > arr[parent]) {
                int tmp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = tmp;
            }
        }
        heapifyBottomToTop(parent, heapType);
    }

    public void insert(int value, String heapType) {
        arr[sizeOfTree + 1] = value;
        sizeOfTree ++;
        heapifyBottomToTop(sizeOfTree, heapType);
        System.out.println("Value: " + value + " insert successfully in heap");
    }

    // heapifyTopToBottom
    private void heapefyTopToBotom(int index, String heapType) {
        int left = index * 2;
        int right = index * 2 + 1;
        int swapChild = 0;

        if(sizeOfTree < left) {
            return;
        }
        if(heapType.equals("Max")) {
            if(sizeOfTree == left) { // one child
                if(arr[index] < arr[left]) {
                    int tmp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = tmp;
                }
                return;
            } else if(arr[left] > arr[right]) {
                swapChild = left;
            } else {
                swapChild = right;
            }
            if(arr[index] < arr[swapChild]) {
                int tmp = arr[index];
                arr[index] = arr[swapChild];
                arr[swapChild] = tmp;
            }
        } else if(heapType.equals("Min")) {
            if(sizeOfTree == left) {
                if(arr[index] > arr[left]) {
                    int tmp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = tmp;
                }
                return;
            } else if(arr[left] < arr[right]) {
                swapChild = left;
            } else {
                swapChild = right;
            }
            if(arr[index] > arr[swapChild]) {
                int tmp = arr[index];
                arr[index] = arr[swapChild];
                arr[swapChild] = tmp;
            }
        }

        heapefyTopToBotom(swapChild, heapType);
    }

    public int extractHead(String heapType) {
        if(isEmpty()) {
            return -1;
        } else {
            int extractedValue = arr[1];
            arr[1] = arr[sizeOfTree];
            sizeOfTree --;
            heapefyTopToBotom(1, heapType);
            return extractedValue;
        }
    }

    public void deleteTree() {
        arr = null;
        System.out.println("Heap Tree successfully deleted!");
    }
}
