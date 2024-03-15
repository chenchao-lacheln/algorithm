package com.lacheln.queue;


/**
 * LoopQueue
 *
 * @author chenchao
 * @date 2024/3/15
 * @since 1.0.0
 * 循环队列
 */
public class LoopQueue<E> implements Queue<E> {
    //E类型数据
    private E[] data;
    //队首索引和队尾索引
    private int front, tail;
    //队列元素数量
    // （注意：front和tail也可以表述队列的元素数量，因此可以不需要当前变量，算法逻辑有坑。添加当前变量，可以让逻辑更清晰。）
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1]; //+1是为了保证循环队列有足够的空间给用户，循环队列会浪费1个空间
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    /**
     * 获取队列最多可以承载的元素个数
     *
     * @return
     */
    public int getCapacity() {
        return data.length - 1; //因为会浪费1个元素 需要-1
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 获取队列元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 入队
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        //判断队列是否填满
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
    }

    /**
     * 扩容
     *
     * @param newCapacity 传入新的容积
     */
    private void resize(int newCapacity) {
        //开辟新的数组空间
        E[] newData = (E[]) new Object[newCapacity + 1];
        //将原数据放入新数组，% data.length避免数组越界
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }
}
