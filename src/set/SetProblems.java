package set;

import java.util.Arrays;
import java.util.HashSet;

public class SetProblems {

    static int[] uniqeValues(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int val : arr) {
            set.add(val);
        }

        int res[] = new int[set.size()];
        int index = 0;
        for (int val : set) {
            res[index++] = val;
        }
        return res;
    }

    static boolean hasDuplicates(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        // [1,2,3,1]
        for (int val : arr) {
            if (!set.add(val)) return true;
        }
        return false;
    }

    static int[] singleNumber(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int val : arr) {
            if (set.contains(val)) {
                set.remove(val);
            } else {
                set.add(val);
            }
        }
        int res[] = new int[set.size()];
        int index = 0;
        for (int val : set) {
            res[index++] = val;
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 1, 2, 3, 3};
        System.out.println(Arrays.toString(uniqeValues(arr)));
    }
}
