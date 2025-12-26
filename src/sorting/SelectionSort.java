package sorting;
import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int arr[] = {2, 8, 1, 9, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}