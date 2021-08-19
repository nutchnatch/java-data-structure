package sorting;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] array = {10, 3, 2, 5 , 8, 4, 3, 1, 2, 9, 7, 8};
        mergeSort.mergeSort(array, 0, array.length - 1);
        mergeSort.print(array);
    }

    private void merge(int[] a, int left, int middle, int right) {
        int[] leftTmp = new int[middle - left + 2];
        int[] rightTmp = new int[right - middle + 2];

        for(int i = 0; i <= middle - left; i ++) {
            leftTmp[i] = a[left + i];
        }
        for(int i = 0; i < right - middle; i ++) {
            rightTmp[i] = a[middle + 1 + i];
        }
        leftTmp[middle - left + 1] = Integer.MAX_VALUE;
        rightTmp[right - middle] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for(int k = left; k <= right; k ++) {
            if(leftTmp[i] < rightTmp[j]) {
                a[k] = leftTmp[i];
                i++;
            } else {
                a[k] = rightTmp[j];
                j++;
            }
        }
    }

    public void mergeSort(int[] array, int left, int right) {
        if(right > left) {
            int m = left + (right - left) / 2;
            mergeSort(array, left, m);
            mergeSort(array, m + 1, right);
            merge(array, left, m, right);
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
