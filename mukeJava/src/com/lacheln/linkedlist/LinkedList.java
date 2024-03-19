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

}
