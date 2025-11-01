package linkedlist;

public class MyLinkedList {
    Node head, tail;
    private int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    void add(int... val) {
        for (int i = 0; i < val.length; i++) {
            add(val[i]);
        }
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

    void add(int index, int val) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(val);
        } else if (index == size) {
            add(val);
        } else {
            Node newNode = new Node(val);
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
            size++;
        }
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

    int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return removeFirst();
        }
        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        int oldValue = curr.next.val;
        if (index == size - 1) {
            tail = curr;
        }
        curr.next = curr.next.next;
        size--;
        return oldValue;
    }

    int removeFirst() {
        if (head == null) {
            throw new NullPointerException();
        }
        int oldValue = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return oldValue;
    }

    int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    int indexOf(int val) {
        Node curr = head;
        for (int i = 0; i < size; i++) {
            if (curr.val == val) {
                return i;
            }
            curr = curr.next;
        }
        return -1;
    }

    boolean contains(int val) {
        for (Node curr = head; curr != null; curr = curr.next) {
            if (curr.val == val) return true;
        }
        return false;
    }

    int getFirst() {
        if (head == null) {
            throw new NullPointerException();
        }
        return head.val;
    }

    int getLast() {
        if (tail == null) {
            throw new NullPointerException();
        }
        return tail.val;
    }

    int size() {
        return size;
    }

    @Override
    public String toString() {
        String s = "[";
        Node curr = head;
        while (curr != null) {
            s += curr.val;
            if (curr.next != null) {
                s += ", ";
            }
            curr = curr.next;
        }
        return s + "]";
    }
}
