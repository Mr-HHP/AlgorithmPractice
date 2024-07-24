package other.od100;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 字符串序列判定
 * @since 2024/7/24 16:10
 **/
public class Main61 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String l = scanner.nextLine();
        int lastIndex = -1;
        int sIndex = 0;
        for (int i = 0; i < l.length(); i++) {
            if (sIndex < s.length() && s.charAt(sIndex) == l.charAt(i)) {
                sIndex++;
                lastIndex = i;
            }
            if (sIndex >= s.length()) {
                break;
            }
        }
        System.out.println(lastIndex);
    }
}
