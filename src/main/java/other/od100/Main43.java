package other.od100;

import java.util.*;

/**
 * @author Mr.黄
 * @description 密码解密
 * @since 2024/7/21 17:37
 **/
public class Main43 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        for (int i = 26; i >= 1; i--) {
            String key = i + (i >= 10 ? "*" : "");
            char value = (char) (96 + i);
            line = line.replace(key, String.valueOf(value));
        }
        System.out.println(line);
    }
}
