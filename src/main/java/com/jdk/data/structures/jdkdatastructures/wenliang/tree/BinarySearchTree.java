package com.jdk.data.structures.jdkdatastructures.wenliang.tree;
import java.util.Comparator;

/***
 *
 * @author wenliang
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
     *
     */
    public void remove(){

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

    }



}
