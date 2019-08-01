package com.jdk.data.structures.jdkdatastructures.wlimax.tree;
import com.jdk.data.structures.jdkdatastructures.wlimax.Abstract;

/**
 * 二分搜索树
 */
public class BST<E> extends Abstract<E> {

    /**
     * 节点存储
     * @param <E>
     */
    public class Node<E>
    {
        public E e;
        public Node left,right;
        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }
    private int size ;
    private Node root;
    /**
     * 构造函数
     */
     public BST(){
       this.root = null;
       this.size = 0;
     }
    @Override
    public void clera() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }
   @Override
    public void  addLast(E e){
         if(this.root == null){
             this.root = new Node(e);
             this.size++;
         }else{
             addF(root,e);
         }
   }
   private Node addF(Node node,E e){
         if(node == null ){
             this.size++;
             return new Node(e);
         }
       if(e.comparero(node.e)<0) {
           node.left = addF(node.left, e);
       }else if(e. compareTo(node.e)>0) {
           node.right = addF(node.right, e);
       }
       return node;
   }
    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int find(E element) {
        return 0;
    }
}
