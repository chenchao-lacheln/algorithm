package com.lacheln.arraryandstr;

import java.util.Arrays;

/**
 * SearchInsertLocation
 * 搜索插入位置
 * @author chenchao
 * @date 2022/9/2 3:28 PM
 * @since 1.0.0
 */
public class SearchInsertLocation {
    public static void main(String[] args) {
        /**
         * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
         * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
         * 请必须使用时间复杂度为 O(log n) 的算法。
         *
         * 输入: nums = [1,3,5,6], target = 5
         * 输出: 2
         *
         * 输入: nums = [1,3,5,6], target = 2
         * 输出: 1
         *
         * 输入: nums = [1,3,5,6], target = 7
         * 输出: 4
         */
//        int[] num = {3,2,5,4,78};
        int[] num = {};
        searchInsert(num,1);
    }
    public static int searchInsert(int[] nums, int target){
        //判空
        if (nums == null){
            System.out.println("数据有误");
        }

        //冒泡排序
        int temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 -i; j++) {
                if (nums[j] > nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        //遍历nums数组
        for (int i : nums){
            //判断索引是存在
            if (nums[i] == target){
                return i;
            }else if (target < nums[i]){
                return i - 1;
            }
        }
        return -1;
    }
}
