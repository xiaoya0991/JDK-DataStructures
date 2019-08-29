package com.jdk.data.structures.jdkdatastructures.wenliang.tree;

import java.util.LinkedList;
import java.util.Queue;

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




    public void preorder(Visitor<E> visitor){
        if (visitor == null) return;
        this.preorder(root, visitor);
    }


    private void preorder(Node<E> node,Visitor<E> visitor){
        if (node == null || visitor.stop) return;

        visitor.stop  =visitor.visit(node.element);
        preorder(node.left,visitor);
        preorder(node,visitor);
    }


    public void inorder(Visitor<E> visitor){
        if (visitor == null) return;

        inorder(root, visitor);
    }

    private void inorder(Node<E> node,Visitor visitor){
        if (node == null || visitor.stop) return;

        inorder(node.left,visitor);
        if (visitor.stop) return;
       visitor.stop =  visitor.visit(node.element);
       inorder(node.right,visitor);
    }


    public void postorder(Visitor<E> visitor){
        if (visitor==null) return;
        this.postorder(root, visitor);
    }


    private void postorder(Node<E> node,Visitor<E> visitor){
        postorder(node.left,visitor);
        postorder(node.right,visitor);
        if (visitor.stop) return;

        visitor.stop = visitor.visit(node.element);
    }


    public void leveOrder(Visitor<E> visitor){
        if (root == null || visitor == null) return;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            if (visitor.visit(node.element)) return;

            if (node.left !=null){
                queue.offer(node.left);
            }
            if (node.right !=null){
                queue.offer(node.right);
            }
        }
    }


    /**
     *
     * @return
     */
    public boolean isComplete(){
        if (root == null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        boolean leaf = false;
        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            if (leaf && !node.isLeaf()) return false;

            if (node.left !=null){
                queue.offer(node.left);

            }else if (node.right !=null){
                return false;
            }

            if (node.right != null){
                queue.offer(node.right);
            }

            leaf = true;
        }

        return true;
    }


    /***
     *
     * @return
     */
    public int hetght(){
        if (root == null) return 0;

        int height = 0;

        int levelSize = 1;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            levelSize--;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right !=null) {
                queue.offer(node.right);
            }

            if (levelSize == 0 ){
                levelSize = queue.size();
                height++;
            }

        }
        return height;

    }


    protected Node<E> createNode(E element,Node<E> parent){
        return new Node<>(element, parent);
    }




    public static abstract class Visitor<E> {
        boolean stop;


        /**
         *
         * @param element
         * @return
         */
       public abstract boolean visit(E element);
    }


    /***
     *
     * @param node
     * @return
     */
    protected Node preecessor(Node<E> node){
        if (node == null) return null;

        Node<E> p = node.left;
        if (p != null ){
            while (p.left != null){
                p = p.right;
            }
            return p;
        }

        while (node.parent !=null && node == node.parent.left ) {
            node = node.parent;
        }

        return node.parent;
    }


    /***
     *
     * @param node
     * @return
     */
    protected Node<E> successor(Node<E> node) {
        if (node == null) return null;

        Node<E> p = node.right;
        if (p != null ){
            while (p.left !=null){
                p = p.left;

            }
            return p;
        }

        while (node.parent !=null && node == node.parent.right){
            node = node.parent;
        }

        return node.parent;

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
