package com.lacheln.simple;


import java.util.Arrays;
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
//        //1.测试两数之和
//        int[] nums = {2, 7, 11, 15};
//        int target = 13;
//        int[] res = Solution.twoSum3(nums, target);
//        for (int i = 0; i < res.length; i++) {
//            System.out.print(res[i] + " ");
//        }

        //2.测试回文数
//        int num2 = 12353321;
//        if (Solution.isPalindrome(num2)) {
//            System.out.println(num2 + "是回文数");
//        } else {
//            System.out.println(num2 + "不是回文数");
//        }
        //3.测试翻转整数
        String str = "hello lacheln";
        String reverseStr = Solution.reverseStr03(str);
        System.out.println(reverseStr);
        //4.测试罗马数字转整
//        String roman = "MCMXCIV";
//        System.out.println(Solution.romanToInt(roman));
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
            if (hashMap.containsKey(complement)) {
                return new int[]{hashMap.get(complement), i};
            }
            //如果不存在目标值，则将当前元素num[i]，和下标添加到hashMap中
            hashMap.put(nums[i], i);
        }
        //没有找到，返回空数组
        return new int[]{};
    }

    //3.排序 + 双指针法
    /*
    可以先将数组排序，然后用双指针分别从数组的首尾开始扫描，如果两个指针所指的数之和大于 target，
    则右指针左移，否则左指针右移，直到找到符合要求的两个数为止。
     */
    public static int[] twoSum3(int[] nums, int target) {
        //数组长度
        int n = nums.length;
        //复制数组
        int[] numsSorted = Arrays.copyOf(nums, n);
        //数组排序
        Arrays.sort(numsSorted);
        //定义左右指针
        int left = 0, right = n - 1;
        //增加异常判断
        boolean found = false;
        //确保双指针正常移动
        //遍历的过程中加入判断，当左右指针相遇时仍未找到满足条件的两个数，即可退出循环
        while (left < right && !found) { // 双指针法扫描副本数组，查找两个数之和等于 target
            int sum = numsSorted[left] + numsSorted[right];
            if (sum == target) { // 如果找到了，则退出循环
                found = true;
                break;
            } else if (sum < target) { // 否则根据两个数之和与 target 的大小关系，决定移动左指针还是右指针
                left++;
            } else {
                right--;
            }
        }

        // 在找到满足条件的两数时标记为 true，如果没有找到则返回空数组或者抛出异常
        if (!found) {
//            return new int[0];
            throw new IllegalArgumentException("数组不存在");
        }

        //记录左指针数据
        int[] indices = new int[2];
        for (int i = 0; i < n; i++) { // 在原数组中查找这两个数的下标
            if (nums[i] == numsSorted[left]) { // 如果这个数等于左指针指向的数，则说明这个数是所求之一，记录其下标
                indices[0] = i;
                break;
            }
        }
        //记录右指针数据
        for (int i = n - 1; i >= 0; i--) { // 在原数组中查找这两个数的下标
            if (nums[i] == numsSorted[right]) { // 如果这个数等于右指针指向的数，则说明这个数是所求之一，记录其下标
                indices[1] = i;
                break;
            }
        }
        return indices;
    }

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

    /**
     * 翻转整数
     *
     * @param x
     */
    //1.使用StringBuilder或StringBuffer类：可以使用StringBuilder或StringBuffer类的reverse()方法快速翻转字符串。
    public static void reverseStr01(String x) {
        StringBuilder sb = new StringBuilder(x);
        String reverseStr = sb.reverse().toString();
        System.out.println("反转后的整数为 = " + reverseStr);
    }
    //2.使用字符数组：将字符串转换为字符数组，然后通过交换首尾字符的位置来实现翻转。
    public static void reverseStr02(String x){
        char[] charsArray = x.toCharArray();
        int left = 0;
        int right = charsArray.length - 1;
        while (left < right){
            char temp = charsArray[left];
            charsArray[left] = charsArray[right];
            charsArray[right] = temp;
            left++;
            right--;
        }
        String reverseStr = new String(charsArray);
        System.out.println("反转后的整数为 = " + reverseStr);
    }
    //3.使用递归：通过递归函数来实现字符串的翻转。
    public static String reverseStr03(String x){
        if (x.isEmpty()){ //终止条件
            return x;
        }else {
            return reverseStr03(x.substring(1)) + x.charAt(0);
        }
    }

    /**
     * 4.罗马数字转整
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。
     */
    //1.使用哈希表解决
    public static int romanToInt(String s) {
        //创建hashMap存储罗马数字对应整数
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int res = 0;
        //遍历罗马数字s的每个字符，从前往后处理
        for (int i = 0; i < s.length(); i++) {
            //取出当前字符和下一字符的位置
            int current = hashMap.get(s.charAt(i));
            int next = i < s.length() - 1 ? hashMap.get(s.charAt(i + 1)) : 0;
            //如果当前字符小于下一字符，相当于当前字符是一个减法，需要将结果减去当前字符的值。
            if (current < next) {
                res -= current;
            } else {
                //否则，当前字符是一个加法，需要将结果加上当前字符的值。
                res += current;
            }
        }
        return res;
    }
    //2.使用整数数据来处理
    /*
    使用一个技巧来提高算法效率。该技巧是先把罗马数字转换为整数数组，然后从数组右侧开始处理，
    将每个数字与其右侧的数字相比较，如果左侧的数字比右侧的数字小，则需要执行减法操作。
    否则，执行加法操作。最终，将所有的数字加起来即可。这种解法可以避免使用 `Map` 对象，从而提高算法效率。
     */

}
