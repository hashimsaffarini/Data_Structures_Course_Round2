package recursion;

import java.util.LinkedList;
import java.util.Queue;

public class QueueRecursion {

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
        q.add(40);
        q.add(50);
        q.add(60);
        System.out.println(q);
    }
}
