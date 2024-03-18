package com.lacheln.queue;

import java.util.Random;

/**
 * Main
 *
 * @author chenchao
 * @date 2024/3/18
 * @since 1.0.0
 * 数组队列和循环队列的比较
 */
public class Main {
    /**
     * @param q
     * @param opCount
     * @return 测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位：秒
     */
    private static double testQueue(Queue<Integer> q, int opCount) {
        long satrtTime = System.nanoTime();
        Random random = new Random();
        //进行入队操作
        for (int i = 0; i < opCount; i++) {
            //入队，随机入队1个随机数，生成0-Integet之间的一个最大数
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        //出队
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - satrtTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        //设置操作数量
        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time:" + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time:" + time2 + " s");

        /*
        ArrayQueue, time:2.318396625 s
        LoopQueue, time:0.020657292 s
         关于可性度这一块：可能情况下，应该运行100次，然后取平均数。
         不通的java版本，jvm不一样，可能运行结果也不一样。
         */
    }
}
