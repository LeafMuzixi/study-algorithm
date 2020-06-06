package com.mzx.algorithm.priority;

import java.util.Arrays;

/**
 * 最大优先队列
 *
 * @param <T>
 */
public class IndexMinPriorityQueue<T extends Comparable<T>> {
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
     * 存储每个元素在 data 中的索引，堆有序
     */
    private int[] heap;
    /**
     * 存储每个元素在 heap 中的索引
     */
    private int[] indexArr;
    /**
     * 队列内元素个数
     */
    private int N;

    /**
     * 构造方法
     */
    @SuppressWarnings("unchecked")
    public IndexMinPriorityQueue() {
        this.data = (T[]) new Comparable[this.DEFAULT_CAPACITY + 1];
        this.heap = new int[this.DEFAULT_CAPACITY + 1];
        this.indexArr = new int[this.DEFAULT_CAPACITY + 1];
        Arrays.fill(indexArr, -1);
        this.N = 0;
    }

    /**
     * 构造方法
     *
     * @param capacity 初始容量
     */
    @SuppressWarnings("unchecked")
    public IndexMinPriorityQueue(int capacity) {
        this.data = (T[]) new Comparable[capacity + 1];
        this.heap = new int[capacity + 1];
        this.indexArr = new int[capacity + 1];
        Arrays.fill(indexArr, -1);
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
        this.data[this.N++] = t;
        this.heap[this.N] = this.N - 1;
        this.indexArr[this.N - 1] = this.N;
        this.expansion();
        this.rise(this.N);
    }

    /**
     * 在 index 索引处插入值
     *
     * @param index 插入索引
     * @param t     {@link T}
     */
    public void insert(int index, T t) {
        if (index > this.N) {
            return;
        }
        System.arraycopy(this.data, index, this.data, index + 1, this.N - index);
        this.data[index] = t;
        this.N++;
        for (int i = 1; i <= this.N; i++) {
            if (this.heap[i] >= index) {
                this.heap[i]++;
            }
            this.indexArr[this.heap[i]] = i;
        }
        this.heap[this.N] = index;
        this.expansion();
        rise(this.N);
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
        int index = this.heap[1];
        T min = this.data[index];
        System.arraycopy(this.data, index + 1, this.data, index, this.N - index);
        this.swap(1, this.N--);
        if (this.N > 1) {
            for (int i = 1; i <= this.N; i++) {
                if (this.heap[i] >= index) {
                    this.heap[i]--;
                }
                this.indexArr[this.heap[i]] = i;
            }
        }
        this.sink(1);
        return min;
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
     * 获取最小值索引
     *
     * @return 最小值索引
     */
    public int minIndex() {
        return this.heap[1];
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
            T[] newData = (T[]) new Comparable[newLength];
            int[] newHeap = new int[newLength];
            int[] newIndexArr = new int[newLength];
            if (N >= 0) System.arraycopy(this.data, 0, newData, 0, N + 1);
            if (N >= 0) System.arraycopy(this.heap, 0, newHeap, 0, N + 1);
            if (N >= 0) System.arraycopy(this.indexArr, 0, newIndexArr, 0, N + 1);
            this.data = newData;
            this.heap = newHeap;
            this.indexArr = newIndexArr;
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
        return data[heap[i]].compareTo(data[heap[j]]) > 0;
    }

    /**
     * 交换数组 i 和 j 位置的元素
     *
     * @param i 索引
     * @param j 索引
     */
    private void swap(int i, int j) {
        if (i == j) return;
        int temp;
        temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
        this.indexArr[this.heap[i]] = i;
        this.indexArr[this.heap[j]] = j;
    }
}
