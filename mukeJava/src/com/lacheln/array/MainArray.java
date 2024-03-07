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
        Array<Integer> array = new Array<Integer>(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        /*
        Array：size = 10 , capacity = 20
        [0,1,2,3,4,5,6,7,8,9]
         */
        System.out.println(array);

        //测试插入元素
        array.add(1,100);
        /*
        Array：size = 11 , capacity = 20
        [0,100,1,2,3,4,5,6,7,8,9]
         */
        System.out.println(array);
        array.addFirst(-1);
        /*
        Array：size = 12 , capacity = 20
        [-1,0,100,1,2,3,4,5,6,7,8,9]
         */
        System.out.println(array);
        array.remove(2);
        System.out.println(array);
        array.removeElement(4);
        System.out.println(array);
        array.removeFirst();
        System.out.println(array);
    }
}
