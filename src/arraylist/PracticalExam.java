package arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class PracticalExam {

    static int sumOfLinkedList(LinkedList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    static int countRepetetion(ArrayList<Integer> a, ArrayList<Integer> b) {
        int count = 0;
        int indexA = 0;

        while (b.contains(a.get(0))) {
            for (int i = 0; i < b.size(); i++) {
                int num = b.get(i);
                if (num == a.get(indexA)) {
                    indexA++;
                    b.remove(i);
                    i--;
                    if (indexA == a.size()) {
                        count++;
                        indexA = 0;
                    }
                }
            }
        }
        return count;
    }

    static void findDiffrence(ArrayList<Integer> list) {
        int maxDiff = Integer.MIN_VALUE;
        int first = 0, second = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int diff = list.get(j) - list.get(i);
                if (diff > maxDiff) {
                    maxDiff = diff;
                    first = list.get(i);
                    second = list.get(j);
                }
            }
        }
        System.out.println("Diff = " + maxDiff);
        System.out.println(first + " " + second);
    }

    static int rotaionsForMaxEvenSqeuence(ArrayList<Integer> list) {
        int n = list.size();
        int bestRotate = 0;
        int maxEven = 0;
        for (int r = 0; r < n; r++) {
            list.add(0, list.remove(n - 1)); // rotate
            int currentMax = longestEven(list); //max even
            if (currentMax > maxEven) {
                maxEven = currentMax;
                bestRotate = r;
            }
        }
        return bestRotate;
    }

    static int longestEven(ArrayList<Integer> list) {
        int cEven = 0, maxEven = 0;
        for (int num : list) {
            if (num % 2 == 0) {
                cEven++;
                maxEven = Math.max(maxEven, cEven);
            } else {
                cEven = 0;
            }
        }
        return maxEven;
    }

    static void sort012(ArrayList<Integer> list) {
        int c0 = 0, c1 = 0, c2 = 0;
        for (int num : list) {
            if (num == 0) c0++;
            else if (num == 1) c1++;
            else c2++;
        }
        int index = 0;
        for (int i = 0; i < c0; i++) list.set(index++, 0);
        for (int i = 0; i < c1; i++) list.set(index++, 1);
        for (int i = 0; i < c2; i++) list.set(index++, 2);
    }

    static void addK(LinkedList<Integer> list, int k) {
        int carry = k;
        for (int i = list.size() - 1; i >= 0; i--) {
            int sum = carry + list.get(i);
            list.set(i, sum % 10);
            carry = sum / 10;
        }
        while (carry > 0) {
            list.addFirst(carry % 10);
            carry /= 10;
        }
    }


    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3));

        System.out.println(sumOfLinkedList(list));
    }
}
