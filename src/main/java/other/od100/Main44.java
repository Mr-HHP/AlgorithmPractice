package other.od100;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Mr.黄
 * @description 密码输入检测
 * @since 2024/7/23 15:16
 **/
public class Main44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(String.valueOf(s.charAt(i)));
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        boolean flag = true;
        if (sb.length() < 8) {
            flag = false;
        }
        int numCount = 0;
        int lowerCount = 0;
        int upperCount = 0;
        int spaceCount = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (Character.isDigit(sb.charAt(i))) {
                numCount++;
            }
            if (Character.isLowerCase(sb.charAt(i))) {
                lowerCount++;
            }
            if (Character.isUpperCase(sb.charAt(i))) {
                upperCount++;
            }
            if (Character.isSpaceChar(sb.charAt(i))) {
                spaceCount++;
            }
        }
        if (numCount == 0 || lowerCount == 0 || upperCount == 0 || sb.length() - numCount - lowerCount - upperCount - spaceCount == 0) {
            flag = false;
        }
        System.out.println(sb.reverse() + "," + flag);
    }
}
