package com.lacheln.array;

/**
 * Main
 *
 * @author chenchao
 * @date 2024/3/5
 * @since 1.0.0
 * 使用java中的数据
 */
public class Main {
    public static void main(String[] args) {
        //指定数据空间，创建数组
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        //不指定数组空间，创建数组
        int[] scores = new int[]{100, 99, 66};
        //遍历方法1
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }

        System.out.println();

        //修改成绩
        scores[0] = 98;

        //遍历方法2：可遍历，可迭代的能力
        for (int score : scores) {
            System.out.print(score + " ");
        }
    }
}
