package sorting;

public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] arr = {10, 5, 30, 15, 50, 6};
        selectionSort.sort(arr);
        selectionSort.print(arr);
    }

    void sort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i ++) {
            int min = i;
            for(int j = i + 1; j < n; j ++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            if(min != i) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
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
