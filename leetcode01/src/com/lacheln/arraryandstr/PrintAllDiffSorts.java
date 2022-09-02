package com.lacheln.arraryandstr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * PrintAllDiffSorts
 * 打印所有不同排序
 * @author chenchao
 * @date 2022/9/2 11:26 AM
 * @since 1.0.0
 */
public class PrintAllDiffSorts {
    public static void main(String[] args) {
        /**
         * 用1、2、2、3、4、5这六个数字，打印出所有不同的排列，
         * 如：512234、412345等，
         * 要求："4"不能在第三位，"3"与"5"不能相连。
         */
        String[] nums = {"1","2","2","3","4","5"};
        ArrayList<String> strings = new ArrayList<>();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(iterator.next());
        }
    }
    public static void printMethod(String[] nums){
        //遍历数组
        for (String num : nums){
            System.out.print(num);
        }
    }
}
