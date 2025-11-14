package queue;

public class MyQueue<T> {

    private T[] arr;
    private int front, rear, size;

    public MyQueue() {
        arr = (T[]) new Object[5];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void offer(T item) {
        if (size == arr.length) {
            resize();
        }
        rear = (rear + 1) % arr.length;
        arr[rear] = item;
        size++;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return arr[front];
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T item = arr[front];
        front = (front + 1) % arr.length;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize() {
        T[] newArray = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = arr[(front + i) % arr.length];
        }
        arr = newArray;
        front = 0;
        rear = size - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(arr[(front + i) % arr.length]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}