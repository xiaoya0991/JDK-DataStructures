package com.jdk.data.structures.jdkdatastructures.wenliang.tree;


/***
 *
 * @author wenliang
 * @param <E>
 */
public class BinarySearchTree <E> {


    /***
     *
     * @return
     */
    public int size(){
        return 0;
    }


    /**
     *
     * @return
     */
    public boolean isEmpty(){
        return false;
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
