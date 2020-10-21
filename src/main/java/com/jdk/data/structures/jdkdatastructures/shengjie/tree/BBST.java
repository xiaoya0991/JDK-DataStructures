package com.jdk.data.structures.jdkdatastructures.shengjie.tree;

import java.util.Comparator;

/**
 * @author gongshengjie
 * @Date 2020-09-30 10:32
 */
public class BBST<E> extends BST<E>{
    public BBST(){
        this(null);
    }

    public BBST(Comparator<E> comparator){
        super(comparator);
    }

    protected void rotateLeft(Node<E> grand){
        Node<E> parent = grand.right;
        Node<E> child = parent.left;
        grand.right = child;
        parent.left = grand;
        afterRotate(grand, parent, child);
    }

    protected void rotateRight(Node<E> grand){
        Node<E> parent = grand.left;
        Node<E> child = parent.right;
        grand.left = child;
        parent.right = grand;
        afterRotate(grand, parent, child);
    }

    protected void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
        //让parent成为子树的跟节点
        parent.parent = grand.parent;
        if(grand.isLeftChild()){
            grand.parent.left = parent;
        } else if(grand.isRightChild()){
            grand.parent.right = parent;
        } else {
            root = parent;
        }

        //更新child的parent
        if(child != null){
            child.parent = grand;
        }

        //更新grand的parent
        grand.parent = parent;
    }
}
