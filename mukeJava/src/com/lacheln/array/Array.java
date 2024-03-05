package com.lacheln.array;

import java.util.Arrays;

/**
 * Array
 *
 * @author chenchao
 * @date 2024/3/5
 * @since 1.0.0
 * 二次封装数组
 */
public class Array {
    private int[] data;
    private int size;

    /**
     * @param capacity 构造函数，传入数组容量capacity构造Array
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参构造函数，默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * @param staticArray 构造函数，传入静态数组初始化 Array 对象
     */
    public Array(int[] staticArray) {
        data = staticArray.clone(); //使用 clone() 方法复制静态数组以防止直接引用
        size = staticArray.length;
    }

    /**
     * @return 获取数组中的元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * @return 获取数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * @return 返回数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * @return 定义打印输出格式
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array：size = %d , capacity = %d\n"), size, data.length);
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(',');
            }
        }
        res.append(']');
        return res.toString();
    }
}
