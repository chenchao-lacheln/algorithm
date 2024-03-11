package com.lacheln.stack;

/**
 * Main
 *
 * @author chenchao
 * @date 2024/3/11
 * @since 1.0.0
 * 测试栈
 */
public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        //推入5个元素，测试入栈
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        //出栈测试
        stack.pop();
        System.out.println(stack);
    }
}
