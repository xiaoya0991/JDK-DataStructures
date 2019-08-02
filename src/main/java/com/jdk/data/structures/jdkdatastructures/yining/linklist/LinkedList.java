package com.jdk.data.structures.jdkdatastructures.yining.linklist;

/**
 * @author: huyining
 * @since :    2019-07-31
 */
public class LinkedList<E> {

    private class Node {

        public E e;

        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    '}';
        }
    }

    private Node head;

    private int size;

    public LinkedList() {
        head = new Node();
        size = 0;
    }


    /**
     * 获取链表中的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表index的位置添加元素
     */

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Illegal  index. ");
        }

        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }


    /**
     * 在链表的头部添加元数
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表尾部添加元素
     */
    public void addLast(E e) {
        add(size, e);
    }


    /**
     * 获取链表中index位置的元素
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed, Illegal Index");
        }

        Node pre = head.next;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        return pre.e;
    }


    /**
     * 获取链表中第一个元素
     */
    public E getFirst() {
        return get(0);
    }


    /**
     * 获取链表中最后一个元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获取头结点
     *
     * @return
     */
    public Node getFirstNode() {
        if (isEmpty()) {
            return null;
        }
        return head;
    }


    /**
     * 获取链表中最后的一个元素
     */
    public E getLastNode() {
        Node curNode = head.next;

        while (curNode.next != null) {
            curNode = curNode.next;
        }
        return curNode.e;
    }

    /**
     * 修改链表中第index位置为E
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed, Illegal Index");
        }

        Node pre = head.next;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.e = e;
    }

    /**
     * 查找链表中是否有元素e
     */
    public boolean contains(E e) {
        Node cur = head.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除链表中index位置的元素
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove  failed, Illegal Index");
        }

        Node pre = head.next;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        Node delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    /**
     * 删除链表中第一个元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除链表中最后一个元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从链表中删除元数E
     */
    public void removeElement(E e) {
        Node pre = head;
        while (pre != null) {
            if (pre.next.e.equals(e)) {
                break;
            }
            pre = pre.next;
        }

        if (pre.next != null) {
            Node deleNode = pre.next;
            pre.next = deleNode.next;
            deleNode.next = null;
        }
    }


    /**
     * 打印出链表
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = head.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }


    /**
     * 求链表的长度
     */
    public int getLinkedListSize() {
        Node cur = head;
        int count = 0;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }


    /**
     * 单向链表反转
     */
    public void reversetList(Node node) {

        // 链表只有一个结点的话就不需要反转
        if (node.next == null || node.next.next == null) {
            return;
        }

        // 定义辅助结点
        Node cur = head.next;
        Node next = null;
        Node reverseHead = new Node();

        while (cur != null) {
            // 保存下一个结点
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }
}
