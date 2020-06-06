package com.mzx.algorithm.sort;

/**
 * 希尔排序
 */
public class Shell {
    /**
     * 对数组 arr 中的元素进行排序
     *
     * @param arr {@link T}
     * @param <T> {@link Comparable}
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        // 1.根据数组 arr 长度确定 h 初始值
        int h = (arr.length + 1) / 2;
        // 2.希尔排序
        while (h >= 1) {
            // 排序
            // 2.1 找到待插入元素
            for (int i = h; i < arr.length; i++) {
                for (int j = i - h; j >= 0; j -= h) {
                    if (greater(arr[j], arr[j + h])) {
                        swap(arr, j, j + h);
                    } else {
                        break;
                    }
                }
            }
            // 减小 h 的值
            h /= 2;
        }
    }

    /**
     * 比较 c1 元素是否大于 c2 元素
     *
     * @param c1  {@link T}
     * @param c2  {@link T}
     * @param <T> {@link Comparable}
     * @return true / false;
     */
    private static <T extends Comparable<T>> boolean greater(T c1, T c2) {
        return c1.compareTo(c2) > 0;
    }

    /**
     * 交换数组 i 和 j 位置的元素
     *
     * @param arr {@link T}
     * @param i   索引
     * @param j   索引
     * @param <T> {@link Comparable}
     */
    private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        if (i == j) return;
        T temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
