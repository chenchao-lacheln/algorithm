package com.lacheln.simple;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Day1
 *
 * @author chenchao
 * @date 2023/6/16
 * @since 1.0.0
 */
public class Day1 {
    public static void main(String[] args) {
        //2.测试回文数
        int num2 = 12321;
        if (Solution.isPalindrome(num2)){
            System.out.println(num2 + "是回文数");
        }else {
            System.out.println(num2 + "不是回文数");
        }
    }
}

class Solution {
    /**
     * 1.求2数之和
     * 定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     */
    public int[] twoSum(int[] nums, int target) {
        //增加对null和target为空的判断，并抛出异常
        if (nums == null || nums.length == 0 || target == 0) {
            throw new IllegalArgumentException("Invalid input!!");
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 2.回文数
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     */
    public static boolean isPalindrome(int x) {
        //排除负数和以0结尾的整数
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x / 10;
            x /= 10;
        }
        //奇数长度的数，需要去掉中间的一位
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
