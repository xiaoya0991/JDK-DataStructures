package com.jdk.data.structures.jdkdatastructures.wenliang.tree;



/**
 * @author wenliang
 */
public class AVLTree<E> extends BST<E> {



    public AVLTree(){
        this(null);
    }

    public AVLTree(Comparator<E> comparator){
        super((Comparable<E>) comparator);
    }





    @Override
    protected void afterAdd(Node<E> node){

    }




}
