package com.mzx.algorithm.heap;

/**
 * 堆排序
 */
public class HeapSort {
    public static <T extends Comparable<T>> void sort(T[] arr) {
        int end = arr.length;
        int index = end / 2;
        while (index >= 0) {
            sink(arr, index--, end);
        }
        while (end > 0) {
            swap(arr, 0, end - 1);
            sink(arr, 0, --end);
        }
    }

    /**
     * 下沉
     *
     * @param arr    数组
     * @param target 下沉索引
     * @param end    终止索引
     */
    private static <T extends Comparable<T>> void sink(T[] arr, int target, int end) {
        int index = target;
        while (index * 2 + 1 < end) {
            int maxIndex = index * 2 + 1;
            if (index * 2 + 2 < end && less(arr, maxIndex, index * 2 + 2)) {
                maxIndex = index * 2 + 2;
            }
            if (less(arr, maxIndex, index)) {
                break;
            }
            swap(arr, index, maxIndex);
            index = maxIndex;
        }
    }

    /**
     * 比较 arr 数组中两索引处值大小
     *
     * @param arr    数组
     * @param index1 索引1
     * @param index2 索引2
     * @return true / false;
     */
    private static <T extends Comparable<T>> boolean less(T[] arr, int index1, int index2) {
        return arr[index1].compareTo(arr[index2]) < 0;
    }

    /**
     * 交换 arr 数组中两索引处值
     *
     * @param arr    数组
     * @param index1 索引1
     * @param index2 索引2
     */
    private static <T extends Comparable<T>> void swap(T[] arr, int index1, int index2) {
        if (index1 >= arr.length || index2 >= arr.length) return;
        T t = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = t;
    }
}
