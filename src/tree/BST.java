package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.val == key) {
            return true;
        }
        return search(root.left, key) || search(root.right, key);
    }

    boolean search(int key) {
        return search(root, key);
    }

    boolean isSymmetric(Node root) {
        return isMirror(root.left, root.right);
    }

    boolean isMirror(Node a, Node b) {
        if (a == null || b == null) {
            return a == b;
        }
        if (a.val != b.val) {
            return false;
        }
        return isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }

    boolean isSameTree(Node a, Node b) {
        if (a == null || b == null) {
            return a == b;
        }
        if (a.val != b.val) {
            return false;
        }
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                list.add(curr.val);
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    List<Integer> rightView(Node root) {
        List<Integer> res = new ArrayList<>();
        rightViewHelper(root, 0, res);
        return res;
    }

    void rightViewHelper(Node root, int level, List<Integer> res) {
        if (root == null) return;
        if (level == res.size()) {
            res.add(root.val);
        }
        rightViewHelper(root.right, level + 1, res);
        rightViewHelper(root.left, level + 1, res);
    }

    boolean hasPathSum(Node root, int sum) {
        if (root == null) return false;
        else if (isLeaf(root) && sum - root.val == 0) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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
