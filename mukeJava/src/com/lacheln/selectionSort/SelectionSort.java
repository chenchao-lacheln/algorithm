package com.lacheln.selectionSort;

/**
 * SelectionSort
 *
 * @author chaochen
 * @date 2023/12/27
 * @since 1.0.0
 * 选择排序
 */
public class SelectionSort {
    private SelectionSort() {
    }


    public static void srot(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //选择arr[i...n)中的最小索引值
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    //交换位置
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3, 6, 5};
        SelectionSort.srot(arr);
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}