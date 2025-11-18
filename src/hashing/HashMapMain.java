package hashing;

import java.util.HashMap;

public class HashMapMain {

    public static void main(String[] args) {
        HashMap<String, Integer> mp = new HashMap<>();
        mp.put("omar", 50);
        mp.put("ali", 30);
        mp.put("sara", 10);

        mp.put("omar", mp.get("omar") + 1);
        System.out.println();

    }
}
