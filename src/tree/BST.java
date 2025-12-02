package tree;

public class BST {
    class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    Node root;

    Node add(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val > root.val) {
            root.right = add(root.right, val);
        } else if (val < root.val) {
            root.left = add(root.left, val);
        }
        return root;
    }

    void add(int val) {
        root = add(root, val);
    }

    int count(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

    int count() {
        return count(root);
    }

    int sumo(Node root) {
        if (root == null) return 0;
        return root.val + sumo(root.left) + sumo(root.right);
    }

    int sumo() {
        return sumo(root);
    }

    boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    int countLeaf(Node root) {
        if (root == null) return 0;
        else if (isLeaf(root)) {
            return 1;
        }
        return countLeaf(root.left) + countLeaf(root.right);
    }

    int countLeaf() {
        return countLeaf(root);
    }

    int maxo(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.val, Math.max(maxo(root.left), maxo(root.right)));
    }

    int maxo() {
        return maxo(root);
    }

    int maxBST(Node root) {
        Node curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr.val;
    }

    boolean searchBST(Node root, int key) {
        if (root == null) return false;
        if (root.val > key) {
            return searchBST(root.left, key);
        } else if (root.val < key) {
            return searchBST(root.right, key);
        }
        return true;
    }

    String print(Node root, String s) {
        if (root == null) {
            return s;
        }
        s = print(root.left, s);
        s += (root.val + " ");
        s = print(root.right, s);
        return s;
    }

    String print() {
        return print(root, "");
    }

}
