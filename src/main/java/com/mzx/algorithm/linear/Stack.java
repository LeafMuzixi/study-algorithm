package com.mzx.algorithm.linear;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * 链表栈
 *
 * @param <T>
 */
public class Stack<T> implements Iterable<T> {
    /**
     * 头节点
     */
    private Node head;
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
    public Stack() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    /**
     * 判断栈是否为空
     *
     * @return true / false;
     */
    public boolean isEmpty() {
        return this.N == 0;
    }

    /**
     * 获取栈大小
     *
     * @return 栈内元素数量
     */
    public int size() {
        return this.N;
    }

    /**
     * 入栈
     *
     * @param t {@link T}
     */
    public void push(T t) {
        this.head.next = new Node(t, this.head.next);
        this.N++;
    }

    /**
     * 出栈
     *
     * @return {@link T}
     */
    public T pop() {
        if (this.N == 0) return null;
        Node next = this.head.next;
        this.head.next = next.next;
        N--;
        return next.data;
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
