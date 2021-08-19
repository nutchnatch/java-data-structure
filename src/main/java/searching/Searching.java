package searching;

public class Searching {

    public static void main(String[] args) {
        Searching searching = new Searching();
        int[] arr = {8, 9, 12, 15, 17, 19, 20, 21, 28};
        searching.linearSearch(arr, 3);
        searching.binarySearch(arr, 21);
    }

    public int linearSearch(int[] arr, int value) {
        for(int i = 0; i < arr.length; i ++) {
            if(arr[i] == value) {
                System.out.println("Value " + value + " found in the array, at index " + i);
                return value;
            }
        }
        System.out.println("Value " + value + " NOT found in the array");
        return -1;
    }

    public int binarySearch(int[] arr, int value) {
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;
        while(arr[mid] != value && start <= end) {
            if(value < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        if(arr[mid] == value) {
            System.out.println("Value " + value + " found at index " + mid);
            return mid;
        } else {
            System.out.println("Value " + value + " not found");
            return -1;
        }
    }
}
