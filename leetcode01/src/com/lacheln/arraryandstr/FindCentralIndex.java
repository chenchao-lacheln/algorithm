package com.lacheln.arraryandstr;

import java.util.Scanner;

/**
 * FindCentralIndex
 * 寻找中心索引
 * @author chenchao
 * @date 2022/8/12 2:21 PM
 * @since 1.0.0
 */
public class FindCentralIndex {
    public static void main(String[] args) {
        /**
         * 给你一个整数数组nums ，请计算数组的中心下标 。
         * 1.数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
         * 2.如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
         * 3.如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
         * 分析:
         */
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums1));
    }
    public static int pivotIndex(int[] nums){
        //总和
        int sum = 0;
        //遍历求和
        for (int i : nums){
            sum += i;
            return sum;
        }
        //如果除了nums[0]以外的和为0，即0为数组的中心索引
        if (sum - nums[0] == 0){
            return 0;
        }
        //寻找中心坐标
        //左边和
        int leftSum = 0;
        for (int j : nums){
            //右边和
            int rightSum = sum - leftSum - nums[j];
            if (leftSum == rightSum){
                return j;
            }
            leftSum += nums[j];
        }
        return -1;
    }
}