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


    @Override
    protected void afterAdd(Node<E> node){
        while ((node = node.parent) != null){
            if (isBalanced(node)){
                //更新高度
                updateHeight(node);
            }else {
                //恢复平衡


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
    }




}
