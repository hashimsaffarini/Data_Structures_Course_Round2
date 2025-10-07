package arraylist;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    static void reverse(ArrayList<Integer> list) {
        int l = list.size() - 1;
        for (int i = 0; i < list.size() / 2; i++, l--) {
            int temp = list.get(i);
            list.set(i, list.get(l));
            list.set(l, temp);
        }
    }

    static void hlazone(ArrayList<Integer> list) {
        int l = list.size() - 1;
        for (int i = 0; i < list.size() / 2; i++, l--) {
            System.out.println(list.get(i));
            System.out.println(list.get(l));
        }

        if (list.size() % 2 == 1) {
            System.out.println(list.get(list.size() / 2));
        }
    }

    static void convertToCapital(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).charAt(list.get(i).length() - 1) == 's') {
                list.set(i, list.get(i).toUpperCase());
            }
        }
    }

    static void removeSubList(ArrayList<Integer> list, int start, int end) {
        for (int i = end; i >= start; i--) {
            list.remove(i);
        }
    }

    static void removeNElements(ArrayList<Integer> list, int start, int numberOfElement) {
        for (int i = 0; i < numberOfElement; i++) {
            list.remove(start);
        }
    }

    static void printArrays(ArrayList<int[]> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i)[1]; j++) {
                System.out.print(list.get(i)[0]);
            }

        }


    }

    static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> a = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    a.add(1);
                } else {
                    a.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(a);
        }
        return res;
    }

    static ArrayList<ArrayList<Integer>> divideList(ArrayList<Integer> a, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int c = 0;
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> b = new ArrayList<>();
            for (int j = 0; j < a.size() / k; j++) {
                b.add(a.get(c++));
            }
            res.add(b);
        }
        return res;
    }

    static Character maxCharacter(String s) {
        int freq[] = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int max = 0, index = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > max) {
                max = freq[i];
                index = i;
            }
        }
        return (char) (index + 'a');
    }

    static ArrayList<Character> getMaxFreq(ArrayList<String> list) {
        ArrayList<Character> res = new ArrayList<>();

        for (String val : list) {
            res.add(maxCharacter(val));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generatePascalTriangle(5));

    }
}
