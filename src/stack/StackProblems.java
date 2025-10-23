package stack;

import java.util.Stack;

public class StackProblems {
    static int sum(Stack<Integer> s) {
        Stack<Integer> b = new Stack<>();
        int sum = 0;
        while (!s.isEmpty()) {
            int x = s.pop();
            sum += x;
            b.push(x);
        }

        while (!b.isEmpty()) {
            s.push(b.pop());
        }
        return sum;
    }

    static boolean isContains(Stack<Integer> s, int val) {
        while (!s.isEmpty()) {
            if (s.pop() == val) return true;
        }
        return false;
    }

    static void swapBetweenTopAndBottom(Stack<Integer> a) {
        Stack<Integer> b = new Stack<>();
        int x = a.pop();
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
        int y = b.pop();
        a.push(x);
        while (!b.isEmpty()) {
            a.push(b.pop());
        }
        a.push(y);
    }

    static void rotateFromTopToBottom(Stack<Integer> a) {
        Stack<Integer> b = new Stack<>();
        int x = a.pop();
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
        a.push(x);
        while (!b.isEmpty()) {
            a.push(b.pop());
        }
    }

    static void rotateFromBottomToTop(Stack<Integer> a) {
        Stack<Integer> b = new Stack<>();
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
        int x = b.pop();
        while (!b.isEmpty()) {
            a.push(b.pop());
        }
        a.push(x);
    }

    static void addBottom(Stack<Integer> a, int val) {
        Stack<Integer> b = new Stack<>();
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
        a.push(val);
        while (!b.isEmpty()) {
            a.push(b.pop());
        }
    }

    static boolean checkParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;
                char last = stack.pop();
                if (ch == ')' && last != '(' || ch == '}' && last != '{' || ch == ']' && last != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);

        addBottom(s, -5);
        System.out.println(s);

    }
}
