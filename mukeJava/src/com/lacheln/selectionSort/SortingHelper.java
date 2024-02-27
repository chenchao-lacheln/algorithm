package com.lacheln.selectionSort;

/**
 * SortingHelper
 *
 * @author chenchao
 * @date 2024/2/27
 * @since 1.0.0
 * 排序了10000次，如何验证这10000次排序是不是真正的排序了？
 * 排序数组是否有限
 */
public class SortingHelper {
    private SortingHelper() {
    }

    //判断有序必须是可比较的，因此需要实现Comparable
    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        //为什么从1开始？因为每次都要比较先0和1的大小
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}
