package com.jdk.data.structures.jdkdatastructures.wlimax.tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树
 * 使用泛型但是要求泛型具有可比较性
 * @param <E>
 */
public class BSTree<E extends Comparable<E>>  {

    private Node root;
    private int size ;

    public static  class Node<E> {
      E e;
      Node left;
      Node right;
      Node(E x) {
          this.e = x;
      }
   }

   public BSTree(){
        this.root = null;
        this.size = 0;
   }
   public int getSize(){ return this.size;}
   public boolean isEmpany(){ return this.size ==0;}

   public void add(E e){
        if(this.root==null){
            this.root = new  Node(e);
            this.size++;
        }else {
            add(root,e);
        }
   }

    /**
     * 像node为根的节点插入
     * @param node
     * @param e
     */
   private Node add(Node node, E e){
       if(node == null) {
         this.size++;
         return new Node(e);
       }
       if(e.compareTo((E) node.e) < 0){
         node.left =   add(node.left,e);
       }else if(e.compareTo((E) node.e) > 0){
         node.right =   add(node.right,e);
       }
          return  node;
   }

    /**
     * 添加节点非递归方式
     * @param node
     * @param e
     */
   private void addNR(Node node,E e){
       //空时添加节点
       if(node ==null){
           size++;
           this.root = new Node(e);
       }
       //



   }
   public   boolean contains(E e){
        return contains(root, e);
   }
   private boolean contains(Node node, E e){
        if(node == null){ return false; }

        if(e.compareTo((E) node.e) ==0)
            return false;
        else if(e.compareTo((E) node.e) <0)
            return contains(node.left,e);
        else
            return contains(node.right,e);
   }

    /**
     * 前序遍历
     */
    public void indOrder(){
        indOrder(this.root);
    }
    private void indOrder(Node node){
        if(node == null)return;
        System.out.println(node.e);
        indOrder(node.left);
        indOrder(node.right);
    }

    /**
     * 前序非递归实现
     * 深度遍历
     */
    public void indOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            if(cur.right !=null)stack.push(cur.right);
            System.out.println(cur.e);
            if(cur.left != null)stack.push(cur.left);
        }
    }

    /**
     * 前序遍历非递归实现
     * 广度遍历
     */
    public void indOrderNP(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);
            if(cur.left != null) q.add(cur.left);
            if(cur.right != null) q.add(cur.right);
        }
    }

    /**
     * 中序遍历
     */
    public void postOrder(){
        postOrder(this.root);
    }
    private void postOrder(Node node){
        if(node == null)return;
        postOrder(node.left);
        System.out.println(node.e);
        postOrder(node.right);
    }
    /**
     * 后序遍历
     */
   public void preOrder(){
       preOrder(root);
   }

   private void preOrder(Node node){
       if(node == null)return;
       System.out.println(node.e);
       preOrder(node.right);
       preOrder(node.left);
   }

   public void   remove(E e ){
        remove(root,e);
   }
   private Node remove(Node node,E e){
       if(node == null)return  null;
       if(e.compareTo((E) node.e) <0){
           node.left = remove(node.left,e);
           return node;
       }else if(e.compareTo((E)node.e) > 0){
           node.right = remove(node.right,e);
          return node;
       }else{
           if(node.left == null){
               Node rightNode = node.right;
               node.right = null;
               size--;
               return rightNode;
           }
           if(node.right == null){
               Node leftNode = node.left;
               node.left = null;
               size--;
               return leftNode;
           }
           Node successor = minimum(node.right);
           successor.right = removeMin(node.right);
           successor.left =node.left;
           node.left = node.right =null;
           return  successor;
       }
   }

   public E minimum(){
       if(size ==0){ throw  new IllegalArgumentException("size ==0"); }
       return (E) minimum(root).e;
   }
    public Node minimum(Node node){
        if(node.left ==null){ return node; }
      return   minimum(root.left);
    }

    /**
     * 删除最小节点
     * @return
     */
    public E removeMin(){
        E ret = minimum();
        removeMin(root);
        return  ret;
    }
   public Node removeMin(Node node){
       if(node.left == null){
           Node rightNode = node.right;
           node.right = null;
           size--;
           return rightNode;
       }
       node.left = removeMin(node.left);
       return node;
   }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTSting(this.root,0,res);
        return res.toString();
    }

    private void generateBSTSting(Node node, int depth, StringBuilder res){
        if(node == null){
            res.append(generateBSTSting(depth) + "null\n");
            return;
        }
        res.append(generateBSTSting(depth) + node.e + "\n");
        generateBSTSting(node.left,depth+1,res);
        generateBSTSting(node.right,depth+1,res);
    }
    private String generateBSTSting(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0;i < depth;i++){
            res.append("-->");
        }
        return res.toString();
    }

}
