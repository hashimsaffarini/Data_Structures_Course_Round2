package linkedlist;

public class MyLinkedList {
    Node head, tail;
    int size;

    MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    void add(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    void addFirst(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    @Override
    public String toString() {
        String s = "[";
        Node curr = head;
        while (curr != null) {
            s += curr.val;
            if (curr != tail) {
                s += ", ";
            }
            curr = curr.next;
        }
        return s + "]";
    }
}
