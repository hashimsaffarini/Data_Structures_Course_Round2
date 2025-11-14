package queue;

import java.util.Arrays;

public class CircularQueue<T> {
    private T arr[];
    private int front, rear, size;

    CircularQueue(int size) {
        this.size = size;
        front = rear = -1;
        arr = (T[]) new Object[size];
    }

    void enqueue(T val) {
        if (!isFull()) {
            if (isEmpty()) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = val;
        } else {
            System.out.println("IS FULL");
        }
    }

    T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T val = arr[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return val;
    }

    boolean isEmpty() {
        return front == -1;
    }

    boolean isFull() {
        return (rear + 1) % size == front;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = front; ; i = (i + 1) % size) {
            s += arr[i];
            if (i == rear) break;
            s += ", ";
        }
        return s + "]";
    }
}
