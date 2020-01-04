package com.jdk.data.structures.jdkdatastructures.wenliang.tree.avl;
import com.jdk.data.structures.jdkdatastructures.wenliang.tree.BST;
import com.jdk.data.structures.jdkdatastructures.wenliang.tree.Comparator;

/**
 * @author wenliang
 */
public class AvlTree<E> extends BST<E> {


    public AvlTree(){
        this(null);
    }

    public AvlTree(Comparator<E> comparator){
        super((Comparable<E>) comparator);
    }



    /**
     *
     * @param node
     */
    @Override
    protected void afterAdd(Node<E> node){
        while ((node = node.parent) != null){
            if (isBalanced(node)){
                //更新高度
                updateHeight(node);
            }else {
                //恢复平衡
                rebalance(node);
                break;
            }

        }

    }


    @Override
    protected void afterRemove(Node<E> node) {
        while ((node = node.parent) != null){
            if (isBalanced(node)){
                //更新高度
                updateHeight(node);
            }else {
                //恢复平衡
                rebalance(node);

            }

        }
    }

    @Override
    protected Node<E> createNode(E element,Node<E> parent){
        return new AvlNode<E>(element, parent);
    }


    private boolean isBalanced(Node<E> node){
        return Math.abs(((AvlNode) node).banlanceFactor()) <= 1;
    }


    private void updateHeight(Node<E> node){
        ((AvlNode)node).updateHeight();
    }


    /**
     * 恢复平衡
     *
     * @param grand 高度最低的那个不平衡的节点
     */
    private void rebalance(Node<E> grand){
        Node<E> parent = ((AvlNode) grand).tallerChild();
        Node<E> node = ((AvlNode) parent).tallerChild();
        // L
        if (parent.isLeftChild()){
            //LL
            if (node.isLeftChild()){
                rotateRight(grand);

                //LR
            }else {
                rotateLeft(parent);
                rotateRight(grand);
            }

            //R
        }else {
            //RL
            if (node.isLeftChild()){
                rotateRight(parent);
                rotateLeft(grand);

                // R
            }else {
                rotateLeft(grand);
            }

        }
    }


    private void rotate(
            Node<E> r,//根节点
            Node<E> a,Node<E> b,Node<E> c,
            Node<E> d,
            Node<E> e,Node<E> f,Node<E> g ){

        d.parent = r.parent;
        if (r.isLeftChild()){
            r.parent.left = d;
        }else if (r.isRightChild()){
            r.parent.right = d;
        }else {
            root = d;
        }

        b.left = a;
        if (a != null){
            a.parent = b;
        }
        b.right = c;
        if (c != null){
            c.parent = b;
        }

    }
    private void rotateLeft(Node<E> grand){
        Node<E> parent = grand.right;
        Node<E> child  = parent.left;
        parent.right = child;
        parent.parent = grand;

        afterRotate(grand,parent,child);


    }

    private void rotateRight(Node<E> grand){

        Node<E> parent = grand.right;
        Node<E> child  = parent.left;
        parent.right = child;
        parent.parent = grand;

        afterRotate(grand,parent,child);

    }

    private void afterRotate(Node<E> grand,Node<E> parent,Node<E> child){

        parent.parent = grand.parent;
        if (grand.isLeftChild()){
            grand.parent.left = parent;
        }else if (grand.isRightChild()){
            grand.parent.right = parent;
        }else {
            root = parent;
        }

        if (child != null){
            child.parent = grand;
        }


        grand.parent = parent;

        updateHeight(grand);
        updateHeight(parent);


    }


    private static class AvlNode<E> extends Node<E> {

        int height = 1;

        public AvlNode(E element, Node parent) {
            super(element, parent);
        }

        public int banlanceFactor(){
            int leftHeight = left == null ? 0:((AvlNode) left).height;
            int rightHeight = right == null ? 0 : ((AvlNode) right).height;
            return leftHeight - rightHeight;
        }


        public void updateHeight(){
            int leftHeight = left == null ? 0:((AvlNode) left).height;
            int rightHeight = right == null ? 0 : ((AvlNode) right).height;
            height = 1 + Math.max(leftHeight, rightHeight);
        }


        public Node<E> tallerChild(){
            int leftHeight = left == null ? 0:((AvlNode) left).height;
            int rightHeight = right == null ? 0 : ((AvlNode) right).height;

            if (leftHeight > rightHeight) {
                return left;
            }

            if (leftHeight < rightHeight) {
                return right;
            }

            return isLeftChild() ? left : right;

        }
    }




}
