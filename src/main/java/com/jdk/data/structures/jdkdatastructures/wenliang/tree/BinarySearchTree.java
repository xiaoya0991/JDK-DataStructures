package com.jdk.data.structures.jdkdatastructures.wenliang.tree;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/***
 *
 * @author wenliang
 *
 * @param <E>
 */
public class BinarySearchTree <E> {

    private int size;
    private Node<E> root;
    private Comparator<E> comparator;




    public BinarySearchTree(){
        this(null);
    }


    public BinarySearchTree(Comparator<E> comparator){
        this.comparator = comparator;
    }


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
    public void levelOrder(Visitor<E> visitor){
        if (root == null || visitor == null) return;


        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
           visitor.visit(node.element);

            if (node.left != null){
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

    }


    public void preOrder(Visitor<E> visitor){
        this.preOrder(visitor,root);

    }

    private void preOrder(Visitor<E> visitor,Node<E> node){

        visitor.visit(node.element);
        preOrder(visitor,node.left);
        preOrder(visitor,node.right);

    }


    public boolean isComplete(){

        if (root == null) return false;


        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);


        boolean leaf = false;
        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            if (leaf && !node.isLeaf()) return false;


            if (node.hasTwoChildren()){
                queue.offer(node.left);
                queue.offer(node.right);
            }else if (node.left == null && node.right != null){
                return false;
            }else {
                leaf = true;

            }
        }

        return true;
    }


    public static interface Visitor<E> {
        void visit(E element);
    }


    public int height(){
        return height(root);
    }

    private int height(Node<E> node){

        return 1 + Math.max(height(node.left), height(node.right));
    }



    /**
     *add is element
     *
     * @param element
     */
    public void add(E element){

        elementNotNullCheck(element);


        if (root==null){
            root = new Node<>(element, null);
            size++;
            return;
        }

        //添加的不是第一个节点
        //找到父节点
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;
        while (node != null){
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0){
                node = node.right;
            }else if (cmp < 0){
                node = node.left;
            }else {
                node.element = element;
                return;
            }
        }


        Node<E> newNode = new Node<>(element, parent);
        if (cmp >0){
            parent.right = newNode;

        }else {
            parent.left = newNode;

        }
        size++;

    }


    /**
     *
     * @param node
     *
     * @return
     */
    private Node<E> predesessor(Node<E> node){
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
    private Node<E> successor(Node<E> node){
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



    /***
     * 比较器
     * @param e1
     *
     * @param e2
     *
     * @return
     */
    private int compare(E e1, E e2) {

        if (this.comparator != null){
            return comparator.compare(e1, e2);
        }

        return ((Comparable<E>) e1).compareTo(e2);
    }


    /***
     * remove is a node
     * @param element
     */
    public void remove(E element){
        Node<E> node = node(element);
        if (node == null) return;

        remove(node);


    }


    private void remove(Node<E> node){
        if (node == null) return;

        size++;

        //度为2的节点
        if (node.hasTwoChildren()){

            //找到后继节点
            Node<E> s = successor(node);

            //用后继节点的值覆盖度为2的节点的值
            node.element = s.element;

            //删除后继节点
            node = s;

        }



        Node<E> replacement = node.left != null ? node.left : node.right;

        if (replacement != null){

            //更改parent
            replacement.parent = node.parent;

            if (node.parent == null){
                root = replacement;
            } else if (node == node.parent.left){
                node.parent.left = replacement;

            }else if (node == node.parent.right){
                node.parent.right = replacement;
            }


            //node是叶子节点或者是根节点
        }else if (node.parent == null){
            root =  null;

        }else {
            if (node == node.parent.right){
                node.parent.right = null;

            }else {
                node.parent.left = null;
            }

        }

    }



    /**
     *
     * @param element
     *
     * @return
     */
    private Node<E> node(E element){
        Node<E> node = root;
        while (node != null){
            int cmp = compare(element, node.element);
            if (cmp == 0) return node;

            if (cmp > 0){
                node = node.right;

            }else {
                node = node.left;

            }
            return node;
        }

        return null;
    }


    /***
     *
     * @param element
     */
    private void elementNotNullCheck(E element){

        if (element == null){
            throw new IllegalArgumentException("element must not be null");
        }
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


        public boolean isLeaf(){
            return left == null && right == null;
        }


        public boolean hasTwoChildren(){
            return left != null && right != null;
        }

    }



}
