package com.lacheln.queue;

/**
 * Queue
 *
 * @author chenchao
 * @date 2024/3/12
 * @since 1.0.0
 * 队列接口
 */
public interface Queue<E> {
    /**
     * 查看队列中元素个数
     *
     * @return
     */
    int getSize();

    /**
     * 队列是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 入队：向队列中添加元素
     *
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队：从队列中取出元素
     *
     * @return
     */
    E dequeue();

    /**
     * 查看队首元素
     *
     * @return
     */
    E getFront();
}
