package com.lacheln.InterviewClassic150Q;

import java.util.HashMap;

/**
 * Merge
 *
 * @author chenchao
 * @date 2023/10/19
 * @since 1.0.0
 * 合并两个有序数组
 */
@SuppressWarnings("all")
public class Merge {
    public static void main(String[] args) {
    }

    /*
    1.给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
    2.请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
    3.注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
    其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。

     */
    public void ChenMerge(int[] num1, int m, int[] num2, int n) {
        int num1Len = num1.length;
        int num2Len = num2.length;
        //判断空
        if (num2Len == 0) {
            System.out.println(num1);
        }

        HashMap hashMap = new HashMap();
    }
}

