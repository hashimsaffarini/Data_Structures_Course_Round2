package linkedlist;

public class CircularLinkedList {

    static void printCircularLinkedList(Node head) {
        Node curr = head;
        do {
            System.out.print(curr.val + " ");
            curr = curr.next;
        } while (curr != head);
    }

    static Node convertSingleToCircular(Node head) {
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        return head;
    }

    static boolean isCircular(Node head) {
        if (head == null) {
            return true;
        }
        Node curr = head.next;
        while (curr != null && curr != head) {
            curr = curr.next;
        }
        return curr == head;
    }

    static boolean containsCircular(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.head = convertSingleToCircular(list.head);
        printCircularLinkedList(list.head);
    }
}
