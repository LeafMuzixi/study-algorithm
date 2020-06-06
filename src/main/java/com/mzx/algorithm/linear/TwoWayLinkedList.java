package com.mzx.algorithm.linear;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * 双向链表
 *
 * @param <T>
 */
public class TwoWayLinkedList<T> implements Iterable<T> {
    /**
     * 头节点
     */
    private final Node head;
    /**
     * 尾节点
     */
    private Node last;
    /**
     * 链表的长度
     */
    private int N;

    /**
     * 节点类
     */
    private class Node {
        /**
         * 数据对象
         */
        T data;
        /**
         * 上一个节点
         */
        Node pre;
        /**
         * 下一个节点
         */
        Node next;

        public Node(T data, Node pre, Node next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }

    /**
     * 构造方法
     */
    public TwoWayLinkedList() {
        // 初始化头节点
        this.head = new Node(null, null, null);
        // 初始化尾节点
        this.last = null;
        // 初始化链表长度
        this.N = 0;
    }

    /**
     * 清空链表
     */
    public void clear() {
        this.head.pre = null;
        this.head.next = null;
        this.head.data = null;
        this.last = null;
        this.N = 0;
    }

    /**
     * 获取链表长度
     *
     * @return 链表的长度
     */
    public int length() {
        return this.N;
    }

    /**
     * 判断链表是否为空
     *
     * @return true / false;
     */
    public boolean isEmpty() {
        return this.N == 0;
    }

    /**
     * 获取第一个元素
     *
     * @return {@link T}
     */
    public T getFirst() {
        if (this.isEmpty()) return null;
        return this.head.next.data;
    }

    /**
     * 获取最后一个元素
     *
     * @return {@link T}
     */
    public T getLast() {
        if (this.isEmpty()) return null;
        return this.last.data;
    }

    /**
     * 获取 index 索引处的元素
     *
     * @param index 索引
     * @return {@link T}
     */
    public T get(int index) {
        if (index >= this.N) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node node;
        // 如果处于前半部分，从头节点开始找
        if (index < this.N / 2) {
            node = this.head;
            for (int i = 0; i <= index; i++) {
                node = node.next;
            }
        } else {
            // 否则，从尾节点开始找
            node = this.last;
            for (int i = 0; i < N - index - 1; i++) {
                node = node.pre;
            }
        }
        return node.data;
    }

    /**
     * 向链表中插入元素
     *
     * @param t {@link T}
     */
    public void insert(T t) {
        if (this.isEmpty()) {
            this.head.next = new Node(t, this.head, null);
            this.last = this.head.next;
        } else {
            this.last.next = new Node(t, this.last, null);
            this.last = this.last.next;
        }
        // 链表长度 +1
        N++;
    }

    /**
     * 向链表中 index 索引处插入元素
     *
     * @param index 插入索引
     * @param t     {@link T}
     */
    public void insert(int index, T t) {
        if (index == this.N) this.insert(t);
        if (index > this.N) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node pre;
        // 如果处于前半部分，从头节点开始找
        if (index < this.N / 2) {
            pre = this.head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
        } else {
            // 否则，从尾节点开始找
            pre = this.last;
            for (int i = 0; i < N - index; i++) {
                pre = pre.pre;
            }
        }
        // 创建新节点保存数据
        Node newNode = new Node(t, pre, pre.next);
        pre.next.pre = newNode;
        pre.next = newNode;
        // 链表长度 +1
        N++;
    }

    /**
     * 从链表中删除 index 索引处的元素
     *
     * @param index 删除索引
     * @return 删除的元素 {@link T}
     */
    public T remove(int index) {
        if (index == this.N - 1) {
            Node result = this.last;
            this.last.pre.next = null;
            return result.data;
        }
        if (index >= this.N) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node pre;
        // 如果处于前半部分，从头节点开始找
        if (index < this.N / 2) {
            pre = this.head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
        } else {
            // 否则，从尾节点开始找
            pre = this.last;
            for (int i = 0; i < N - index; i++) {
                pre = pre.pre;
            }
        }
        Node result = pre.next;
        // 让当前节点的 next 指向 index 索引处后一个节点
        pre.next = result.next;
        // 让 index 索引处后一个节点的 pre 指向当前节点
        result.next.pre = pre;
        // 链表长度 -1
        N--;
        return result.data;
    }

    /**
     * 查找链表中 index 索引处的元素
     *
     * @param t 查找的元素 {@link T}
     * @return 索引
     */
    public int indexOf(T t) {
        Node node = this.head;
        for (int i = 0; i < N; i++) {
            node = node.next;
            if (node.data.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node node = head;

            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public T next() {
                node = node.next;
                return node.data;
            }
        };
    }
}
