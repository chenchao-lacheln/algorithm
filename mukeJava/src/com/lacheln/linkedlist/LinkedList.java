package com.lacheln.linkedlist;

/**
 * LinkedList
 *
 * @author chenchao
 * @date 2024/3/19
 * @since 1.0.0
 * 链表——动态数据结构
 */
public class LinkedList<E> {
    /**
     * 私有内部类：组成链表的节点
     */
    private class Node {
        public E e;
        public Node next;

        /**
         * 构造函数
         *
         * @param e
         * @param next
         */
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        /**
         * @param e
         */
        public Node(E e) {
            this(e, null);
        }

        /**
         *
         */
        public Node() {
            this(null, null);
        }

        /**
         * @return
         */
        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;//链表头
    private int size;//链表元素个数

    public LinkedList() {
        dummyHead = new Node(null, null); //虚拟头节点
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index(0-based) 位置添加新的元素e
     * 在链表中不是一个常用的操作，练习用：
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("Add failed . Illegal index .");
        }
        //特殊处理头节点
//        if (index == 0) {
//            addFirst(e);
//        } else {
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//        Node node = new Node(e);
//        node.next = prev.next;
//        prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;
//        }
    }

    /**
     * 在链表头添加新元素e
     *
     * @param e
     */
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
//        dummyHead = new Node(e, dummyHead);
//        size++;
        add(0, e);
    }

    /**
     * 在链表末尾添加新的元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取链表的第index(0-based) 个位置的元素
     * 在链表中不是一个常用的操作，练习用：
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表的第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表的最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表的第index(0-based) 个位置的元素为e
     * 在链表中不是一个常用的操作，练习用：
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否有元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            } else {
                cur = cur.next;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        Node cur = dummyHead.next;
//        while (cur != null) {
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL");
        return res.toString();
    }
}
