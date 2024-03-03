package com.lacheln.selectionSort;

import com.lacheln.insersionSort.InsersionSort;

/**
 * SortingHelper
 *
 * @author chenchao
 * @date 2024/2/27
 * @since 1.0.0
 * 排序了10000次，如何验证这10000次排序是不是真正的排序了？
 * 排序数组是否有效
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

    /**
     * 测试任意排序类型
     * @param sortName
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr) {

        long startTime = System.nanoTime();
        // TODO: 2024/2/27 用java反射知识，解决如下问题
        if (sortName.equals("SelectionSort2")) {
            SelectionSort2.sort(arr);
        }else if (sortName.equals("InsersionSort")){
            InsersionSort.sort(arr);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortName + "failed");
        }
        //打印算法类型名称，算法数据规模，算法时间
        System.out.println(String.format("%s,n = %d : %f s",sortName,arr.length,time));
    }
}
