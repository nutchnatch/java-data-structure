package sorting;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = {10, 3, 2, 5 , 8, 4, 3, 1, 2, 9, 7, 8};
        quickSort.quickSort(array, 0, array.length - 1);
        quickSort.print(array);
    }

    private int partition(int[] array, int start, int end) {
        int pivot = end; //usually, it is a random number
        int i = start - 1;
        for(int j = start; j <= end; j ++) {
            if(array[j] <= array[pivot]) {
                i ++;
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        return i;
    }

    public void quickSort(int[] array, int start, int end) {
        if(start < end) {
            int pivot = partition(array, start, end);
            quickSort(array, start, pivot - 1);
            quickSort(array, pivot + 1, end);
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
