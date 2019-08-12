package com.jdk.data.structures.jdkdatastructures.yining.tree;

/**
 * 二分查找树
 *
 * @author: huyining
 * @since: 2019-08-12
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {

        public E e;

        public Node left;

        public Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加节点
     *
     * @param e
     */
    public void add(E e) {
        if (root == null) {
            this.root = new Node(e);
            size++;
        } else {
            add(root, e);
        }

    }


    /**
     * 二分查找树添加节点
     *
     * @param node
     * @param e
     */
    private void add(Node node, E e) {
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }

    /**
     * 判断是否包含莫个节点
     *
     * @param e
     * @return
     */
    private boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 判断是否包含莫个元素
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }
}
