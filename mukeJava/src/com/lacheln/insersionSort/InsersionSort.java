package com.lacheln.insersionSort;

import com.lacheln.selectionSort.ArrayGenerator;
import com.lacheln.selectionSort.SortingHelper;

/**
 * InsersionSort
 *
 * @author chenchao
 * @date 2024/3/3 23:35
 * @since 1.0.0
 * 实现插入排序法
 */
public class InsersionSort {
    private InsersionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //将arr[i]插入到合适的位置
            //j从i的位置向前比较，
            for (int j = i; j - 1 >= 0; j--)
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else break;
        }
    }
    private static <E> void swap(E[] arr,int i,int j){
        E t = arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

    public static void main(String[] args) {
        /*
        InsersionSort,n = 10000 : 0.069656 s
        InsersionSort,n = 100000 : 12.591603 s
         */
        int[] dataSize = {10000,100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("InsersionSort", arr);
        }
    }
}
