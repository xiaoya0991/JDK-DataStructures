package com.jdk.data.structures.jdkdatastructures.wenliang.tree;

public class BinarySearchTree <E>{


    private int size;

    /**
     * 跟节点
     */
    private Node<E> root;


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

    }




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

}
