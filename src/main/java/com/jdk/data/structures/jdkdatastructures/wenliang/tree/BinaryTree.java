package com.jdk.data.structures.jdkdatastructures.wenliang.tree;

/**
 * @author wenliang
 */
public class BinaryTree<E> {

    protected int size;
    protected Node<E> root;


    public int size(){
        return size;
    }


    public boolean isEmpty(){
        return size == 0;
    }


    public void clear(){
        root = null;
        size = 0;
    }



    protected static class Node<E>{
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;



        public Node(E element,Node<E> parent){
            this.element = element;
            this.parent = parent;
        }



        public boolean isLeaf(){
            return left == null && right == null;
        }



        public boolean hasTwoChildren(){
            return left != null && right != null;
        }

        public boolean isLeftChild(){
            return parent !=null && this == parent.left;
        }


        public boolean isRightChild(){
            return parent != null && this == parent.right;
        }


        public Node<E> sibling(){
            if (isLeftChild()){
                return parent.right;
            }

            if (isRightChild()){
                return parent.left;
            }

            return null;
        }
    }



}
