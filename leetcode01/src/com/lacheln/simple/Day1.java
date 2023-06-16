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
    @Test
    public void testTwoSum() {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 9};
        int target = 9;
        int[] res = solution.twoSum(nums, target);
        assertEquals(0, res[0]);
        assertEquals(1, res[1]);
    }

}

class Solution {
    /*
    1.求2数之和
    定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     */
    public int[] twoSum(int[] nums, int target) {
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
}
