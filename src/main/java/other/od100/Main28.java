package other.od100;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 求字符串中所有整数的最小和
 * @since 2024/7/16 18:02
 **/
public class Main28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        long result = 0;
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                int sum = 0;
                int j;
                for (j = i; j < line.length() && Character.isDigit(line.charAt(j)); j++) {
                    sum += line.charAt(j) - '0';
                }
                if (i > 0 && line.charAt(i - 1) == '-') {
                    result -= Long.parseLong(line.substring(i, j));
                } else {
                    result += sum;
                }
                i = j - 1;
            }
        }
        System.out.println(result);
    }
}
