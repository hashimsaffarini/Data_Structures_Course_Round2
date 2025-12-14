package recursion;

import java.util.Stack;

public class StackRecursion {

    static void printStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int x = s.pop();
        System.out.println(x);
        printStack(s);
        s.push(x);
    }

    static void addBottom(Stack<Integer> s, int val) {
        if (s.isEmpty()) {
            s.push(val);
            return;
        }
        int x = s.pop();
        addBottom(s, val);
        s.push(x);
    }

    static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) return;
        int y = s.pop();
        reverseStack(s);
        addBottom(s, y);
    }

    static void sortStack(Stack<Integer> s) {
        if (s.isEmpty()) return;
        int y = s.pop();
        sortStack(s);
        insertSorted(s, y);
    }

   static void insertSorted(Stack<Integer> s, int val) {
        if (s.isEmpty() || val >= s.peek()) {
            s.push(val);
            return;
        }
        int z = s.pop();
        insertSorted(s, val);
        s.push(z);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(2);
        s.push(10);
        s.push(1);
        s.push(7);

        System.out.println(s);
        sortStack(s);
        System.out.println(s);
    }
}
