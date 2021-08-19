package sorting;

public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] arr = {10, 5, 30, 15, 50, 6};
        insertionSort.sort(arr);
        insertionSort.print(arr);
    }

    void sort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i ++) {
            int tmp = arr[i], j = i;
            while(j > 0 && arr[j - 1] > tmp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
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
