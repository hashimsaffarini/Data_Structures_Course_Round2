package recursion;

import linkedlist.Node;

public class LinkedListRecursion {

    static int length(Node head) {
        if (head == null) return 0;
        return 1 + length(head.next);
    }

    static void printReverse(Node head) {
        if (head == null) return;
        printReverse(head.next);
        System.out.print(head.val + " ");
    }

    static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public static void main(String[] args) {

    }
}
