package com.lacheln.linear;

/**
 * LinearSearch
 * 测试算法性能
 *
 * @author chaochen
 * @date 2023/12/22
 * @since 1.0.0
 */
public class LinearSearchTest {
    private LinearSearchTest() {
    }

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        //比较不同n的结果
        int[] dataSize = {100000, 1000000};
        for (int n : dataSize) {
//        int n = 100000; //0.007858792s
            Integer[] data = ArrayGenerator.generateOrderedArray(n);


            //计时
            //单位：纳秒
            long startTime = System.nanoTime();
            //希望得到的时间更长
            //增加循环 针对元素查找工作，进行100次。
            //执行100次相对，对于这100次的执行时间，相对于而言比较稳定。
            //减少测试一两次，可能因为操作系统原因，或者计算机当前的状态，产生的各种原因，造成的很大的偏差。
            for (int k = 0; k < 100; k++) {
                LinearSearchTest.<Integer>search(data, n);
            }
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + n + ",100 runs :" + time + "s"); //n = 100000,100 runs :0.027022s

            //n = 100000,100 runs :0.025753291s
            //n = 1000000,100 runs :0.068709042s
        }
    }
}

