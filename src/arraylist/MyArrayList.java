package arraylist;

public class MyArrayList<T> {
    private T arr[];
    private int size;

    MyArrayList() {
        arr = (T[]) new Object[5];
        size = 0;
    }

    MyArrayList(int capacity) {
        arr = (T[]) new Object[capacity];
        size = 0;
    }

    void add(T val) {
        if (isFull()) {
            resize(arr.length * 2);
        }
        arr[size++] = val;
    }

    void add(T... val) { // array

        for (int i = 0; i < val.length; i++) {
            add(val[i]);
        }
    }

    void add(int index, T val) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (isFull()) {
            resize(arr.length * 2);
        }
        shiftRight(index);
        arr[index] = val;
    }

    void shiftRight(int index) {
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        size++;
    }

    boolean remove(T val) {
        int index = indexOf(val);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    T remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        T oldValue = arr[index];
        shiftLeft(index);
        return oldValue;
    }

    void shiftLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        if (size > 0 && size == arr.length / 4) {
            resize(arr.length / 2);
        }
    }

    int indexOf(T val) {
        for (int i = 0; i < size; i++) {
            if (arr[i] != null && arr[i].equals(val)) {
                return i;
            }
        }
        return -1;
    }

    boolean isFull() {
        return size == arr.length;
    }

    boolean contains(T val) {
        return indexOf(val) != -1;
    }

    T set(int index, T val) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        T oldValue = arr[index];
        arr[index] = val;
        return oldValue;
    }

    T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return arr[index];
    }

    void addAll(MyArrayList<T> other) {
        for (int i = 0; i < other.size(); i++) {
            add(other.get(i));
        }
    }


    void resize(int newSize) {
        T temp[] = (T[]) new Object[newSize];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void clear() {
        size = 0;
        arr = (T[]) new Object[5];
    }

    MyArrayList<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        MyArrayList<T> sub = new MyArrayList<>(toIndex - fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            sub.add(arr[i]);
        }
        return sub;
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
