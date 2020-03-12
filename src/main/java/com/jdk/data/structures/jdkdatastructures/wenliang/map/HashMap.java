package com.jdk.data.structures.jdkdatastructures.wenliang.map;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

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
    private static final float DEFATLT_FACTOR = 0.75f;

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
            root = createNode(key, value, null);
            table[index] = root;
            size++;
            return null;
        }
        //添加的不是第一个节点
        //找到父节点
        HashMap.Node<K, V> parent = root;
        HashMap.Node<K, V> node = root;
        int cmp = 0;
        K k1 = key;
        int h1 = k1 == null ? 0 : key.hashCode();
        Node<K, V> result = null;
        boolean searched = false;
        do {
            parent = node;
            K k2 = node.key;
            int h2 = node.hash;
            if (h1 > h2) {
                cmp = 1;
            } else if (h1 < h2) {
                cmp = -1;
            } else if (Objects.equals(k1, k2)) {
                cmp = 0;
            } else if (k1 != null && k2 != null
                    && k1.getClass() == k2.getClass()
                    && k1 instanceof Comparable && (cmp = ((Comparable) k1).compareTo(k2)) != 0) {
            } else if (searched) {
                cmp = System.identityHashCode(k1) - System.identityHashCode(k2);
            } else {
                if (node.left != null && (result = node(node.left, k1))) {
                    ;
                }
            }
        }
    }


    /**
     * 创建节点
     *
     * @param key
     * @param value
     * @param parent
     * @return
     */
    protected Node<K, V> createNode(K key, V value, Node<K, V> parent) {
        return new Node<>(key, value, parent);
    }


    private void resize() {
        if (size / table.length <= DEFATLT_FACTOR) {
            return;
        }
        Node<K, V>[] oldTable = table;
        table = new Node[oldTable.length << 1];

        Queue<Node<K, V>> queue = new LinkedList<>();
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] == null) {
                return;
            }
            queue.offer(oldTable[i]);
            while (!queue.isEmpty()) {
                Node<K, V> node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }

    @Override
    public V get(K key) {
        Node<K, V> node = getNode(key);
        return node != null ? node.value : null;
    }

    @Override
    public V remove(K key) {
        return remove(getNode(key));
    }


    @Override
    public boolean containsKey(K key) {
        return getNode(key) != null;
    }


    @Override
    public boolean containsValue(V value) {
        if (size == 0) {
            return false;
        }
        Queue<Node<K, V>> queue = new LinkedList<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                continue;
            }
            queue.offer(table[i]);
            while (!queue.isEmpty()) {
                Node<K, V> node = queue.poll();
                if (Objects.equals(value, node.value)) {
                    return true;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return false;
    }

    @Override
    public void traversal(Visitor<K, V> visitor) {
        if (size == 0 || visitor == null) {
            return;
        }
        Queue<Node<K, V>> queue = new LinkedList<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                continue;
            }
            queue.offer(table[i]);
            while (!queue.isEmpty()) {
                Node<K, V> node = queue.poll();
                if (visitor.visit(node.key, node.value)) {
                    return;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return;
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


    /**
     * 根据key获取vaule
     *
     * @param key
     * @return
     */
    private Node<K, V> getNode(K key) {
        Node<K, V> node = table[index(key)];
        int h1 = key == null ? 0 : key.hashCode();
        while (node != null) {
            int cmp = compare(key, node.key, h1, node.hash);
            if (cmp == 0) {
                return node;
            }
            if (cmp > 0) {
                node = node.right;
            }
            if (cmp < 0) {
                node = node.left;
            }
        }
        return null;
    }


    private V remove(Node<K, V> node) {
        if (node == null) {
            return null;
        }
        this.size--;
        V oldValue = node.value;
        //度为2的节点
        if (node.hasTwoChildren()) {
            HashMap.Node<K, V> s = successor(node);
            node.key = s.key;
            node.value = s.value;
            node.hash = s.hash;
            //删除后继节点
            node = s;
        }
        //删除node节点
        HashMap.Node<K, V> replacement = node.left != null ? node.left : node.right;
        int index = index(node.key);
        //node是度为1的节点
        if (replacement != null) {
            //更改parent
            replacement.parent = node.parent;
            //更改parent的left、right的指向
            if (node.parent == null) {
                table[index] = replacement;
            } else if (node == node.parent.left) {
                node.parent.left = replacement;

            } else {
                node.parent.right = replacement;
            }
        }
        return oldValue;
    }


    /**
     * 后继节点
     *
     * @param node
     * @return
     */
    private HashMap.Node<K, V> successor(HashMap.Node<K, V> node) {
        if (node == null) {
            return null;
        }
        //前驱节点在左子树当中
        HashMap.Node<K, V> p = node.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        //从父节点、祖父节点中寻找前驱节点
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
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


    protected static class Node<K, V> {

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
