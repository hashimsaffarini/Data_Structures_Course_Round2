package map;

import java.util.*;

public class HashMapProblems {

    static void frequencyCharacters(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (mp.get(ch) == null) {
                mp.put(ch, 1);
            } else {
                mp.put(ch, mp.get(ch) + 1);
            }
        }
        System.out.println(mp);
    }

    static void frequencyCharacters2(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (char ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        System.out.println(mp);
    }

    static void frequencyArray(int[] arr) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int element : arr) {
            mp.put(element, mp.getOrDefault(element, 0) + 1);
        }
        System.out.println(mp);
    }

    static Character findMaxRepeatCharacter(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        char maxCharacter = 'a';
        int max = 0;
        for (char ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        for (Character key : mp.keySet()) {
            if (mp.get(key) > max) {
                max = mp.get(key);
                maxCharacter = key;
            }
        }
        return maxCharacter;
    }

    static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int need = target - arr[i];
            if (mp.containsKey(need)) {
                return new int[]{mp.get(need), i};
            }
            mp.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    static List<List<String>> groupAnagrams(String[] arr) {
        HashMap<String, List<String>> mp = new HashMap<>();

        for (String val : arr) {
            char[] ch = val.toCharArray(); // eat
            Arrays.sort(ch); //a t e
            String sortedString = new String(ch); //ate
            if (!mp.containsKey(sortedString)) {
                mp.put(sortedString, new ArrayList<>());
            }
            mp.get(sortedString).add(val);
        }
        return new ArrayList<>(mp.values());
    }

    static List<Integer> getRepeatedSorted(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        HashSet<Integer> used = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int x : arr) {
            if (freq.get(x) > 1 && !used.contains(x)) {
                used.add(x);
                res.add(x);
            }
        }
        for (int i = 0; i < res.size() - 1; i++) {
            for (int j = 0; j < res.size() - 1 - i; j++) {
                int a = res.get(j);
                int b = res.get(j + 1);
                if (freq.get(a) < freq.get(b)) {
                    int temp = res.get(j);
                    res.set(j, res.get(j + 1));
                    res.set(j + 1, temp);
                }
            }
        }
        return res;
    }

    static int minRepeatingIndex(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (mp.containsKey(arr[i])) {
                minIndex = Math.min(minIndex, mp.get(arr[i]));
            } else {
                mp.put(arr[i], i);
            }
        }
        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }

    static int majElements(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = arr.length;
        for (int x : arr) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
            if (mp.get(x) > n / 2) {
                return x;
            }
        }
        return -1;
    }

    void symmetricPairs(int[][] pairs) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int[] p : pairs) { // [3,4]
            if (mp.containsKey(p[1]) && mp.get(p[1]) == p[0]) {
                System.out.println(p[1] + " : " + p[0]);
            }
            mp.put(p[0], p[1]);
        }
    }

    static void subarraySum(int[] arr, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        mp.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (mp.containsKey(sum - target)) {
                System.out.println("From Index " + (mp.get(sum - target) + 1) + "To Index " + i);
            }
            mp.put(sum, i);
        }
    }

    void countDistinct(int arr[], int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int x = arr[i];
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        System.out.print(mp.size() + " ");
        for (int i = k; i < arr.length; i++) {
            int out = arr[i - k];
            mp.put(out, mp.get(out) - 1);
            if (mp.get(out) == 0) {
                mp.remove(out);
            }
            int in = arr[i];
            mp.put(in, mp.getOrDefault(in, 0) + 1);
            System.out.print(mp.size() + " ");
        }
    }

    static Integer[] sortByFreqAndIndex(int arr[]) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            if (!firstIndex.containsKey(arr[i])) {
                firstIndex.put(arr[i], i);
            }
        }

        Integer[] temp = new Integer[arr.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[i];
        }
        for (int i = 0; i < temp.length - 1; i++) {
            for (int j = i + 1; j < temp.length; j++) {//selection sort
                int fi = freq.get(temp[i]);
                int fj = freq.get(temp[j]);
                if (fi < fj || (fi == fj && firstIndex.get(temp[i]) > firstIndex.get(temp[j]))) {
                    int swap = temp[i];
                    temp[i] = temp[j];
                    temp[j] = swap;
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int arr[] = {1, 8, 8, 1, 1, 8, 6, 7};
        System.out.println(Arrays.toString(sortByFreqAndIndex(arr)));
    }
}
