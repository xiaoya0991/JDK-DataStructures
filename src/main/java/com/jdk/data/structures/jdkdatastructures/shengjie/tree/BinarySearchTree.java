package com.jdk.data.structures.jdkdatastructures.shengjie.tree;

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
        add(root,e);
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
     * preorder travalsal--前序遍历
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

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree();
        int[] nums = {4,2,5,1,3,7};
        for (int num: nums)
            bst.add(num);

        //          4
        //      2       5
        //1         3       7

        bst.preOrder();
        System.out.println();
        System.out.println(bst);
    }
}
