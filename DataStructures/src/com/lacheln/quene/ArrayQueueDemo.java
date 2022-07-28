package com.lacheln.quene;

/**
 * ArrayQueneDemo
 *
 * @author lacheln
 * @date 2022/7/29 00:41
 * @since 1.0.0
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {

    }
}

//使用数组模拟队列 --编写ArrayQueue
class ArrayQueue {
    private int maxSize; //表示数组的最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //用户存放数据，模拟队列

    //创建队列构造器
    public ArrayQueue (int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部，分析front是指向队列头的前一个位置
        rear = -1; //指向队列尾部，指向队列尾的数据（即 就是队列最后一个数据）
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if (isFull()){
            System.out.println("队列满，不能添加数据~");
            return;
        }
        rear++; //让rear 后移
        arr[rear] = n;
    }

    //获取队列数据，出队列
    public int getQueue(){
        //判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        front++; //front 后移
        return arr[front];
    }

    //显示队列所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据~");
            return;
        }
        for (int i = 0;i < arr.length;i++){
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
        }
    }

    //显示队列的头数据，不是取数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据~");
        }
        return arr[front + 1];
    }

}
