package com.jdk.data.structures.jdkdatastructures.shengjie.tree;

/**
 * 二叉搜索树
 */
public class BinarySearchTree<E extends Comparable<E>>{
    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree(){
        this.root = null;
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
