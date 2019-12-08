package com.jdk.data.structures.jdkdatastructures.wenliang.tree.avl;


import com.jdk.data.structures.jdkdatastructures.wenliang.tree.BST;
import com.jdk.data.structures.jdkdatastructures.wenliang.tree.Comparator;

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
        while ((node = node.parent) != null){

        }

    }


    @Override
    protected Node<E> createNode(E element,Node<E> parent){
        return new AVLNode<E>(element, parent);
    }



    private static class AVLNode<E> extends Node<E> {
        int height;
        public AVLNode(E element, Node parent) {
            super(element, parent);
        }


    }




}
