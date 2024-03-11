package com.lacheln.stack;

import com.lacheln.array.Array;

/**
 * ArrayStack
 *
 * @author chenchao
 * @date 2024/3/8
 * @since 1.0.0
 * 基于动态数组实现栈
 */
public class ArrayStack<E> implements Stack<E> {
    Array<E> array; //成员变量

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e); // 向数组末尾添加元素
    }

    @Override
    public E pop() {
        return array.removeLast(); //取出最后1个元素
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack：");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(",");
            }
        }
        res.append("]top");
        return res.toString();
    }
}
