package com.jdk.data.structures.jdkdatastructures.shengjie.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * binary search tree without same element
 */
public class BinarySearchTree<E extends Comparable<E>>{
    private class Node<E>{
        public E e;
        public Node<E> left,right;
        public Node<E> parent;

        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }

        public Node(E e, Node parent){
            this.e = e;
            this.parent = parent;
            this.left = null;
            this.right = null;
        }

        public boolean isLeaf(){
            return left == null && right == null;
        }

        public boolean hasTwoChildren(){
            return left != null && right != null;
        }
    }

    private Node<E> root;
    private int size;
    private int depth;//深度
    private Comparable<E> comparable;

    public BinarySearchTree(Comparable<E> comparable){
        this.comparable = comparable;
    }

    public BinarySearchTree(Node<E> root, int size, int depth){
        this.root = root;
        this.size = size;
        this.depth = depth;
    }

    public BinarySearchTree(){

    }

    public int getSize(){
        return size;
    }

    public int getDepth() { return depth; }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        root = null;
        size = 0;
    }

    /**
     * add new element to the binary search tree that the root node with root by recursion method
     */
//    public void add(E e){
////        root = add(root,e);
////    }
////    private Node add(Node<E> node, E e){
////        if(node == null){
////            size ++;
////            return new Node(e);
////        }
////
////        if(e.compareTo(node.e) < 0)
////            node.left = add(node.left, e);
////        else if(e.compareTo(node.e) > 0)
////            node.right = add(node.right, e);
////
////        return node;
////    }

    public void add(E e){
        elementNotNullCheck(e);

        //添加第一个节点
        if(root == null){
            root = new Node<>(e, null);
            size ++;
            return;
        }

        //添加的不是第一个节点
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;
        while(node != null){
            cmp = compare(e, node.e);
            parent = node;
            if(cmp > 0){
                node = node.right;
            }else if(cmp < 0){
                node = node.left;
            }else {
                return;
            }
        }

        //查看插入到父节点的那个位置
        Node<E> newNode = new Node<>(e, parent);
        if(cmp > 0){
            parent.right = newNode;
        }else {
            parent.left = newNode;
        }

        size ++;
    }

    private int compare(E e, E e1) {
        return e.compareTo(e1);
    }

    private void elementNotNullCheck(E e) {
        if(e == null){
            throw new IllegalArgumentException("element must not be null");
        }
    }

    /**
     * judge an element that is an element of the binary search tree by recursion method
     */
    public boolean contains(E e){
        return contains(root, e);
    }
    private boolean contains(Node<E> node, E e){
        if(node == null)
            return false;

        if(e.compareTo(node.e) == 0)
            return true;
        else if(e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else if(e.compareTo(node.e) > 0)
            return contains(node.right, e);

        return false;
    }

    /**
     * preorder travalsal--前序遍历(根左右)
     */
    private void preOrder(Visitor<E> visitor){
        if(visitor == null) return;
        preOrder(root, visitor);
    }

    public void preOrder(Node<E> node, Visitor<E> visitor) {
        if(node == null || visitor.stop) return;
        visitor.stop = visitor.visit(node.e);
        preOrder(node.left, visitor);
        preOrder(node.right, visitor);
    }

    /**
     * inorder travalsal--中序遍历(左根右)
     */
    public void inOrder(Visitor<E> visitor){
        if(visitor == null) return;
        inOrder(root,visitor);
    }

    private void inOrder(Node<E> node, Visitor<E> visitor){
        if(node == null || visitor.stop)
            return;

        inOrder(node.left, visitor);
        if(visitor.stop) return;
        visitor.stop = visitor.visit(node.e);
        inOrder(node.right, visitor);
    }

    /**
     * postorder travalsal--后序遍历(左右根)
     */
    public void postOrder(Visitor<E> visitor){
        if(visitor == null) return;

        postOrder(root, visitor);
    }

    private void postOrder(Node<E> node, Visitor<E> visitor){
        if(node == null || visitor.stop)
            return;

        postOrder(node.left, visitor);
        postOrder(node.right, visitor);
        if(visitor.stop) return;
        visitor.stop = visitor.visit(node.e);
    }

    /**
     * 层序遍历
     * @param visitor
     */
    public void levelOrder(Visitor<E> visitor){
        if(root == null || visitor == null) return;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            if(visitor.visit(node.e)) return;

            if(node.left != null)
                queue.offer(node.left);

            if(node.right != null){
                queue.offer(node.right);
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        generateBSTToString(root, 0, stringBuilder);
        return stringBuilder.toString();
    }

    //generate a binary search tree that has depth of the depth with the root node named root
    private void generateBSTToString(Node node, int depth, StringBuilder stringBuilder){
        if(node == null){
            stringBuilder.append(generateDepthBSTToString(depth) + "null\n");
            return;
        }

        stringBuilder.append(generateDepthBSTToString(depth) + node.e + "\n");
        generateBSTToString(node.left, depth + 1, stringBuilder);
        generateBSTToString(node.right, depth + 1, stringBuilder);
    }

    private String generateDepthBSTToString(int depth){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < depth; i ++)
            stringBuilder.append("_");

        return stringBuilder.toString();
    }

    /**
     * levelorder tarvalsal -- 层序遍历
     */
    public void levelOrder(){
        if(root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Node current = queue.poll();
            System.out.println(current.e);

            if(current.left != null)
                queue.offer(current.left);
            if(current.right != null)
                queue.offer(current.right);
        }
    }

    /**
     * obtain the min number of a binary search tree by recursion
     * @return
     */
    public E min(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        return (E) min(root).e;
    }

    private Node min(Node node){
        if(node.left == null)
            return node;
        return min(node.left);
    }

    /**
     * remove the min number of a binary search tree by recursion
     * @return
     */
    public E removeMin(){
        E result = min();
        root = removeMin(root);
        return result;
    }

    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * the max number of a binary search tree by recursion
     * @return
     */
    public E max(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        return (E) max(root).e;
    }

    private Node max(Node node){
        if(node.right == null)
            return node;
        return max(node.right);
    }

    /**
     * remove the max number of a binary search tree by recursion
     * @return
     */
    public E removeMax(){
        E result = max();
        root = removeMax(root);
        return result;
    }

    private Node removeMax(Node node){
        if(root.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * remove an element
     * @param e
     */
    public void remove(E e){
        root = remove(root, e);
    }

    private Node remove(Node<E> node, E e){
        if(node == null)
            return null;
        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }else {
            //the situation that the remove node has children node and the left children node are null
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            //the situation that the remove node has children node and the right children node are null
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            //the situation that the remove node has children nodes , the left children nodes and the right children nodes all are not null
//            //solution1 : find the min node of the right children nodes to replace the remove node
//            Node successor = min(node.right);
//            successor.right = removeMin(node.right);
//            successor.left = node.left;
//            node.left = node.right = null;

            //solution2 : find the max node of the right children nodes to replace the remove node
            Node successor = max(node.left);
            successor.left = removeMin(node.left);
            successor.right = node.right;
            node.left = node.right = null;

            return successor;
        }
    }

    /**
     * the neighbor node smaller than an element
     * @param e
     * @return
     */
    public E floor(E e){
        return floor(root, e).e;
    }

    private Node<E> floor(Node<E> node, E e){
        if(node == null)
            return null;

        //an element is the node of the binary search tree
        if(node.e.compareTo(e) == 0) {
            if(node.left == null)//this is the min node now
                return node;
            return node.left;
        }
        //an element is not at this binary search tree
        else if(node.e.compareTo(e) < 0){
            if(node.left == null)
                return node;
            node.right = floor(node.right, e);
        }else if(node.e.compareTo(e) > 0){
            node.left = floor(node.left,e);
        }
        return node;

    }

    /**
     * the neighbor node larger than an element
     * @param e
     * @return
     */
    public E ceil(E e){
        return ceil(root, e).e;
    }

    private Node<E> ceil(Node<E> node, E e){
        if(node == null)
            return null;

        //an element is the node of the binary search tree
        if(node.e == e) {
            if(node.right == null)//this is the max node now
                return node;
            return node.right;
        }
        //an element is not at this binary search tree
        else if(node.e.compareTo(e) < 0){
            node.right = ceil(node.right, e);
        }else if(node.e.compareTo(e) > 0){
            if(node.right == null)
                return node;
            node.left = ceil(node.left, e);
        }
        return node;
    }

    public boolean isComplete(){
        if(root == null) return false;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        boolean leaf = false;
        while (!queue.isEmpty()){
            Node<E> node = queue.poll();

            if(leaf && !node.isLeaf()) return false;

            if(node.hasTwoChildren()){
                queue.offer(node.left);
                queue.offer(node.right);
            }else if(node.left == null && node.right != null){
                return false;
            }else {
                leaf = true;
                if(node.left != null){
                    queue.offer(node.left);
                }
            }
        }
        return true;
    }

    public static abstract class Visitor<E>{
        boolean stop;

        /**
         * @param e
         * @return 返回为true， 就代表停止遍历
         */
        abstract boolean visit(E e);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree();

        int[] nums = {4,2,5,1,3,7};
        for (int num : nums)
            bst.add(num);

        //          4
        //      2       5
        //1         3       7

//        bst.preOrder();
//        System.out.println("\n" + bst.ceil(6));
//        System.out.println("\n" + bst);
        bst.isComplete();

    }
}
