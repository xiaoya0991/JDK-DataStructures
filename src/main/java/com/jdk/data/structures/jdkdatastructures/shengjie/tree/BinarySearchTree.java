package com.jdk.data.structures.jdkdatastructures.shengjie.tree;

import com.jdk.data.structures.jdkdatastructures.shengjie.queue.ArrayQueueDemo;
import com.jdk.data.structures.jdkdatastructures.shengjie.stack.ArrayStackDemo;

/**
 * binary search tree without same element
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

//    /**
//     * add new element
//     * @param e
//     */
//    public void add(E e){
//        if(root == null){
//            root = new Node(e);
//            size ++;
//        }else
//            add(root,e);
//    }
//    //add new element to the binary search tree that the root node with root
//    private void add(Node node, E e){
//        if(e.equals(node.e))
//            return;
//        else if(e.compareTo(node.e) < 0 && node.left == null){
//            node.left = new Node(e);
//            size ++;
//            return;
//        } else if(e.compareTo(node.e) > 0 && node.right == null){
//            node.right = new Node(e);
//            size ++;
//            return;
//        }
//
//        if(e.compareTo(node.e) < 0)
//            add(node.left, e);
//        else
//            add(node.right, e);
//    }

    /**
     * add new element to the binary search tree that the root node with root by recursion method
     */
    public void add(E e){
        root = add(root,e);
    }
    private Node add(Node node, E e){
        if(node == null){
            size ++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if(e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    /**
     * judge an element that is an element of the binary search tree by recursion method
     */
    public boolean contains(E e){
        return contains(root, e);
    }
    private boolean contains(Node node, E e){
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
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * preorder travalsal by stack method
     */
    public void preOrderByStack(){
        ArrayStackDemo<Node> stack = new ArrayStackDemo<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node current = stack.pop();
            System.out.println(current.e);

            if(current.right != null)
                stack.push(current.right);
            if(current.left != null)
                stack.push(current.left);
        }
    }

    /**
     * inorder travalsal--中序遍历(左根右)
     */
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

//    /**
//     * inorder travalsal by stack method(未完成，难，暂时放弃)
//     */
//    public void inOrderByStack(){
//        ArrayStackDemo<Node> stack = new ArrayStackDemo<>();
//        Node node = root.left;
//        if(node != null)
//            node = node.left;
//
//        stack.push(node);
//
//        while (!stack.isEmpty()){
//            Node current = stack.pop();
//
//
//            System.out.println(current.e);
//
//            stack.push(rootNode.e);
//
//        }
//    }

    /**
     * postorder travalsal--后序遍历(左右根)
     */
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
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
        ArrayQueueDemo<Node> queue = new ArrayQueueDemo<>();
        queue.enqueue(root);
        while (!queue.isEmpty()){
            Node current = queue.dequeue();
            System.out.println(current.e);

            if(current.left != null)
                queue.enqueue(current.left);
            if(current.right != null)
                queue.enqueue(current.right);
        }
    }

    /**
     * obtain the min number of a binary search tree by recursion
     * @return
     */
    public E min(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        return min(root).e;
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
        return max(root).e;
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

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree();
        int[] nums = {4,2,5,1,3,7};
        for (int num : nums)
            bst.add(num);

        //          4
        //      2       5
        //1         3       7

        bst.removeMin();
        bst.removeMax();
        System.out.println(bst.min() + "========");
        System.out.println(bst.max() + "--------");
        System.out.println();
        System.out.println(bst);
    }
}
