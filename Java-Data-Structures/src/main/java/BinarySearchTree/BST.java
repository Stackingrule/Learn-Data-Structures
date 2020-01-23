package BinarySearchTree;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class BST<E extends Comparable<E>> {

    private class Node {
        E val;
        public Node left;
        public Node right;

        public Node(E val) {
            this.val = val;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E val) {

        root = add(root, val);

    }

    /**

    private void add(Node node, E val) {

        // 终止条件
        if (val.equals(node.val))
            return;
        else if (val.compareTo(node.val) < 0 && node.left == null) {
            node.left = new Node(val);
            size++;
            return;
        }
        else if (val.compareTo(node.val) > 0 && node.right == null) {
            node.right = new Node(val);
            size++;
            return;
        }

        if (val.compareTo(node.val) < 0) {
            add(node.left, val);
        }
        else {
            add(node.right, val);
        }
    }
     */

    private Node add(Node node, E val) {

        if (node == null) {
            size++;
            return new Node(val);
        }

        if (val.compareTo(node.val) < 0) {
            node.left = add(node.left, val);
        }
        else if (val.compareTo(node.val) > 0) {
            node.right = add(node.right, val);
        }

        return node;
    }


    public boolean contains(E val) {
        return contains(root, val);

    }

    private boolean contains(Node node, E val) {

        if (node == null)
            return false;

        if (val.compareTo(node.val) == 0) {
            return true;
        }
        else if (val.compareTo(node.val) < 0) {
            return contains(node.left, val);
        }
        else {
            return contains(node.right, val);
        }
    }

    public void levelOrder() {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.val);

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }


}
