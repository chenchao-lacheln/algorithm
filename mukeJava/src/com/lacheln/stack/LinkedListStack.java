package com.lacheln.stack;

import com.lacheln.linkedlist.LinkedList;

/**
 * LinkedListStack
 *
 * @author chenchao
 * @date 2024/3/20
 * @since 1.0.0
 * 使用链表实现栈
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
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
