package com.jdk.data.structures.jdkdatastructures.wenliang.tree.rbt;

import com.jdk.data.structures.jdkdatastructures.wenliang.tree.BalanceBinaryTree;
import com.jdk.data.structures.jdkdatastructures.wenliang.tree.Comparator;

/**
 * 红黑树
 *
 * @author wenliang
 */
public class RedBlackTree <E> extends BalanceBinaryTree<E> {
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


        //没有根节点
        if (parent == null){
            black(node);
            return;
        }

        //如果根节点是黑色不做处理
        if (isBlack(parent)) return;

        //叔父节点
        Node<E> uncle = parent.sibling();

        Node<E> garand = parent.parent;
        if (isRed(uncle)) {
            black(uncle);
            black(parent);

            afterAdd(red(garand));
            return;
        }


        //叔父节点不是红色
        //L
        if (parent.isLeftChild()){
            //LL
            red(garand);
            if (node.isLeftChild()){
                black(parent);


            }else {
                //LR
                black(node);
                rotateLeft(parent);
            }
            rotateRight(garand);

        }

        //R
        if (parent.isRightChild()){
            //RL
            red(garand);
            if (node.isRightChild()){
                black(parent);
                rotateRight(parent);

            }else {
                black(parent);
            }
            rotateLeft(garand);

        }




    }

    @Override
    protected void afterRemove(Node<E> node, Node<E> replacement) {
        if (isRed(node)) return;

        if (isRed(replacement)) {
            black(replacement);
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

    private Node<E>
    black(Node<E> node){
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
