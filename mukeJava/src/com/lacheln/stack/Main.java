package com.lacheln.stack;

import com.lacheln.queue.ArrayQueue;
import com.lacheln.queue.LoopQueue;
import com.lacheln.queue.Queue;

import java.util.Random;

/**
 * Main
 *
 * @author chenchao
 * @date 2024/3/11
 * @since 1.0.0
 * 测试栈
 */
public class Main {
    /**
     * 测试使用stack运行opCount个push和pop操作所需要的时间，单位：秒
     *
     * @param stack
     * @param opCount
     * @return
     */
    private static double testStack(Stack<Integer> stack, int opCount) {
        long satrtTime = System.nanoTime();
        Random random = new Random();
        //进行入队操作
        for (int i = 0; i < opCount; i++) {
            //入队，随机入队1个随机数，生成0-Integet之间的一个最大数
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        //出队
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - satrtTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        //设置操作数量
        int opCount = 100000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack, time:" + time1 + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("linkedListStack, time:" + time2 + " s");
    }

    //其实这个时间比较很复杂，因为LinkedListStack包含更多new操作
    /*
    ArrayStack, time:0.021655916 s
    linkedListStack, time:0.019679917 s

    结论：在复杂度方面没有太大差异。
     */


//    public static void main(String[] args) {
//        ArrayStack<Integer> stack = new ArrayStack<>();
//        //推入5个元素，测试入栈
//        for (int i = 0; i < 5; i++) {
//            stack.push(i);
//            System.out.println(stack);
//        }
//
//        //出栈测试
//        stack.pop();
//        System.out.println(stack);
//    }
}
