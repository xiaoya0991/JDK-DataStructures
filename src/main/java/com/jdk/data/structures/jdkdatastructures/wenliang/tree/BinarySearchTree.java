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
public class BinarySearchTree <E>  extends BinaryTree{

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
    @Override
    public int size(){
        return size;
    }


    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty(){
        return size==0;
    }


    /**
     *
     */
    @Override
    public void clera(){
        root = null;
        size = 0;
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
     *
     * @return
     */
    public boolean contains(E element){
        return node(element) != null;
    }







}
