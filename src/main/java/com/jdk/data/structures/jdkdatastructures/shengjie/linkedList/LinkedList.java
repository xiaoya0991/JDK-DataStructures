package com.jdk.data.structures.jdkdatastructures.shengjie.linkedList;

public class LinkedList<E> extends AbstractList<E> {
    private class Node{

        public E e;
        public Node prev;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){ this(e,null); }

        /**
         * override toString method
         */
        @Override
        public String toString(){
            return e.toString();
        }
    }


    /**
     * define the only dummy head node
     */
    private Node dummyHead;
    /**
     * define size of LinkedList
     */
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    /**
     * get the size
     * @return
     */
    public int getSize(){return this.size; }

    /**
     * add an element at a position
     * @param e
     * @param index
     */
    public void add(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("add failed, illegal index");

        Node prev = dummyHead;
        for(int i = 0; i < index; i ++)
            prev = prev.next;

//                prev.next = new Node(e,prev.next);//转化以下三行作为理解

        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;

        size ++;
    }

    /**
     * insert new element at the head node
     */
    public void addFirst(E e){ add(0, e); }

    /**
     * add an element
     * @param e
     */
    public void addLast(E e){ add(size, e); }

    /**
     * get an element at the position
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("get failed, illegal index");

        Node current = dummyHead.next;
        for(int i = 0; i < index; i ++)
            current = current.next;
        return current.e;
    }

    /**
     * get the first element
     * @return
     */
    public E getFirst(){

        return get(0); }

    /**
     * get the last element
     * @return
     */
    public E getLast(){ return get(size - 1); }

    /**
     * update the element at a position
     * @param index
     * @param e
     */
    public E set(int index, E e){
        if(index < 0 || index > 0)
            throw new IllegalArgumentException("set failed, illegal index");

        Node current = dummyHead.next;
        for(int i = 0; i < index; i ++)
            current = current.next;

        current.e = e;

        return get(index);
    }

    /**
     * judge an element is existed
     * @param e
     * @return
     */
    public boolean contains(E e){
        Node current = dummyHead.next;
        while (current != null){
            if(current.e.equals(e))
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public void add(E element) {

    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();

//        Node current = dummyHead.next;
//        while (current != null){
//            stringBuilder.append(current + "->");
//            current = current.next;
//        }
        //上边while循环也可以换成for循环
        for(Node current = dummyHead.next; current != null; current = current.next)
            stringBuilder.append(current + "->");

        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }

    /**
     * remove an element at a position
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("remove failed, index illegal");

        Node prev = dummyHead;

        for(int i = 0; i < index; i ++)
            prev = prev.next;

        Node result = prev.next;
        prev.next = result.next;
        result.next = null;
        size --;

        return result.e;
    }

    /**
     * remove the first element
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    private Node head;
    /**
     * remove repeated element in LinkedList
     */
    public Node removeSameElement(Node node,E e){

        //method1
        if(node == null)
            return null;
        while (node != null && node.e == e){
            Node delNode = head;
            node = node.next;
            delNode = null;
        }

        Node prev = node;
        while(prev.next != null){
            if(prev.next.e == e){
                Node delNode = prev;
                prev.next = node.next;
                delNode = null;
            }else
                prev = prev.next;
        }
        return node;

//        //method 2
//        dummyHead.next = node;
//        Node prev = dummyHead;
//        while(prev.next != null){
//            if(prev.next.e == e){
//                prev.next = prev.next.next;
//            }else
//                prev = prev.next;
//        }
//        return dummyHead.next;
    }

    /**
     * remove an element
     * @param e
     */
    public void remove(E e){
        if(!contains(e))
            throw new IllegalArgumentException("the element is not existed!!!");

        dummyHead = removeSameElement(dummyHead,e);
    }

    /**
     * return a positive element of a node
     * @param index
     * @return
     */
    public E findPositiveNode(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("get failed, illegal index");

        Node current = dummyHead.next;
        for(int i = 0; i < index; i ++)
            current = current.next;
        return current.e;
    }

    /**
     * Return to the countdown to a node
     * @param index
     * @return
     */
    public E findCountdownNode(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("get failed, illegal index");

        Node current = dummyHead.next;
        for(int i = 0; i < size - index; i ++)
            current = current.next;
        return current.e;
    }

    /**
     * return the medium node
     * @return
     */
    public String getMediumNode(){
        if(size / 2 == 1)
            return get((size + 1) / 2).toString();
        else
            return get((size - 1) / 2).toString()+","+get((size + 1) / 2).toString();
    }

    /**
     * return the smallest head node from sorted LinkedList(ASC)
     * @return
     */
    public E getHeadFromSorted(){
        E e = null;
        for(int i = 0; i < size - 1; i ++) {
            if (get(i).toString().compareTo(get(i + 1).toString()) > 0)
                e = get(i + 1);
            else
                e = get(i);
        }
        return e;
    }

    /**
     * define two pointer
     */
    private Node slow,fast;

    /**
     * judge LinkedList has loop
     * @return
     */
    public boolean isLoopLinkedList(){

        slow = fast = dummyHead;
        for (int i = 0; i < size - 1; i ++){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        }
        return false;
    }

    /**
     * remove the last element
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < 5; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(3,2);
        System.out.println(linkedList);
    }

    /**
     * 链表反转,leetcode24
     * @param head
     * @return
     */
    public Node reverseList(Node head) {
        if(head == null && head.next == null) return head;

        Node newHead = null;
        while (head != null) {
            Node tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }

        return newHead;
    }

    private void ensureCapcity(){}
    private void trim(){}


}
