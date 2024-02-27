package com.lacheln.selectionSort;

import java.util.Random;

/**
 * ArrayGenerator
 * 数组生成器：用于生成数组
 *
 * @author chaochen
 * @date 2023/12/23
 * @since 1.0.0
 */
public class ArrayGenerator {

    private ArrayGenerator() {
    }

    //生成一个数组，数组元素是顺序的。
    public static Integer[] generateOrderedArray(int n) {

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 测试排序算法：生成一个长度为n的随机数组每个数字的范围是[0,bound)
     *
     * @param n     随机数组长度
     * @param bound 随机数的最大数值（随机数最大的边界值）
     * @return 返回数组
     */
    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random rnd = new Random(bound);
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(bound);
        }
        return arr;
    }
}
