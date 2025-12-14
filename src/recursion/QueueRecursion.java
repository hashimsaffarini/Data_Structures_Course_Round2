package recursion;

import java.util.LinkedList;
import java.util.Queue;

public class QueueRecursion {

    static void printQueue2(Queue<Integer> q) {
        if (q.isEmpty())
            return;

        int x = q.poll();
        System.out.print(x + " ");

        printQueue2(q);

        addFirstManual(q, x);
    }

    static void addFirstManual(Queue<Integer> q, int x) {
        if (q.isEmpty()) {
            q.add(x);
            return;
        }

        int temp = q.poll();
        addFirstManual(q, x);
        q.add(temp);
    }

    static void printQueue(Queue<Integer> q, int size) {
        if (size == 0) return;
        int x = q.poll();
        System.out.println(x);
        q.offer(x);
        printQueue(q, size - 1);
    }

    static void reverseQueue(Queue<Integer> q) {
        if (q.isEmpty()) return;
        int x = q.poll();
        reverseQueue(q);
        q.offer(x);
    }


    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        printQueue2(q);
        System.out.println(q);
    }
}
