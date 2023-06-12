package com.lacheln.primary;

/**
 * Array
 * 数组
 *
 * @author chenchao
 * @date 2023/4/26
 * @since 1.0.0
 */
public class Array {
    public static void main(String[] args) {

    }
    public int removeDuplicates(int[] nums){
        /*
    删除排序数组中的重复项
    给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
    考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
        更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
        返回 k 。
    示例 1：
        输入：nums = [1,1,2]
        输出：2, nums = [1,2,_]
        解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
    示例 2：

        输入：nums = [0,0,1,1,1,2,2,3,3,4]
        输出：5, nums = [0,1,2,3,4]
        解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
    提示：
        1 <= nums.length <= 3 * 104
        -104 <= nums[i] <= 104
        nums 已按 升序 排列

    思路：
        1、双指针解决
        2、使用两个指针，右指针始终往右移动，
            如果右指针指向的值等于左指针指向的值，左指针不动。
            如果右指针指向的值不等于左指针指向的值，那么左指针往右移一步，然后再把右指针指向的值赋给左指针
     */
        int[] targetNum = null;
        int targetNumLeagth = 0;
        for (int i = 0;i < nums.length-1;i++){
            //第一个数直接放入目标数组
            if (i == 0) {
                targetNum[i] = nums[i];
            }else if (i <= nums.length - 1) {
                for (int j = 0; j < targetNum.length - 1; j++) {
                    if (targetNum[i] != nums[i]){
                        targetNum[i] = nums[i];
                    }
                }
            }else {
                System.out.println("数组读取完毕");
                targetNumLeagth = targetNum.length-1;
            }
        }
        return targetNumLeagth;
    }
}


