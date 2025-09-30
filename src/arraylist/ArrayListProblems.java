package arraylist;

import java.lang.reflect.Array;
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

    static ArrayList<Integer> removeAllDuplicates(ArrayList<Integer> list) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int val : list) {
            if (!res.contains(val)) {
                res.add(val);
            }
        }
        return res;
    }

    static void removeAllDuplicates2(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    list.remove(j);
                    j--;
                }
            }
        }
    }

    static void removeAllDuplicates3(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.indexOf(list.get(i)) != i) {
                list.remove(i);
                i--;
            }
        }
    }

    static ArrayList<Integer> intersectionBetweenTwoList(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (b.contains(a.get(i)) && !res.contains(a.get(i))) {
                res.add(a.get(i));
            }
        }
        return res;
    }

    static void sortListEvenThenOdd(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (!isPrime(list.get(i))) {
                list.add(list.remove(i));
            }
        }
    }

    static boolean isPrime(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindrome(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 1, 4, 2, 5, 7, 8, 9));
        // 10,20,30,70
        sortListEvenThenOdd(list);
        System.out.println(list);
    }
}
