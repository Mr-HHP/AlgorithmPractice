package other.od100;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Mr.黄
 * @description 提取字符串中的最长数字表达式并计算
 * @since 2024/7/16 12:20
 **/
public class Main23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Pattern pattern = Pattern.compile("(\\d+)([\\*+-]\\d+)*");
        Matcher matcher = pattern.matcher(line);
        String longerValidExpression = "";
        int maxLength = 0;
        while (matcher.find()) {
            String expression = matcher.group();
            if (expression.length() >= maxLength && expression.matches("^(-?\\d+([+\\-*]\\d+)+)$")) {
                maxLength = expression.length();
                longerValidExpression = expression;
            }
        }
        if (longerValidExpression.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(expressionCalculate(longerValidExpression));
        }
    }

    public static long expressionCalculate(String expression) {
        if (expression.isEmpty()) {
            return 0;
        }
        Stack<Long> values = new Stack<>();
        long currentValue = 0;
        char sign = '+';
        expression += "+";
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                currentValue = currentValue * 10 + (c - '0');
            } else if (c == '+' || c == '-' || c == '*' || i == expression.length() - 1) {
//                if (c != '*' && !values.isEmpty() && values.peek() == -1) {
//                    values.pop();
//                    sign = '-';
//                }
                switch (sign) {
                    case '+':
                        values.push(currentValue);
                        break;
                    case '-':
                        values.push(-currentValue);
                        break;
                    case '*':
                        long top = values.pop();
                        values.push(top * currentValue);
                        break;
                }
                currentValue = 0;
                sign = c;
            }
        }
        long result = 0;
        while (!values.empty()) {
            result += values.pop();
        }
        return result;
    }
}
