package com.lacheln.queue;

/**
 * LinkedListQueue
 *
 * @author chenchao
 * @date 2024/3/21
 * @since 1.0.0
 * 带有尾指针的链表-使用链表实现队列
 */
public class LinkedListQueue<E> implements Queue<E> {
    /**
     * 定义链表节点
     */
    private class Node() {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void enqueue(E e){
        if (tail == null){
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }
}
