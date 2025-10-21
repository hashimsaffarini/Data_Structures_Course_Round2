package linkedlist;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

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

    static Node middleOfLinkedList(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node removeDuplicates(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Node curr = head; curr != null; curr = curr.next) {
            if (!list.contains(curr.val)) {
                list.add(curr.val);
            }
        }
        Node dummy = new Node(0);
        Node tail = dummy;
        for (int val : list) {
            tail.next = new Node(val);
            tail = tail.next;
        }
        return dummy.next;
    }

    static Node rotateFromLeftToRight(Node head) {
        if (head == null) {
            return head;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        head = head.next;
        curr.next.next = null;
        return head;
    }

    static Node rotateFromRightToLeft(Node head) {
        if (head == null) return head;
        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next.next = head;
        head = curr.next;
        curr.next = null;
        return head;
    }

    static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    static Node removeFromNToM(Node head, int n, int m) {
        if (head == null) return head;
        Node curr = head, curr1 = null, curr2 = null;
        for (int i = 0; curr != null; i++) {
            if (i == n - 1) {
                curr1 = curr;
            }
            if (i == m) {
                curr2 = curr;
            }
            curr = curr.next;
        }
        if (curr1 != null && curr2 != null) {
            curr1.next = curr2.next;
        }
        return head;
    }

    public static boolean isSame(Node a, Node b) {
        Node headA = a, headB = b;

        while (headA != null && headB != null) {
            if (headA.val != headB.val) return false;
            headA = headA.next;
            headB = headB.next;
        }
        return headA == null && headB == null;
    }

    static Node findIntersection(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node tail = dummy;
        for (Node curr1 = head1; curr1 != null; curr1 = curr1.next) {
            for (Node curr2 = head2; curr2 != null; curr2 = curr2.next) {
                if (curr1.val == curr2.val && !exisit(dummy.next, curr1.val)) {
                    tail.next = new Node(curr1.val);
                    tail = tail.next;
                    break;
                }
            }
        }
        return dummy.next;
    }

    static boolean exisit(Node head, int val) {
        while (head != null) {
            if (head.val == val) return true;
            head = head.next;
        }
        return false;
    }


    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node mid = middleOfLinkedList(head);
        Node secondHalf = reverse(mid);
        Node firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    static Node removeDuplicatesWithoutDS(Node head) {
        for (Node i = head; i != null; i = i.next) {
            for (Node j = i; j.next != null; ) {
                if (i.val == j.next.val) {
                    j.next = j.next.next;
                } else {
                    j = j.next;
                }
            }
        }
        return head;
    }

    static Node insertSort(Node head, int val) {
        Node cur = head;
        Node newNode = new Node(val);
        if (head == null || head.val >= newNode.val) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        while (cur.next != null) {
            if (cur.next.val > newNode.val) {
                break;
            }
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        return head;
    }


    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(1, 2, 3,4);
        reverse(list.head);
        System.out.println(list);
    }
}
