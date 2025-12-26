package sorting;

import java.util.Arrays;


public class HeapSort {

    public static void swap(int[] arr, int i, int max) {
        int temp = arr[i];
        arr[i] = arr[max];
        arr[max] = temp;
    }

    public static void buildHeap(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[max]) {
            max = left;
        }
        if (right < n && arr[right] > arr[max]) {
            max = right;
        }
        if (max != i) {
            swap(arr, i, max);
            heapify(arr, n, max);
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 8, 1, 9, 3, 4, 5};
        int n = arr.length;
        buildHeap(arr, n);
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
        System.out.println(Arrays.toString(arr));
    }
}