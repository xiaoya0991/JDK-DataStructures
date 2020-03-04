package com.jdk.data.structures.jdkdatastructures.wenliang.map;

import java.util.Objects;

/**
 * 自研hashMap
 *
 * @author wenliang
 */
public class HashMap<K, V> implements Map<K, V> {

    private static final boolean RED = false;
    private static final boolean BLACK = true;
    private int size;
    private Node<K, V>[] table;
    private static final int DEFATLT_CAPACIIY = 1 << 4;

    public HashMap() {
        table = new Node[DEFATLT_CAPACIIY];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        if (size == 0) {
            return;
        }
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public V put(K key, V value) {
        int index = index(key);
        Node<K, V> root = table[index];
        if (root == null) {
            root = new Node<>(key, value, null);
            table[index] = root;
            size++;
            return null;
        }
        //添加的不是第一个节点
        //找到父节点
        HashMap.Node<K, V> parent = root;
        HashMap.Node<K, V> node = root;
        int cmp = 0;
        int h1 = key == null ? 0 : key.hashCode();
        do {
            cmp = compare(key, node.key, h1, node.hash);
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            }
            //相等,覆盖
            node.key = key;
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        } while (node != null);

        //插入到父节点的那个位置
        HashMap.Node<K, V> newNode = new Node<>(key, value, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        this.size++;
        afterPut(newNode);

        return null;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        return false;
    }

    @Override
    public void traversal(Visitor<K, V> visitor) {

    }


    /**
     * 根据key生成对应的索引(在桶数组中的位置)
     *
     * @param key
     * @return
     */
    private int index(K key) {
        int hash;
        return (key == null) ? 0 : (hash = key.hashCode()) ^ (hash >>> 16);
    }


    private int compare(K k1, K k2, int h1, int h2) {
        //比较哈希值
        int result = h1 - h2;
        if (result != 0) {
            return result;
        }
        //比较equals
        if (Objects.equals(k1, k2)) {
            return 0;
        }
        //哈希值相等，但是不equals
        if (k1 != null && k2 != null) {
            String k1Class = k1.getClass().getName();
            String k2Class = k2.getClass().getName();
            result = k1Class.compareTo(k2Class);
            if (result != 0) {
                return result;
            }
            //同一种类型并且具备可比较性
            if (k1 instanceof Comparable) {
                return ((Comparable) k1).compareTo(k2);
            }
        }
        //比较内存地址
        return System.identityHashCode(k1) - System.identityHashCode(k2);
    }


    private void afterPut(HashMap.Node<K, V> node) {
        HashMap.Node<K, V> parent = node.parent;

        //添加的根节点或者上溢到根节点
        if (parent == null) {
            black(node);
            return;
        }

        //如果父节点是黑色的直接返回
        if (isBlack(parent)) {
            return;
        }

        //叔父节点
        HashMap.Node<K, V> uncle = parent.sibling();
        //叔父节点
        HashMap.Node<K, V> grand = red(parent.parent);
        //如果叔父节点是红色节点上溢
        if (isRed(uncle)) {
            black(parent);
            black(uncle);
            afterPut(grand);
            return;
        }

        //叔父节点不是红色
        if (parent.isLeftChild()) {
            if (node.isLeftChild()) {
                black(parent);

            } else {
                black(node);
                rotateLeft(parent);
            }
        } else {
            if (node.isLeftChild()) {
                black(node);
                rotateRight(parent);

            } else {
                black(parent);
            }
            rotateLeft(grand);

        }

    }


    private HashMap.Node<K, V> red(HashMap.Node<K, V> node) {
        return color(node, RED);
    }


    private HashMap.Node<K, V> black(HashMap.Node<K, V> node) {
        return color(node, BLACK);
    }


    private boolean colorOf(HashMap.Node<K, V> node) {
        return node == null ? BLACK : node.color;
    }


    private boolean isBlack(HashMap.Node<K, V> node) {
        return colorOf(node) == BLACK;
    }


    private boolean isRed(HashMap.Node<K, V> node) {
        return colorOf(node) == RED;
    }


    private HashMap.Node<K, V> color(HashMap.Node<K, V> node, boolean color) {
        if (node == null) {
            return node;
        }

        node.color = color;
        return node;
    }


    private void rotateLeft(HashMap.Node<K, V> grand) {
        HashMap.Node<K, V> parent = grand.right;
        HashMap.Node<K, V> child = parent.left;
        grand.right = child;
        parent.left = grand;
        afterRotate(grand, parent, child);
    }

    private void rotateRight(HashMap.Node<K, V> grand) {
        HashMap.Node<K, V> parent = grand.left;
        HashMap.Node<K, V> child = parent.right;
        grand.left = child;
        parent.right = grand;
        afterRotate(grand, parent, child);
    }

    private void afterRotate(HashMap.Node<K, V> grand, HashMap.Node<K, V> parent, HashMap.Node<K, V> child) {
        parent.parent = grand.parent;
        if (grand.isLeftChild()) {
            grand.parent.left = parent;
        } else if (grand.isRingChild()) {
            grand.parent.right = parent;
        } else {
            //grand是root节点
            table[index(grand.key)] = parent;
        }

        //更新child的parent
        if (child != null) {
            child.parent = grand;
        }

        //更新grand的parent
        grand.parent = parent;

    }


    private static class Node<K, V> {

        int hash;
        K key;
        V value;
        boolean color = RED;
        HashMap.Node<K, V> left;
        HashMap.Node<K, V> right;
        HashMap.Node<K, V> parent;

        public Node(K key, V value, HashMap.Node<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
            this.hash = key == null ? 0 : key.hashCode();
        }

        public boolean isLeft() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }

        public boolean isLeftChild() {
            return parent != null && this == parent.left;
        }

        private boolean isRingChild() {
            return parent != null && this == parent.right;
        }

        public HashMap.Node<K, V> sibling() {
            if (isLeftChild()) {
                return parent.right;
            }

            if (isRingChild()) {
                return parent.left;
            }

            return null;
        }
    }
}
