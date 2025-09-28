package arraylist;

public class MyArrayList<T> {
    private T arr[];
    private int size;

    MyArrayList() {
        arr = (T[]) new Object[5];
        size = 0;
    }

    void add(T val) {
        if (size == arr.length) {
            resize();
        }
        arr[size++] = val;
    }


    void resize() {
        T temp[] = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    int size() {
        return size;
    }


    @Override
    public String toString() {
        String res = "[";
        for (int i = 0; i < size; i++) {
            res += arr[i];
            if (i != size - 1) {
                res += ", ";
            }
        }
        return res + "]";
    }

}
