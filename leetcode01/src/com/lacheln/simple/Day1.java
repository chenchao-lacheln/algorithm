package com.lacheln.simple;


import java.util.HashMap;

/**
 * Day1
 *
 * @author chenchao
 * @date 2023/6/16
 * @since 1.0.0
 */
public class Day1 {
    public static void main(String[] args) {
        //1.测试两数之和
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] res = Solution.twoSum2(nums,target);
        for (int i = 0;i < res.length;i++){
            System.out.print(i + " ");
        }

        //2.测试回文数
//        int num2 = 12353321;
//        if (Solution.isPalindrome(num2)) {
//            System.out.println(num2 + "是回文数");
//        } else {
//            System.out.println(num2 + "不是回文数");
//        }
    }
}

class Solution {
    /**
     * 1.求2数之和
     * 定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     */
    //1.暴力枚举法：解法很简单直接，但时间复杂度较高，不适用于大规模数据的情况。
    //2.时间复杂度为 O(n^2)，空间复杂度为 O(1)。
    public static int[] twoSum1(int[] nums, int target) {
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
        //如果没有符合条件的数组，返回空数组或者抛出异常
//        return new int[0];
        throw new IllegalArgumentException("No two sum solution");
    }

    //2.用哈希表解决（最优解）：不符合条件的值存入hashMap，符合的值直接返回下标
    /*
    算法原理：遍历数组 nums，在遍历的过程中，用哈希表记录已经遍历的数及其下标，每次遍历到一个数时，
    计算其值与 target 的差值 complement 是否已经存在于哈希表中，如果存在，则说明找到了一组符合要求的数，
    直接返回这两个数的下标即可；否则将当前数存入哈希表中等待后续匹配。时间复杂度为 O(n)，空间复杂度为 O(n)。
     */
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        //遍历数组nums
        for (int i = 0; i < nums.length; i++) {
            //目标数值
            int complement = target - nums[i];
            //判断hashMap中是否存在目标值，如果存在，就返回一个新数组，数组中是2个元素的下标
            if (hashMap.containsKey(complement)){
                return new int[] {hashMap.get(complement),i};
            }
            //如果不存在目标值，则将当前元素num[i]，和下标添加到hashMap中
            hashMap.put(nums[i],i);
        }
        //没有找到，返回空数组
        return new int[] {};
    }

    //3.排序 + 双指针法

    /**
     * 2.回文数
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     */
    public static boolean isPalindrome(int x) {
        //排序负数和0结尾的整数
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int reversed = 0;
        while (x > reversed) {
            //翻转整数x，获取x的后半部分
            reversed = reversed * 10 + x % 10;
            //获取整数x的前半部分
            x /= 10;
        }
        //判断x的前半部分与后半部分是否想等：偶数直接判断，奇数去掉中间的数
        return x == reversed || x == reversed / 10;
    }
}
