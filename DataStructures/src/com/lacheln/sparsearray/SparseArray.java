package com.lacheln.sparsearray;

/**
 * SparseArray
 *
 * @author lacheln
 * @date 2022/7/28 01:36
 * @since 1.0.0
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建原始二维数组 11 * 11
        //0:表示没有棋子，1：表示黑子，2：表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出原始的二维数组
        System.out.printf("====原始二维数组====");
        for (int[] row : chessArr1) {
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();//换行
        }
        //将二维数组 转成 稀疏数组
        //1.遍历二维数组，得到非0数据的个数
        int sum = 0;
        for (int i = 0;i < chessArr1.length;i++){
            for (int j = 0;j < chessArr1.length;j++){
                if (chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
//        System.out.println("sum = " + sum);

        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //遍历二维数组，将非0的值，存放到sparseArr中
        int count = 0;//用户记录是第几个非0数据
        for (int i = 0;i < chessArr1.length;i++){
            for (int j = 0;j < chessArr1.length;j++){
                if (chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到的稀疏数组为~~~");
        for (int i = 0; i < sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",chessArr1[i][0],chessArr1[i][1],chessArr1[i][2]);
        }
        System.out.println();
    }
}
