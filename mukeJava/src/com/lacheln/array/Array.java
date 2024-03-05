package com.lacheln.array;


/**
 * Array
 *
 * @author chenchao
 * @date 2024/3/5
 * @since 1.0.0
 * 二次封装数组
 */
public class Array {
    private int[] data; //数组名
    private int size; //数组索引

    /**
     * @param capacity 构造函数，传入数组容量capacity构造Array
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参构造函数，默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * @param staticArray 构造函数，传入静态数组初始化 Array 对象
     */
    public Array(int[] staticArray) {
        data = staticArray.clone(); //使用 clone() 方法复制静态数组以防止直接引用
        size = staticArray.length;
    }

    /**
     * @return 获取数组中的元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * @return 获取数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * @return 返回数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param e 向数组末添加新元素e
     */
    public void addLast(int e) {
        //注意：在添加新元素的时候，需要注意查看数组是否还有空间可以添加新的元素。
//        if (size == data.length) {
//            throw new IllegalArgumentException("AddLast failed. Array is full.");
//        }
//        //data[size++] = e;
//        data[size] = e;
//        size++;
        add(size, e);
    }

    /**
     * 在所有元素前，添加1个新元素e
     *
     * @param e
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * @param index
     * @param e     向指定位置index添加新元素e
     */
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("AddLast failed. Array is full.");
        }
        //判断index合法性
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed. Require index >=0 and index <= size.");
        }
        //1.从最后1个元素开始进行遍历
        //2.条件就是i大于要插入的位置的索引
        //3.每1个元素都向后，挪动1个位置
        for (int i = size - 1; i > index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * @return 定义打印输出格式
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array：size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(',');
            }
        }
        res.append(']');
        return res.toString();
    }
}
