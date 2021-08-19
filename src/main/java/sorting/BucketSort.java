package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class BucketSort {

    public static void main(String[] args) {
        int[] arr = {9, 7, 5, 4, 2, 1, 3, 6, 8};
        BucketSort bucketSort = new BucketSort(arr);
        bucketSort.print(arr);
        bucketSort.sort();
        bucketSort.print(arr);
    }

    int[] arr;

    public BucketSort(int[] arr) {
        this.arr = arr;
    }

    void sort() {
        int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        int maxValue = Integer.MIN_VALUE;
        for(int value: arr) {
            if(value > maxValue) {
                maxValue = value;
            }
        }

        List<Integer>[] buckets = new ArrayList[numberOfBuckets];
        for(int i = 0; i < buckets.length; i ++) {
            buckets[i] = new ArrayList<>();
        }

        for(int value: arr) {
            int bucketNumber = (int) Math.ceil(((float)value * numberOfBuckets) / (float)maxValue);
            buckets[bucketNumber - 1].add(value);
        }

        System.out.println("\n\nPrinting buckets before sorting...");
        printBuckets(buckets);

        for(List<Integer> bucket: buckets) {
            Collections.sort(bucket);
        }

        System.out.println("\n\nPrinting buckets after sorting...");
        printBuckets(buckets);

        int index = 0;
        for(List<Integer> bucket: buckets) {
            for(int value: bucket) {
                arr[index] =  value;
                index ++;
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

    // print buckets
    void printBuckets(List<Integer>[] buckets) {
        for(int i = 0; i < buckets.length; i ++) {
            System.out.println("Bucket#" + i + ":");
            for(int j = 0; j < buckets[i].size(); j ++) {
                System.out.print(buckets[i].get(j) + " ");
            }
            System.out.println();
        }
    }
}
