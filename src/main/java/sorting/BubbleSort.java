package sorting;

public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {10, 5, 30, 15, 50, 6};
        bubbleSort.sort(arr);
        bubbleSort.print(arr);
    }

    void sort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n - i - 1; j ++) {
                if(arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
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
