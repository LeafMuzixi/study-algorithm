package com.mzx.algorithm.linear;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * 链表
 *
 * @param <T>
 */
public class LinkedList<T> implements Iterable<T> {
    /**
     * 头节点
     */
    private Node head;
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
         * 下一个节点
         */
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 构造方法
     */
    public LinkedList() {
        // 初始化头节点
        this.head = new Node(null, null);
        // 初始化链表长度
        this.N = 0;
    }

    /**
     * 清空链表
     */
    public void clear() {
        this.head.next = null;
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
     * 获取 index 索引处的元素
     *
     * @param index 索引
     * @return {@link T}
     */
    public T get(int index) {
        if (index >= this.N) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node node = this.head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    /**
     * 向链表中插入元素
     *
     * @param t {@link T}
     */
    public void insert(T t) {
        // 找到当前最后一个节点
        Node node = this.head;
        while (node.next != null) {
            node = node.next;
        }
        // 创建新节点保存数据，并让最后一个节点指向它
        node.next = new Node(t, null);
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
        if (index > this.N) {
            throw new ArrayIndexOutOfBoundsException();
        }
        // 找到 index 索引处的节点
        Node node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        // 创建新节点保存数据，指向 index 索引处后一个节点，并让 index 索引处的节点指向它
        node.next = new Node(t, node.next);
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
        if (index >= this.N) {
            throw new ArrayIndexOutOfBoundsException();
        }
        // 找到 index-1 索引处的节点
        Node node = this.head;
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
        }
        Node result = node.next;
        // 让当前节点指向 index 索引处后一个节点
        node.next = result.next;
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

    /**
     * 反转整个列表
     */
    public void reverse() {
        if (this.isEmpty()) return;
        reverse(head.next);
    }

    /**
     * 反抓指定节点，并把反转后的节点返回
     *
     * @param node {@link Node}
     * @return {@link Node}
     */
    private Node reverse(Node node) {
        // 如果是最后一个节点，直接返回
        if (node.next == null) {
            this.head.next = node;
            return node;
        }
        // 将当前节点后面的节点反转
        Node next = reverse(node.next);
        // 让反转后的节点指向当前节点
        next.next = node;
        // 当前节点指向 null
        node.next = null;
        // 返回当前节点
        return node;
    }
}
