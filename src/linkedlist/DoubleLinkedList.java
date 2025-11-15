package linkedlist;

public class DoubleLinkedList {

    class Node {
        Node next;
        Node prev;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head, tail;
    private int size;

    void add(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    void deleteNode(Node del) {
        if (head == null || del == null) {
            return;
        }
        if (head == del) {
            head = head.next;
        }
        if (del.next != null) {//Last
            del.next.prev = del.prev;
        }
        if (del.prev != null) {//First
            del.prev.next = del.next;
        }
    }

    void reverse() {
        Node temp = null;
        Node curr = head;
        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

}
