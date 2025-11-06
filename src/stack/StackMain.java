package stack;

public class StackMain {

    public static void main(String[] args) {
        MyStackArray<Integer> s = new MyStackArray<>();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.peek());
        System.out.println(s.peek());
        System.out.println(s.pop());


        System.out.println(s);
    }
}
