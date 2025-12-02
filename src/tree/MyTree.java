package tree;

public class MyTree {
    public static void main(String[] args) {
        BST t = new BST();
        t.add(10);
        t.add(20);
        t.add(40);
        t.add(5);
        t.add(1);

        System.out.println(t.print());
        System.out.println(t.count());
        System.out.println(t.sumo(t.root));
    }
}
