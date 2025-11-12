package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueProblems {
    static void rotateFromLeftToRight(Queue<Integer> q, int n) {
        int size = q.size();
        for (int i = 0; i < n % size; i++) {
            q.offer(q.poll());
        }
    }

    static void rotateFromRightToLeft(Queue<Integer> q, int n) {
        int size = q.size();
        for (int i = 0; i < size - n % size; i++) {
            q.offer(q.poll());
        }
    }

    static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.poll());
        }
        while (!s.isEmpty()) {
            q.offer(s.pop());
        }
    }

    static int minValueFrom90(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(9);
        while (true) {
            int val = q.poll();
            if (val % n == 0) {
                return val;
            }
            q.offer(val * 10);
            q.offer(val * 10 + 9);
        }
    }

    static void binaryGenerator(int n) {
        Queue<String> q = new LinkedList<>();
        q.offer("1");
        for (int i = 0; i < n; i++) {
            String val = q.poll();
            System.out.print(val + " ");
            q.offer(val + "0");
            q.offer(val + "1");
        }
    }

    public static void main(String[] args) {
        System.out.println(minValueFrom90(8));
    }
}
