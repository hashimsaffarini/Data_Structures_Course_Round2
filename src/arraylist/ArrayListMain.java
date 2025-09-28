package arraylist;

import java.util.ArrayList;

public class ArrayListMain {


    public static void main(String[] args) {
        MyArrayList<Integer> a = new MyArrayList<>();
        a.add(10, 20, 30, 40, 50);

        System.out.println(a);
    }


}
