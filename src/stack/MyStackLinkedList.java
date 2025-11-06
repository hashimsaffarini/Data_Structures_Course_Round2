package stack;

import linkedlist.MyLinkedList;

import java.util.EmptyStackException;

public class MyStackLinkedList {
    private MyLinkedList list;

    MyStackLinkedList() {
        list = new MyLinkedList();
    }

    void push(int val) {
        list.add(val);
    }

    int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.remove(list.size() - 1);
    }

    int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.getLast();
    }

    int size() {
        return list.size();
    }

    boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
