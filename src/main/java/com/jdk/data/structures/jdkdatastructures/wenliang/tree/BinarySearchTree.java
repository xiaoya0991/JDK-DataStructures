package com.jdk.data.structures.jdkdatastructures.wenliang.tree;


/***
 *
 * @author wenliang
 * @param <E>
 */
public class BinarySearchTree <E> {

    private int size;


    /***
     *
     * @return
     */
    public int size(){
        return size;
    }


    /**
     *
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }


    /**
     *
     */
    public void clera(){

    }


    /**
     *
     * @param element
     */
    public void add(E element){

    }


    /***
     *
     */
    public void remove(){

    }


    /***
     *
     * @param element
     * @return
     */
    public boolean contains(E element){
        return false;
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
