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

    public static void main(String[] args) {
        System.out.println(findMaxRepeatCharacter("abaabcccda"));
        // frequencyArray(new int[]{1, 2, 3, 2, 1, 2, 2, 2, 1});
        String arr[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(arr));
    }
}
