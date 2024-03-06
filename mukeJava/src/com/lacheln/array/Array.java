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
     * 构造函数，传入数组容量capacity构造Array
     *
     * @param capacity
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
     * 构造函数，传入静态数组初始化 Array 对象
     *
     * @param staticArray
     */
    public Array(int[] staticArray) {
        data = staticArray.clone(); //使用 clone() 方法复制静态数组以防止直接引用
        size = staticArray.length;
    }

    /**
     * 获取数组中的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组末添加新元素e
     *
     * @param e
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
     * 向指定位置index添加新元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed. Array is full.");
        }
        //判断index合法性
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >=0 and index <= size.");
        }
        //1.从最后1个元素开始进行遍历
        //2.条件就是i大于要插入的位置的索引
        //3.每1个元素都向后，挪动1个位置
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取index索引位置的元素(外部获取数组的元素)
     * 解决问题：对于数组开辟的空间，其中未使用的空间，通过当前方法，用户永远没有办法查询到没有使用的空间。
     * 通过封装的方式，保证了数据的安全。
     *
     * @param index
     * @return
     */
    int get(int index) {
        //判断数据的合法性
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed . Index is illegal");
        }
        return data[index];
    }

    /**
     * 修改index索引位置的元素为e(外部修改数组的元素)
     *
     * @param index
     * @param e
     */
    void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed . Index is illegal");
        }
        data[index] = e;
    }

    /**
     * 定义打印输出格式
     *
     * @return
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
