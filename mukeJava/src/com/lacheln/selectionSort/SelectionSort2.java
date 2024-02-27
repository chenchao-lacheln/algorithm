package com.lacheln.selectionSort;

import javax.management.RuntimeErrorException;

/**
 * SelectionSort2
 *
 * @author chaochen
 * @date 2023/12/27
 * @since 1.0.0
 * 泛型方法，可以对任意类型数据进行排序
 * 对于类型的约束必须是可比较的，表现为 实现 Comparable 接口。
 */
public class SelectionSort2 {
    private SelectionSort2() {
    }

    /*
    1.让E 类型 实现 Comparable
    2.对于泛型约束来说，extends用在类上，表示继承某一个类，用在泛型，表示实现某一个接口。
    3.在java中，实现了 Comparable 接口，则表示该类是可比较的。
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                // 1.报错Operator '<' cannot be applied to 'E', 'E'
                // 2.E 类型一定可以使用 < 符号进行比较，因此需要对 E 这个泛型进行约束，通过约束让泛型是可比较的。
                // compareTo 返回的是一个整形，整形<0,代表 arr[j] < arr[minIndex]
                //                             整形=0,代表 arr[j] = arr[minIndex]
                //                             整形>0,代表 arr[j] > arr[minIndex]
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        //当前 arr接收的是一个泛型数组，泛型要求必须是一个类，不能是基本数据类型。 int[] arr 修改为  Integer[] arr
        int n = 10000;
        //生成10000个随机数，随机数的范围是[0,10000)
        Integer[] arr = ArrayGenerator.generateRandomArray(n,n);

//        //对排序进行计时
//        long startTime = System.nanoTime();
//        SelectionSort2.sort(arr);
//        long endTime = System.nanoTime();
//        //从纳秒换算成秒，1*10(9次方)
//        double time = (endTime - startTime)/1000000000.0;
////        for (int e : arr) {
////            System.out.print(e + " ");
////        }
//        //判断排序算法正确性
//        if (!SortingHelper.isSorted(arr)){
//            /*
//            Exception in thread "main" java.lang.RuntimeException: SelectionSort failed
//            at com.lacheln.selectionSort.SelectionSort2.main(SelectionSort2.java:63)
//             */
//            throw new RuntimeException("SelectionSort failed");
//        }
//        //打印时间
//        System.out.println(time + "s"); //0.097188959s

        SortingHelper.sortTest("SelectionSort2",arr); //SelectionSort2,n = 10000 : 0.150676 s
    }
}
