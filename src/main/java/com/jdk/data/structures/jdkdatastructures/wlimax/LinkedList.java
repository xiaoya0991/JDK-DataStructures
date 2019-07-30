package com.jdk.data.structures.jdkdatastructures.wlimax;

/**
 * 自定义LinkedList
 */
public class LinkedList<E> {

    private Node<E> data; //存储链表
    private Node<E> first;//头部节点
    private Node<E> last;//尾部节点
    private int size =0;
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;
        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * 无参构造
     */
    public void LiArrayList(E e){
    }

    public void  add(int index,E e){
        if(index <0 || index>this.size){ throw new IllegalArgumentException("out index"); }
        Node<E> pred, succ;
        if (index == size) {
            succ = null;
            pred = last;
        } else {
            succ = get(index);
            pred = succ.prev;
        }
    }

    public Node get(int index){
        //判断从头遍历快还是从尾遍历快
        if(index <(this.size >> 1)){
            Node<E> x = this.first;
            for(int i = 0;i<index;i--){
                x = x.next;
            }
            return x;
        }else{
            Node<E> x = this.last;
            for(int i = 0;i<index;i++){
                x = x.prev;
            }
            return x;
        }
    }

}
