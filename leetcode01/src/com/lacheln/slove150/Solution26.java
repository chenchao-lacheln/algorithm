package com.lacheln.slove150;

import org.junit.jupiter.api.Test;

/**
 * RemoveDuplicates
 * 删除有序数组中的重复项
 *
 * @author chenchao
 * @date 2023/12/18
 * @since 1.0.0
 */
public class Solution26 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
//        int[] nums = {};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int numLength = nums.length;
        if (numLength == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < numLength) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}

