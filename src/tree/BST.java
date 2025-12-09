package tree;

import java.util.*;

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

    boolean isFull(Node root) {
        if (root == null) return true;
        if (isLeaf(root)) return true;
        if (root.left != null && root.right != null) {
            return isFull(root.left) && isFull(root.right);
        }
        return false; //One Child
    }

    boolean isComplete(Node root, int index, int count) {
        if (root == null) return true;
        if (index >= count) return false;
        return isComplete(root.left, index * 2 + 1, count) && isComplete(root.right, index * 2 + 2, count);
    }

    boolean isComplete() {
        return isComplete(root, 0, count());
    }

    boolean isPerfect(Node root, int depth, int level) {
        if (root == null) return true;
        if (isLeaf(root)) {
            return depth == level;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        return isPerfect(root.left, depth, level + 1) && isPerfect(root.right, depth, level + 1);
    }

    boolean isPerfect() {
        return isPerfect(root, depth(root), 1);
    }

    int depth(Node root) {
        int c = 0;
        for (Node curr = root; curr != null; curr = curr.left) {
            c++;
        }
        return c;
    }

    boolean detectDup(Node root, Set<Integer> set) {
        if (root == null) return false;
        if (set.contains(root.val)) return true;
        set.add(root.val);
        return detectDup(root.left, set) || detectDup(root.right, set);
    }

    boolean detectDup() {
        return detectDup(root, new HashSet<>());
    }

    boolean isSubtree(Node root, Node subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }


    String print() {
        return print(root, "");
    }

}
