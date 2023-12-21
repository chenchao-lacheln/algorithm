package com.lacheln.linear;

/**
 * LinearSearch
 *
 * @author chaochen
 * @date 2023/12/22
 * @since 1.0.0
 */
public class LinearSearch {
    //线性查找
    //不希望用户创建LinearSearch对象，可以把LinearSearch构造函数设置成私有，外界无法调用
    private LinearSearch(){};
    public static int search(int[] data ,int target){
        for (int i = 0;i < data.length;i++){
            if (data[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] data = {24,18,12,19,16,66,22,4};

        int res = LinearSearch.search(data,16);
        System.out.println(res);

        int res2 = LinearSearch.search(data,999);
        System.out.println(res2);
    }

    // TODO: 2023/12/22 当前无法避免重复代码编写：只能在int类型种查找一个int类型的数，java种基本数据类型有8种。不希望重复的写search方法

}
