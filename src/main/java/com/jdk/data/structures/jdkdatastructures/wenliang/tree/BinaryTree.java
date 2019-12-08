package com.jdk.data.structures.jdkdatastructures.wenliang.tree;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @author wenliang
 */
public abstract class BinaryTree<E> {


    protected int size;
    protected Node<E> root;


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
        root = null;
        size = 0;
    }


    /**
     * 前序遍历
     */
    public void preorderTraversal(){
        preorderTraversal(root);

    }

    private void preorderTraversal(Node<E> node){

        if (node == null) return;


        System.out.println(node.element);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }


    /***
     * 中序遍历
     */
    public void inorderTraversal(){
        inorderTraversal(root);
    }

    private void inorderTraversal(Node<E>  node){

        if (node == null) return;


        inorderTraversal(node.left);
        System.out.println(node.element);
        inorderTraversal(node.right);

    }


    /***
     * 中序遍历
     */
    public void postorderTraversal(){
        inorderTraversal(root);
    }

    private void postorderTraversal(Node<E>  node){

        if (node == null) return;


        inorderTraversal(node.left);
        inorderTraversal(node.right);
        System.out.println(node.element);

    }



    /**
     * 层序遍历
     */
    public void levelOrderTraversal(){

        if (root == null) return;


        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            System.out.println(node.element);

            if (node.left != null){
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }


    /**
     *
     * @param visitor
     */
    public void levelOrder(Visitor<E> visitor) {
        if (root == null || visitor == null) return;


        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            visitor.visit(node.element);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }


    public static interface Visitor<E> {
        void visit(E element);
    }



    /**
     *
     * @param visitor
     */
    public void preOrder(BinarySearchTree.Visitor<E> visitor){
        this.preOrder(visitor,root);

    }


    /**
     *
     * @param visitor
     *
     * @param node
     */
    private void preOrder(BinarySearchTree.Visitor<E> visitor, Node<E> node){

        visitor.visit(node.element);
        preOrder(visitor,node.left);
        preOrder(visitor,node.right);

    }




    public int height(){
        return height(root);
    }

    public int height(Node<E> node){

        return 1 + Math.max(height(node.left), height(node.right));
    }


    /**
     *
     * @param node
     *
     * @return
     */
    protected Node<E> predesessor(Node<E> node){
        if (node.left == null) return node;


        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }


        while (node.parent !=null && node== node.parent){
            node = node.parent;
        }

        return node.parent;

    }


    /**
     *
     * @param node
     *
     * @return
     */
    protected Node<E> successor(Node<E> node){
        if (node == null) return node;


        Node<E> p =node.right;
        if (p != null){
            while (p.left != null){
                p = p.left;
            }
            return p;
        }


        while (node.parent != null && node == node.parent.right){
            node = node.parent;
        }

        return node.parent;

    }



    /**
     *
     * @param <E>
     */
  protected static  class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;
        int height;

        public Node(E element, Node parent) {
            this.element = element;
            this.parent = parent;
        }


        public boolean isLeaf() {
            return left == null && right == null;
        }


        public boolean hasTwoChildren() {
            return left != null && right != null;
        }

    }
}
