package com.mzx.algorithm.tree;

/**
 * 红黑树
 *
 * @param <Key>
 * @param <Value>
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {
    /**
     * 红节点
     */
    private static final boolean RED = true;
    /**
     * 黑节点
     */
    private static final boolean BLACK = false;
    /**
     * 根节点
     */
    private Node root;
    /**
     * 树内元素个数
     */
    private int N;

    /**
     * 节点类
     */
    private class Node {
        /**
         * 键
         */
        Key key;
        /**
         * 值
         */
        Value value;
        /**
         * 左节点
         */
        Node left;
        /**
         * 右节点
         */
        Node right;
        /**
         * 是否为黑色
         */
        boolean color;

        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    /**
     * 获取树内元素个数
     *
     * @return 树内元素个数
     */
    public int size() {
        return this.N;
    }

    /**
     * 判断节点是否为红色
     *
     * @param node 节点
     * @return true / false;
     */
    public boolean isRed(Node node) {
        return node != null && node.color == RED;
    }

    /**
     * 左旋
     *
     * @param node 左旋节点
     * @return 新节点
     */
    private Node rotateLeft(Node node) {
        // 获取节点的右子节点
        Node right = node.right;
        // 右子节点的左子节点变为当前节点的右子节点
        node.right = right.left;
        // 当前节点变为右子节点的左子节点
        right.left = node;
        // 右子节点颜色变为当前节点的颜色
        right.color = node.color;
        // 当前节点变为红色
        node.color = RED;
        // 返回右子节点
        return right;
    }

    /**
     * 右旋
     *
     * @param node 右旋节点
     * @return 新节点
     */
    private Node rotateRight(Node node) {
        // 获取节点的左子节点
        Node left = node.left;
        // 左子节点的右子节点变为当前节点的左子节点
        node.left = left.right;
        // 当前节点变为左子节点的右子节点
        left.right = node;
        // 左子节点颜色变为当前节点的颜色
        left.color = node.color;
        // 当前节点变为红色
        node.color = RED;
        // 返回右子节点
        return left;
    }

    /**
     * 反转节点的颜色（只有左右字节点都为红色时才需要反转）
     *
     * @param node 节点
     */
    private void flipColor(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * 设置键值对
     *
     * @param key   键
     * @param value 值
     */
    public void put(Key key, Value value) {
        this.root = put(this.root, key, value);
        this.root.color = BLACK;
    }

    /**
     * 向指定节点设置键值对
     *
     * @param node  节点
     * @param key   键
     * @param value 值
     */
    public Node put(Node node, Key key, Value value) {
        // 如果当前节点为空，则插入新的红色节点
        if (node == null) {
            this.N++;
            return new Node(key, value, null, null, RED);
        }
        // 查找
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.left = put(node.left, key, value);
        } else if (compare > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        // 进行左旋：当当前节点的左子节点为黑色，右子节点为红色时，需要左旋
        if (!isRed(node.left) && isRed(node.right)) {
            node = rotateLeft(node);
        }
        // 进行右旋：当当前节点的左子节点为红色，左子节点的左子节点为红色时，需要右旋
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        // 颜色反转：当当前节点的左子节点和右子节点都为红色时，需要反转
        if (isRed(node.left) && isRed(node.right)) {
            flipColor(node);
        }
        return node;
    }

    /**
     * 获取键值
     *
     * @param key 键
     * @return 值
     */
    public Value get(Key key) {
        return get(this.root, key);
    }

    /**
     * 在当前节点中获取键值
     *
     * @param node 节点
     * @param key  键
     * @return 值
     */
    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        // 查找
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            return get(node.left, key);
        } else if (compare > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }
}
