package com.jdk.data.structures.jdkdatastructures.wenliang.tree;

/**
 * @author wenliang
 */
public class BST<E> {

    private Comparable<E> comparable;


    public BST(){
        this(null);
    }


    public BST(Comparable<E> comparable){
        this.comparable = comparable;
    }


    /***
     *
     * @param element
     */
    public void add(E element){
        elementNotNullCheck(element);

        //添加第一个节点


    }


    private void elementNotNullCheck(E element){
        if (element == null) throw new IllegalArgumentException("element must not be null");
    }



}
