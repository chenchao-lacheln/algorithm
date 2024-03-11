package com.lacheln.stack.validparentheses;

//import com.lacheln.stack.ArrayStack;
//import com.lacheln.stack.Stack;
import java.util.Stack;

/**
 * Sloution
 *
 * @author chenchao
 * @date 2024/3/11
 * @since 1.0.0
 * 用java自带的栈库：解决有效括号算法问题
 */
public class Solution {
    public boolean isvalid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == '[' && topChar != ']') {
                    return false;
                }
                if (c == '{' && topChar != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty(); //注意：最终只有当stack栈为空时，才算是匹配成功
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).isvalid("()[]{}"));
        System.out.println((new Solution()).isvalid("([)]"));
    }
}
