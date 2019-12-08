package com.jdk.data.structures.jdkdatastructures.wenliang.tree;

/**
 * @author wenliang
 */
public class BST<E> extends BinaryTree<E>{

    private Comparable<E> comparable;


    public BST(){
        this(null);
    }


    public BST(Comparable<E> comparable){
        this.comparable = comparable;
    }


    /***
     *
     * @param element
     */
    public void add(E element){
        elementNotNullCheck(element);

        //添加第一个节点
        if (root == null) {
            root = super.createNode(element, null);
            size++;

            //添加新元素的之后的处理
            afterAdd(root);
            return;
        }

        //添加不是第一个节点
        //找到父节点
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;
        do {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                node.element = element;
            }

        } while (node != null);

        Node<E> newNode = createNode(element, parent);
        if (cmp > 0){
            parent.right = newNode;
        }else {
            parent.left = newNode;
        }
        size++;

        //新添加元素之后的处理
        afterAdd(newNode);
    }


    /**
     * 添加之后的调整
     *
     * @param node
     */
    protected void afterAdd(Node<E> node){}


    /**
     *
     * @param node
     */
    protected void afterRemove(Node<E> node){}



    /***
     *
     * @param element
     */
    public void remove(E element){
        remove(node(element));

    }

    private void remove(Node<E> node){
        if (node == null) return;

        size--;

        if (node.hasTwoChildren()){
            Node<E> s = super.successor(node);
            node.element = s.element;
            node = s;
        }

        Node<E> replacement = node.left != null ? node.left : node.right;

        if (replacement !=null){
            replacement.parent = node.parent;

            if (node.parent == null){
                root = replacement;
            }else if (node == node.parent.left){
                node.parent.left = replacement;
            }else {
                node.parent.right = replacement;
            }

        }else if (node.parent == null){
            root = null;

        }else {
            if (node == node.parent.left){
                node.parent.left = null;

            }else {
                node.parent.right = null;
            }
        }
    }


    /**
     *
     * @param element
     */
    public boolean contains(E element){
       return node(element) != null;
    }


    /***
     *
     * @param element
     * @return
     */
    private Node<E> node(E element){
        Node<E> node = this.root;
        while (node != null ){
            int cmp = compare(element, node.element);
            if (cmp == 0) return node;
            if (cmp > 0){
                node = node.right;

            }else {
                node = node.left;
            }
        }

        return null;
    }




    /**
     * @return 返回值等于0，代表e1和e2相等；返回值大于0，代表e1大于e2；返回值小于于0，代表e1小于e2
     */
    private int compare(E e1, E e2) {
        return ((Comparable<E>)e1).compareTo(e2);
    }



    private void elementNotNullCheck(E element){
        if (element == null) throw new IllegalArgumentException("element must not be null");
    }



}
