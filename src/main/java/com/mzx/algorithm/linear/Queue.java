package com.mzx.algorithm.linear;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * 链表队列
 *
 * @param <T>
 */
public class Queue<T> implements Iterable<T> {
    /**
     * 头节点
     */
    private Node head;
    /**
     * 尾节点
     */
    private Node last;
    /**
     * 栈大小
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
    public Queue() {
        this.head = new Node(null, null);
        this.last = this.head;
        this.N = 0;
    }

    /**
     * 判断队列是否为空
     *
     * @return true / false;
     */
    public boolean isEmpty() {
        return this.N == 0;
    }

    /**
     * 获取队列大小
     *
     * @return 队列内元素数量
     */
    public int size() {
        return this.N;
    }

    /**
     * 入队
     *
     * @param t {@link T}
     */
    public void offer(T t) {
        this.last.next = new Node(t, null);
        this.last = this.last.next;
        this.N++;
    }

    /**
     * 出队
     *
     * @return {@link T}
     */
    public T poll() {
        if (this.isEmpty()) return null;
        Node result = this.head.next;
        this.head.next = result.next;
        this.N--;
        return result.data;
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
