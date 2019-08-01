package com.jdk.data.structures.jdkdatastructures.wenliang.tree;

import com.jdk.data.structures.jdkdatastructures.wenliang.tree.printer.BinaryTreeInfo;

public class BinarySearchTree <E> implements BinaryTreeInfo {


    private int size;

    /**
     * 跟节点
     */
    private Node<E> root;

    private Comparable<E> comparator;


    public BinarySearchTree(){
        this(null);
    }


    public BinarySearchTree(Comparable<E> comparator){
        this.comparator = comparator;

    }


    /***
     *
     * @param element
     */
    public void add(E element){
        this.elementNotNullCheck(element);

        if (this.root == null) {
            this.root = new Node<>(element, null);
            this.size++;
            return;
        }
        Node<E> parent = this.root;
        Node<E> node = this.root;
        int cmp = 0;
        do {

            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;

            } else if (cmp < 0) {
                node = node.left;
            } else { //相等
                return;
            }

        } while (node != null);

        Node<E> newNode = (Node<E>) new Node<E>(element, parent);
        if (cmp > 0){
            parent.right = newNode;

        }else {
            parent.left = newNode;
        }
        this.size++;

    }






    /***
     *
     * @param e1
     * @param e2
     * @return
     */
    private int compare(E e1, E e2) {
        if (this.comparator != null)
            return this.compare(e1, e2);
        return ((Comparable<E>) e1).compareTo(e2);
    }


    /***
     *
     * @param element
     */
    private void elementNotNullCheck(E element){
        if (element == null){
            throw new IllegalArgumentException("element must not be null");
        }
        return;
    }


    /**
     *
     * @param <E>
     */
    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element,Node parent){
            this.element = element;
            this.parent = parent;
        }

    }


    /**
     *
     * @return
     */
    @Override
    public Object root() {
        return this.root;
    }


    /***
     *
     * @param node
     * @return
     */
    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }


    /***
     *
     * @param node
     * @return
     */
    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }


    /***
     *
     * @param node
     * @return
     */
    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>)node;
        String parentString = "null";
        if (myNode.parent != null) {
            parentString = myNode.parent.element.toString();
        }
        return myNode.element + "_p(" + parentString + ")";
    }

}
