package com.mzx.algorithm.linear;


import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * 线性表
 *
 * @param <T>
 */
public class SequenceList<T> implements Iterable<T> {
    /**
     * 默认容量
     */
    private final int DEFAULT_CAPACITY = 16;
    /**
     * 扩容比
     */
    private final double EXPANSION_RATIO = 0.75;
    /**
     * 存储元素的数组
     */
    private Object[] list;
    /**
     * 记录数组中元素的个数
     */
    private int N;

    /**
     * 构造方法
     */
    public SequenceList() {
        // 初始化数组
        this.list = new Object[this.DEFAULT_CAPACITY];
        // 初始化长度
        this.N = 0;
    }

    /**
     * 构造方法
     *
     * @param capacity 初始容量
     */
    public SequenceList(int capacity) {
        // 初始化数组
        this.list = new Object[capacity];
        // 初始化长度
        this.N = 0;
    }

    /**
     * 获取线性表长度
     *
     * @return 长度
     */
    public int capacity() {
        return this.list.length;
    }

    /**
     * 将一个线性表置为空表
     */
    public void clear() {
        this.N = 0;
    }

    /**
     * 判断当前线性表是否为空表
     *
     * @return true / false;
     */
    public boolean isEmpty() {
        return this.N == 0;
    }

    /**
     * 获取线性表的长度
     *
     * @return 线性表的长度
     */
    public int length() {
        return this.N;
    }

    /**
     * 获取指定位置的元素
     *
     * @param index 索引
     * @return {@link T}
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index > this.N) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) list[index];
    }

    /**
     * 向线性表中插入元素
     *
     * @param t {@link T}
     */

    public void insert(T t) {
        this.list[N++] = t;
        this.expansion();
    }

    /**
     * 向线性表中 index 索引处插入元素
     *
     * @param index 插入索引
     * @param t     {@link T}
     */
    public void insert(int index, T t) {
        if (index < 0 || index > this.N) {
            throw new ArrayIndexOutOfBoundsException();
        }
        System.arraycopy(this.list, index, this.list, index + 1, N - index);
        N++;
        this.list[index] = t;
        this.expansion();
    }

    /**
     * 检测扩容
     */
    @SuppressWarnings("unchecked")
    private void expansion() {
        Integer newLength = null;
        if (this.N < this.list.length * (1 - this.EXPANSION_RATIO)) {
            newLength = this.list.length >> 1;
        }
        if (this.N > this.list.length * this.EXPANSION_RATIO) {
            newLength = this.list.length << 1;
        }
        if (newLength != null) {
            T[] newList = (T[]) new Object[newLength];
            if (N >= 0) System.arraycopy(this.list, 0, newList, 0, N);
            this.list = newList;
        }
    }

    /**
     * 从线性表中删除 index 索引处的元素
     *
     * @param index 删除索引
     * @return 删除的元素 {@link T}
     */
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index > this.N) {
            throw new ArrayIndexOutOfBoundsException();
        }
        // 记录索引 index 处的值
        Object o = this.list[index];
        System.arraycopy(this.list, index + 1, this.list, index, N - index - 1);
        N--;
        this.expansion();
        return (T) o;
    }

    /**
     * 查找线性表中 index 索引处的元素
     *
     * @param t 查找的元素 {@link T}
     * @return 索引
     */
    public int indexOf(T t) {
        for (int i = 0; i < this.N; i++) {
            if (this.list[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return this.current < N;
            }

            @SuppressWarnings("unchecked")
            @Override
            public T next() {
                return (T) list[current++];
            }
        };
    }
}
