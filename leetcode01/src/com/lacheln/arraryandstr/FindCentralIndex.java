package com.lacheln.arraryandstr;

import org.junit.jupiter.api.Test;


/**
 * FindCentralIndex
 * 寻找中心索引
 *
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
        Solution solution = new Solution();
        System.out.println(solution.pivotIndex(nums1));
    }
}

class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        //sum为数组中所有元素的总和
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        //如果除了nums[0]以外的和为0，即0为数组的中心索引
        if (sum - nums[0] == 0) {
            return 0;
        }

        int flag = 0;
        int end = 0;
        //flag为数组中从索引为0的位置到索引为j的位置的所有元素的和
        for (int j = 0; j < nums.length; j++) {
            flag += nums[j];
            if (j != 0) {
                //end为数组中从索引为0的位置到索引为j-1的位置的所有元素的和
                end = flag - nums[j];
            }
            //数组中索引为j的位置前的所有元素总和
            while (end == sum - flag) {
                //与数组中索引位置为j的位置后的所有元素总和相等
                return j;
            }
        }
        return -1;
    }
}