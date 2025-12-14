package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListRecursion {

    static boolean isPalindrome(ArrayList<Integer> list, int index) {
        if (list.size() / 2 <= index) {
            return true;
        }
        if (list.get(index) != list.get(list.size() - 1 - index)) {
            return false;
        }
        return isPalindrome(list, index + 1);
    }

    static int sumArray(ArrayList<Integer> list, int index) {
        if (list.size() == index) return 0;
        return list.get(index) + sumArray(list, index + 1);
    }

    static int maxArray(ArrayList<Integer> list, int index) {
        if (list.size() == index) return Integer.MIN_VALUE;
        return Math.max(list.get(index), maxArray(list, index + 1));
    }

    static boolean isFound(ArrayList<Integer> list, int index, int val) {
        if (list.size() == index) return false;
        if (list.get(index) == val) {
            return true;
        }
        return isFound(list, index + 1, val);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1));

        System.out.println(maxArray(list, 0));
    }
}
