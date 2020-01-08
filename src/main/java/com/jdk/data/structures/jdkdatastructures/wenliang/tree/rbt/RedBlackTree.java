package com.jdk.data.structures.jdkdatastructures.wenliang.tree.rbt;

import com.jdk.data.structures.jdkdatastructures.wenliang.tree.BST;
import com.jdk.data.structures.jdkdatastructures.wenliang.tree.Comparator;

/**
 * 红黑树
 *
 * @author wenliang
 */
public class RedBlackTree <E> extends BST<E> {
    private static final boolean RED = false;
    private static final boolean BLACK = true;


    public RedBlackTree(){
        this(null);
    }

    public RedBlackTree(Comparator<E> comparator){
        super((Comparable<E>) comparator);
    }


    /**
     * add node
     * @param node
     */
    @Override
    protected void afterAdd(Node<E> node) {
        Node<E> parent = node.parent;
        //根节点
        if (parent == null){
            black(node);
            return;
        }

        //如果父节点是黑色的不做处理
        if (isBlack(parent)) return;

        //uncle节点
        Node<E> uncle = parent.sibling();

        //祖父节点
        Node<E> grand = this.red(parent.parent);
        if (isRed(uncle)){
            // 叔父节点是红色【B树节点上溢】
            black(parent);
            black(uncle);
            afterAdd(grand);
            return;
        }



    }

    private Node<E> color(Node<E> node,boolean color){
        if (node == null) return node;

        ((RedBlackNode<E>) node).color = color;
        return node;
    }

    private Node<E> red(Node<E> node){
      return  color(node, RED);
    }

    private Node<E> black(Node<E> node){
        return color(node, BLACK);
    }

    private boolean colorOf(Node<E> node){
       return node == null ? BLACK : ((RedBlackNode) node).color;
    }

    private boolean isRed(Node<E> node){
      return  colorOf(node) == RED;
    }

    private boolean isBlack(Node<E> node){
        return colorOf(node) == BLACK;
    }


    private static class RedBlackNode<E> extends Node<E>{
        boolean color = RED;

        public RedBlackNode(E element, Node parent) {
            super(element, parent);
        }

        @Override
        public String toString() {
            return "RedBlackNode{" +
                    "color=" + color +
                    '}';
        }
    }


}