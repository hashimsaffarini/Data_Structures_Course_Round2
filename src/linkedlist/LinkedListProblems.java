package linkedlist;

public class LinkedListProblems {

    static int sumo(Node head) {
        int sum = 0;
        Node curr = head;
        while (curr != null) {
            sum += curr.val;
            curr = curr.next;
        }
        return sum;
    }

    static boolean isSortedLinkedList(Node head) {
        for (Node curr = head; curr.next != null; curr = curr.next) {
            if (curr.val > curr.next.val) {
                return false;
            }
        }
        return true;
    }

    static boolean isSortedAnyWay(Node head) {
        boolean f1 = true, f2 = true;
        for (Node curr = head; curr.next != null; curr = curr.next) {
            if (!f1 && !f2) return false;
            if (curr.val > curr.next.val) {
                f1 = false;
            } else if (curr.val < curr.next.val) {
                f2 = false;
            }
        }
        return f1 || f2;
    }

    static int middleOfLinkedList(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }


    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(10, 20, 30, 40, 50, 60);
        System.out.println(middleOfLinkedList(list.head));
    }
}
