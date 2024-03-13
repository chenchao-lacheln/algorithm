package com.lacheln.stack;

/**
 * Stack
 *
 * @author chenchao
 * @date 2024/3/8
 * @since 1.0.0
 */
public interface Stack<E> {
    /**
     * 查看栈中元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 栈元素是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 入栈：向栈中添加元素
     *
     * @param e
     */
    void push(E e);

    /**
     * 出栈：从栈中取出元素
     *
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     *
     * @return
     */
    E peek();
}
