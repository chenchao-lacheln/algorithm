package com.lacheln.InterviewClassic150Q;

/**
 * IsPalindrome
 *
 * @author chenchao
 * @date 2024/2/19
 * @since 1.0.0
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(chenIsPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(chenIsPalindrome("race a car"));
        System.out.println(chenIsPalindrome(" "));
        System.out.println(chenIsPalindrome("1"));
    }

    /**
     * 筛选+判断
     *
     * @return 验证回文字符串
     */
    public static boolean chenIsPalindrome(String s) {
        /*
        如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
        给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
         */
        StringBuilder stringBuilder = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stringBuilder.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer stringBuffer_rev = new StringBuffer(stringBuilder).reverse();
        return stringBuilder.toString().equals(stringBuffer_rev.toString());
    }
}
