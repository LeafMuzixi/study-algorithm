package com.mzx.algorithm.symbol;

/**
 * 有序符号表
 *
 * @param <Key>
 * @param <Value>
 */
public class OrderSymbolTable<Key extends Comparable<Key>, Value> {
    /**
     * 头节点
     */
    private Node head;
    /**
     * 符号表大小
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
         * 下一个节点
         */
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 构造方法
     */
    public OrderSymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    /**
     * 获取符号表大小
     *
     * @return 符号表内元素数量
     */
    public int size() {
        return this.N;
    }

    /**
     * 插入键值对
     *
     * @param key   键
     * @param value 值
     */
    public void put(Key key, Value value) {
        Node pre = this.head;
        Node node = this.head.next;
        while (node != null && node.key.compareTo(key) <= 0) {
            pre = node;
            node = node.next;
        }
        if (node != null && node.key.equals(key)) {
            node.value = value;
        } else {
            pre.next = new Node(key, value, node);
            this.N++;
        }
    }

    /**
     * 获取值
     *
     * @param key 键
     * @return {@link Value}
     */
    public Value get(Key key) {
        if (this.N == 0) return null;
        Node node = this.head;
        while (node.next != null) {
            node = node.next;
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    /**
     * 删除键值对
     *
     * @param key 键
     * @return {@link Value}
     */
    public Value remove(Key key) {
        if (this.N == 0) return null;
        Node pre = null;
        Node node = this.head;
        while (node.next != null) {
            pre = node;
            node = node.next;
            if (node.key.equals(key)) {
                pre.next = node.next;
                this.N--;
                return node.value;
            }
        }
        return null;
    }
}
