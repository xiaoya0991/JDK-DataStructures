package com.jdk.data.structures.jdkdatastructures.wenliang.tree;


public class BinarySearchTree <E> {



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
