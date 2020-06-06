package com.mzx.algorithm.priority;

/**
 * 最大优先队列
 *
 * @param <T>
 */
public class MinPriorityQueue<T extends Comparable<T>> {
    /**
     * 默认容量
     */
    private final int DEFAULT_CAPACITY = 16;
    /**
     * 扩容比
     */
    private final double EXPANSION_RATIO = 0.75;
    /**
     * 队列
     */
    private T[] data;
    /**
     * 队列内元素个数
     */
    private int N;

    /**
     * 构造方法
     */
    @SuppressWarnings("unchecked")
    public MinPriorityQueue() {
        this.data = (T[]) new Comparable[this.DEFAULT_CAPACITY + 1];
        this.N = 0;
    }

    /**
     * 构造方法
     *
     * @param capacity 初始容量
     */
    @SuppressWarnings("unchecked")
    public MinPriorityQueue(int capacity) {
        this.data = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    /**
     * 获取队列的大小
     *
     * @return 队列的大小
     */
    public int size() {
        return this.N;
    }

    /**
     * 队列是否为空
     *
     * @return true / false;
     */
    public boolean isEmpty() {
        return this.N == 0;
    }

    /**
     * 入队
     *
     * @param t {@link T}
     */
    public void offer(T t) {
        this.data[++this.N] = t;
        this.expansion();
        this.rise(this.N);
    }

    /**
     * 上浮元素
     *
     * @param index 索引
     */
    private void rise(int index) {
        while (index > 1 && this.great(index / 2, index)) {
            this.swap(index / 2, index);
            index /= 2;
        }
    }

    /**
     * 出队
     *
     * @return {@link T}
     */
    public T poll() {
        T max = this.data[1];
        this.swap(1, this.N--);
        this.sink(1);
        return max;
    }

    /**
     * 下沉元素
     *
     * @param index 索引
     */
    private void sink(int index) {
        while (index * 2 <= this.N) {
            int maxIndex = index * 2;
            if (index * 2 + 1 <= this.N && this.great(maxIndex, index * 2 + 1)) {
                maxIndex = index * 2 + 1;
            }
            if (this.great(maxIndex, index)) {
                break;
            }
            this.swap(index, maxIndex);
            index = maxIndex;
        }
    }

    /**
     * 检测扩容
     */
    @SuppressWarnings("unchecked")
    private void expansion() {
        Integer newLength = null;
        if (this.N + 1 < this.data.length * (1 - this.EXPANSION_RATIO)) {
            newLength = this.data.length >> 1;
        }
        if (this.N + 1 > this.data.length * this.EXPANSION_RATIO) {
            newLength = this.data.length << 1;
        }
        if (newLength != null) {
            T[] newList = (T[]) new Comparable[newLength];
            if (N >= 0) System.arraycopy(this.data, 0, newList, 0, N + 1);
            this.data = newList;
        }
    }

    /**
     * 比较索引 i 和索引 j 处元素大小
     *
     * @param i 索引
     * @param j 索引
     * @return true / false;
     */
    private boolean great(int i, int j) {
        return data[i].compareTo(data[j]) > 0;
    }

    /**
     * 交换数组 i 和 j 位置的元素
     *
     * @param i 索引
     * @param j 索引
     */
    private void swap(int i, int j) {
        if (i == j) return;
        T temp;
        temp = this.data[i];
        this.data[i] = this.data[j];
        this.data[j] = temp;
    }
}
