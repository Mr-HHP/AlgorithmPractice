package other.od100;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 字符串变换最小字符串
 * @since 2024/7/20 21:24
 **/
public class Main36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int minIndex = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            int current = (int) str.charAt(i);
            if (current <= min) {
                min = current;
                minIndex = i;
            }
        }
        if (minIndex == 0) {
            System.out.println(str);
        } else {
            char temp = str.charAt(minIndex);
            char[] chars = str.toCharArray();
            chars[minIndex] = chars[0];
            chars[0] = temp;
            System.out.println(String.valueOf(chars));
        }
    }
}
