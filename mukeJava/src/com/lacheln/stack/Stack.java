package com.lacheln.stack;

/**
 * Stack
 *
 * @author chenchao
 * @date 2024/3/8
 * @since 1.0.0
 */
public interface Stack<E> {
    //返回int型
    int getSize();
    //返回boolean型
    boolean isEmpty();
    //向栈中添加元素
    void push(E e);
    //从栈中取出元素
    E pop();
    //查看栈顶元素
    E peek();
}
