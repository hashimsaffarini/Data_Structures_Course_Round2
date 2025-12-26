package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void Merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[low + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = low;
        while (n1 > i || n2 > j) {
            if (i < n1 && n2 > j) {
                if (leftArr[i] <= rightArr[j]) {
                    arr[k] = leftArr[i++];
                } else {
                    arr[k] = rightArr[j++];
                }
                k++;
            } else if (n1 > i) {
                arr[k++] = leftArr[i++];
            } else if (n2 > j) {
                arr[k++] = rightArr[j++];
            }
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            Merge(arr, low, mid, high);
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 8, 1, 9, 3, 4, 5};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}