package com.lacheln.linear;

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
}
