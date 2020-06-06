package com.mzx.algorithm.sort;

/**
 * 归并排序
 */
public class Merge {
    private static Comparable<?>[] assist;

    /**
     * 对数组 arr 中的元素进行排序
     *
     * @param arr {@link T}
     * @param <T> {@link Comparable}
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        // 1.初始化辅助数组
        assist = new Comparable[arr.length];
        // 2.调用 sort 重载方法完成从数组 arr 中从 low 到 high 位置元素的排序
        sort(arr, 0, arr.length);
    }

    /**
     * 对数组 arr 中从 low 到 high 的元素进行排序
     *
     * @param arr  {@link T}
     * @param low  起始索引
     * @param high 结束索引
     * @param <T>  {@link Comparable}
     */
    public static <T extends Comparable<T>> void sort(T[] arr, int low, int high) {
        // 安全校验
        if (low >= high - 1) return;
        // 对 low 到 high 之间的数据分为两个组
        int mid = (low + high) / 2;
        // 分别对每一组进行排序
        sort(arr, low, mid);
        sort(arr, mid, high);
        // 合并两组数据
        merge(arr, low, mid, high);
    }

    /**
     * 对数组 arr 中从 low 到 mid 为一组，mid 到 high 为一组，对这两组进行归并
     *
     * @param arr  {@link T}
     * @param low  起始索引
     * @param mid  中间索引
     * @param high 结束索引
     * @param <T>  {@link Comparable}
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void merge(T[] arr, int low, int mid, int high) {
        // 1.定义三个指针
        int index = low;
        int leftIndex = low;
        int rightIndex = mid;
        while (leftIndex < mid && rightIndex < high) {
            if (less(arr[leftIndex], arr[rightIndex])) {
                assist[index++] = arr[leftIndex++];
            } else {
                assist[index++] = arr[rightIndex++];
            }
        }
        while (leftIndex < mid) {
            assist[index++] = arr[leftIndex++];
        }
        while (rightIndex < high) {
            assist[index++] = arr[rightIndex++];
        }
        for (int i = low; i < high; i++) {
            if (assist.getClass().isAssignableFrom(arr.getClass())) {
                arr[i] = (T) assist[i];
            }
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
    private static <T extends Comparable<T>> boolean less(T c1, T c2) {
        return c1.compareTo(c2) < 0;
    }
}
