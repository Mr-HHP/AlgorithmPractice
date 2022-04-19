import java.util.Stack;

/**
 * @author Mr.黄
 * @date 2022/04/16
 **/
public class Test {
    /**
     * 华为OD一面编程题：
     * 将括号内的字符按照前面的数字进行膨胀，最后结果倒序输出
     *
     * @param args
     */
    public static void main(String[] args) {
        String input = "abc3(AB)C";
        if (input == null || "".equals(input)) {
            System.out.println(input);
        }
        char[] strings = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (char c : strings) {
            if ('(' == c) {
                continue;
            }
            if (')' == c) {
                count = 1;
                continue;
            }
            if (Character.isDigit(c)) {
                count = Integer.valueOf(Character.toString(c));
            } else {
                for (int i = 0; i < count; i++) {
                    stack.push(c);
                }
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        System.out.println(result.toString());
    }
}