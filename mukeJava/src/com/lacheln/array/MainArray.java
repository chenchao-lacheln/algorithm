package com.lacheln.array;

/**
 * MainArray
 *
 * @author chenchao
 * @date 2024/3/5
 * @since 1.0.0
 * 使用自己封装的数组
 */
public class MainArray {
    public static void main(String[] args) {
        //测试字符串输出
        Array<Integer> array = new Array<Integer>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        //测试插入元素
        array.add(1,100);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);
        array.remove(2);
        System.out.println(array);
        array.removeElement(4);
        System.out.println(array);
        array.removeFirst();
        System.out.println(array);
    }
}
