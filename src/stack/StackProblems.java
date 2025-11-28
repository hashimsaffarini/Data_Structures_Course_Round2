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

    static void sortStack(Stack<Integer> s) {
        Stack<Integer> t = new Stack<>();
        while (!s.isEmpty()) {
            int temp = s.pop();
            while (!t.isEmpty() && temp > t.peek()) {
                s.push(t.pop());
            }
            t.push(temp);
        }
        while (!t.isEmpty()) {
            s.push(t.pop());
        }
    }

    static boolean isPalindrome(Stack<Integer> s) {
        Stack<Integer> b = new Stack<>();
        int size = s.size();
        for (int i = 0; i < size / 2; i++) {
            b.push(s.pop());
        }
        if (size % 2 == 1) {
            s.pop();
        }
        while (!s.isEmpty()) {
            if (b.pop() != s.pop()) return false;
        }
        return true;
    }

    static void nextGreaterElement(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int[] nge = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
                int index = s.pop();
                nge[index] = arr[i];
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            nge[s.pop()] = -1;
        }

        for (int val : nge) {
            System.out.print(val + " ");
        }
    }

    static String removeAdj(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && st.peek() == ch) {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        String res = "";
        while (!st.isEmpty()) {
            res += st.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 2, 25};
        nextGreaterElement(arr);

        double x = 5;
        System.out.println(x / 2);

    }
}