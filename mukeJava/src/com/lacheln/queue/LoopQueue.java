package com.lacheln.queue;


import java.util.Arrays;

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
    //元素个量
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
        //判断队列是否填满，扩容
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length; //tail 需要tail++，循环队列需要(tail+1) % data.length 处理
        size++;
    }

    /**
     * 出队
     *
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    /**
     * 查看队首元素
     *
     * @return
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[front];
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

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue：size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        //因为是循环队列，tail可能比front还小，所以i是不能取到tail的，即：i != tail
        //i++ 需要更改为循环的加1，即： i = (i + 1) % data.length
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(',');
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            //每插入3个队列，就取出一个元素
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
