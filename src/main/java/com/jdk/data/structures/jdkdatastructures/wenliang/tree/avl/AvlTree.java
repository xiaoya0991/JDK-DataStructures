package com.jdk.data.structures.jdkdatastructures.wenliang.tree.avl;
import com.jdk.data.structures.jdkdatastructures.wenliang.tree.BST;
import com.jdk.data.structures.jdkdatastructures.wenliang.tree.Comparator;

/**
 * @author wenliang
 */
public class AvlTree<E> extends BST<E> {


    public AvlTree(){
        this(null);
    }

    public AvlTree(Comparator<E> comparator){
        super((Comparable<E>) comparator);
    }


    @Override
    protected void afterAdd(Node<E> node){
        while ((node = node.parent) != null){

        }

    }


    @Override
    protected Node<E> createNode(E element,Node<E> parent){
        return new AvlNode<E>(element, parent);
    }


    private static class AvlNode<E> extends Node<E> {
        int height;
        public AvlNode(E element, Node parent) {
            super(element, parent);
        }


        public int banlanceFactor(){

        }
    }




}
