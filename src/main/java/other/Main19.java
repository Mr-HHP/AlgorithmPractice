package other;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 最长子字符串的长度（一）
 * @since 2024/7/15 0:12
 **/
public class Main19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int length = str.length();
        int oCount = 0;
        for (String s : str.split("")) {
            if (s.equals("o")) {
                oCount++;
            }
        }
        if (oCount % 2 == 0) {
            System.out.println(length);
        } else {
            System.out.println(length - 1);
        }

    }
}
