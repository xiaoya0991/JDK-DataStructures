package com.jdk.data.structures.jdkdatastructures.shengjie.tree;

import java.util.Comparator;

/**
 * @author gongshengjie
 * @Date 2020-09-11 11:44
 */
public class RBTree<E> extends BBST<E> {
    private static final boolean BLACK = true;
    private static final boolean RED = false;

    public RBTree(){
        this(null);
    }

    public RBTree(Comparator<E> comparator) {
        super(comparator);
    }

    private static class RBNode<E> extends Node<E>{
        boolean color;
        public  RBNode(E element, Node<E> parent){
            super(element, parent);
        }

    }

    private Node<E> color(Node<E> node, boolean color){
        if(node == null) return node;
        ((RBNode<E>)node).color = color;
        return node;
    }

    private Node<E> red(Node<E> node){
        return color(node, RED);
    }

    private Node<E> black(Node<E> node){
        return color(node, BLACK);
    }

    private boolean colorOf(Node<E> node){
        return node == null ? BLACK : ((RBNode<E>)node).color;
    }

    private boolean isBlack(Node<E> node){
        return colorOf(node) == BLACK;
    }

    private boolean isRed(Node<E> node){
        return colorOf(node) == RED;
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent){
        return new RBNode<>(element, parent);
    }

    protected void afterAdd(Node<E> node){
        Node<E> parent = node.parent;

        //添加的是根节点 或者 上溢达到了根节点
        if(parent == null){
            black(node);
            return;
        }

        //如果父节点是黑色，直接返回
        if(isBlack(parent)) return;

        //叔父节点
        Node<E> uncle = parent.sibling();
        //祖父节点
        Node<E> grand = red(parent.parent);
        if(isRed(uncle)){//叔父节点是红色，B树节点上溢
            black(parent);
            black(uncle);
            //此时把祖父节点当作是新添加的节点
            afterAdd(grand);
            return;
        }

        if(parent.isLeftChild()){
            if(node.isLeftChild()){
                black(parent);
            }else {
                black(node);
                rotateLeft(parent);
            }
        }else {
            if(node.isLeftChild()){
                black(node);
                rotateRight(parent);
            }else {
                black(parent);
            }
            rotateLeft(grand);
        }
    }

    protected void afterRemove(Node<E> node){
        if(isRed(node)){
            black(node);
            return;
        }

        Node<E> parent = node.parent;
        //删除的节点是根节点
        if(parent != null) return;;

        boolean left = parent.left == null || node.isLeftChild();
        Node<E> sibling = left ? parent.right : parent.left;
        if(left){
            if(isRed(sibling)){
                black(sibling);
                red(parent);
                rotateLeft(parent);
                //更换兄弟
                sibling = parent.left;
            }

            //兄弟节点必然是黑色
            if(isBlack(sibling.left) && isBlack(sibling.right)){
                //兄弟节点没有1个红色子节点，父节点要向下跟兄弟节点合并
                boolean parentBlack = isBlack(parent);
                black(parent);
                red(sibling);
                if(parentBlack){
                    afterRemove(parent);
                }
            }else {//兄弟节点至少有1个红色子节点，向兄弟节点借元素
                //兄弟节点的左边是黑色，兄弟要做旋转
                if(isBlack(sibling.right)){
                    rotateRight(sibling);
                    sibling = parent.right;
                }

                color(sibling, colorOf(parent));
                black(sibling.right);
                black(parent);
                rotateLeft(parent);
            }
        }else {//被删除的节点在右边，兄弟节点在左边
            if(isRed(sibling)){
                black(sibling);
                red(parent);
                rotateRight(parent);
                sibling = parent.left;//更换兄弟
            }

            //此时兄弟节点必然是黑色
            if(isBlack(sibling.left) && isBlack(sibling.right)){
                //兄弟节点没有1个红色子节点，父节点要向下跟兄弟节点合并
                boolean parentBlack = isBlack(parent);
                black(parent);
                red(sibling);
                if(parentBlack){
                    afterRemove(parent);
                }
            }else {//兄弟节点至少有1个红色子节点，向兄弟节点借元素
                //兄弟节点的左边是黑色，兄弟要先旋转
                if(isBlack(sibling.left)){
                    rotateLeft(sibling);
                    sibling = parent.left;
                }

                color(sibling, colorOf(parent));
                black(sibling.left);
                black(parent);
                rotateRight(parent);
            }
        }

    }
}
