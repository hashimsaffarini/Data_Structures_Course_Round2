package arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListProblems {

    static void rotateFromLeftToRight(ArrayList<Integer> list) {
        list.add(list.remove(0));
    }

    static void rotateFromRightToLeft(ArrayList<Integer> list) {
        list.add(0, list.remove(list.size() - 1));
    }

    static void removeAllElements(ArrayList<Integer> list, int val) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == val) {
                list.remove(i);
                i--;
            }
        }
    }

    static void removeAllElements2(ArrayList<Integer> list, int val) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == val) {
                list.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 10, 10, 20, 10, 30, 70));
        removeAllElements2(list, 10);
        System.out.println(list);
    }
}
