package stack;

import java.util.EmptyStackException;

public class MyStackArray<T> {
    private T arr[];
    private int size;

    MyStackArray() {
        size = 0;
        arr = (T[]) new Object[5];
    }

    void push(T val) {
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

    T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[size - 1];
    }

    T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[--size];
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
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
