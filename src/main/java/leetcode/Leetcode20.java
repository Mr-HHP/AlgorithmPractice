package leetcode;

import java.util.Stack;

/**
 * 有效的括号
 *
 * @author Mr.黄
 * @date 2022/03/20
 **/
public class Leetcode20 {
    /**
     * 利用栈解题
     *
     * @param s 给定的字符串
     * @return 符合返回true，否则返回false
     */
    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.empty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }
    
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("([])"));
        System.out.println(isValid("()[]{}"));
    }
}