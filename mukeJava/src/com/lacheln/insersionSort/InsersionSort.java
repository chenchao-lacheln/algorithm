package com.lacheln.insersionSort;

import com.lacheln.selectionSort.ArrayGenerator;
import com.lacheln.selectionSort.SortingHelper;

import java.util.Arrays;

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

    /**
     * 通过遍历找到arr[i]和不断交换位置，存在对应的位置
     *
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //将arr[i]插入到合适的位置
            //j从i的位置向前比较，
//            for (int j = i; j - 1 >= 0; j--)
//                if (arr[j].compareTo(arr[j - 1]) < 0) {
//                    swap(arr, j, j - 1);
//                } else break;
            //优化代码： arr[j].compareTo(arr[j-1]) > 0 也是属于循环体终止的条件，可以直接添加在条件中，就去掉了break。
            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    /**
     * 暂存arr[i],通过索引找到暂存的arr[i]应该插入的位置。
     *
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E t = arr[i]; //暂存
            int j;
            for (j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1]; //通过赋值，实现平移
            }
            arr[j] = t;
        }
    }
    /*
    InsersionSort,n = 10000 : 0.070467 s
    InsersionSort2,n = 10000 : 0.060969 s
    InsersionSort,n = 100000 : 12.834445 s
    InsersionSort2,n = 100000 : 5.395791 s
    可以发现优化之后，速度还是挺快的的。可能和jvm底层的优化相关。
     */

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        /*
        InsersionSort,n = 10000 : 0.069656 s
        InsersionSort,n = 100000 : 12.591603 s
         */
        int[] dataSize = {10000, 100000};
        //对于随机数组，针对插入排序和选择排序进行测试
        System.out.println("Random Array：");
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length); //完全拷贝arr数组
            SortingHelper.sortTest("InsersionSort2", arr);
            SortingHelper.sortTest("SelectionSort2", arr2);

            System.out.println(); //回车

            //对于有序数组，针对插入排序和选择排序进行测试
            System.out.println("Ordered Array：");
            arr = ArrayGenerator.generateOrderedArray(n);
            arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("InsersionSort2", arr);
            SortingHelper.sortTest("SelectionSort2", arr2);

            System.out.println();

            /*
            测试结果如下：
            Random Array：
            InsersionSort2,n = 10000 : 0.112498 s
            SelectionSort2,n = 10000 : 0.094814 s

            Ordered Array：
            InsersionSort2,n = 10000 : 0.000331 s
            SelectionSort2,n = 10000 : 0.088320 s

            InsersionSort2,n = 100000 : 6.188667 s
            SelectionSort2,n = 100000 : 5.815516 s

            Ordered Array：
            InsersionSort2,n = 100000 : 0.000527 s
            SelectionSort2,n = 100000 : 7.036710 s
             */
        }
    }
}
