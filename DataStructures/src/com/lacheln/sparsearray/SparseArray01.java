package com.lacheln.sparsearray;

/**
 * SparseArray01
 * 稀疏数组 练习
 * @author chenchao
 * @date 2022/8/23 4:12 PM
 * @since 1.0.0
 */
public class SparseArray01 {
    public static void main(String[] args) {
        //创建原始数组 11 * 11
        int[][] array1 = new int[11][11];
        //0没有棋子，1黑子，2蓝子
        array1[1][2] = 1;
        array1[2][3] = 2;
        for (int[] row : array1){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
