package com.mzx.algorithm.heap;

/**
 * 堆
 *
 * @param <T>
 */
public class Heap<T extends Comparable<T>> {
    /**
     * 默认容量
     */
    private final int DEFAULT_CAPACITY = 16;
    /**
     * 扩容比
     */
    private final double EXPANSION_RATIO = 0.75;
    /**
     * 堆
     */
    private T[] data;
    /**
     * 堆内元素个数
     */
    private int N;

    /**
     * 构造方法
     */
    @SuppressWarnings("unchecked")
    public Heap() {
        this.data = (T[]) new Comparable[this.DEFAULT_CAPACITY + 1];
        this.N = 0;
    }

    /**
     * 构造方法
     *
     * @param capacity 初始容量
     */
    @SuppressWarnings("unchecked")
    public Heap(int capacity) {
        this.data = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    /**
     * 获取堆的大小
     *
     * @return 堆的大小
     */
    public int size() {
        return this.N;
    }

    /**
     * 添加元素
     *
     * @param t {@link T}
     */
    public void add(T t) {
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
        while (index > 1 && this.less(index / 2, index)) {
            this.swap(index / 2, index);
            index /= 2;
        }
    }

    /**
     * 删除最大元素
     *
     * @return {@link T}
     */
    public T removeMax() {
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
            if (index * 2 + 1 <= this.N && this.less(maxIndex, index * 2 + 1)) {
                maxIndex = index * 2 + 1;
            }
            if (this.less(maxIndex, index)) {
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
        if (this.N < this.data.length * (1 - this.EXPANSION_RATIO)) {
            newLength = this.data.length >> 1;
        }
        if (this.N > this.data.length * this.EXPANSION_RATIO) {
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
    private boolean less(int i, int j) {
        return data[i].compareTo(data[j]) < 0;
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
