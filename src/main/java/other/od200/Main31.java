package other.od200;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 文本统计分析
 * @since 2024/7/20 11:37
 **/
public class Main31 {
    // 未完成
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        while (scanner.hasNext()) {
            sb.append(scanner.nextLine() + "\n");
        }
        int length = sb.length();
        int[] tag = new int[length];
        int last = -1;
        for (int i = 0; i < length; i++) {
            if (last == -1) {
                if (sb.charAt(i) == '\'' || sb.charAt(i) == '"') {
                    if (checkEscape(i, sb)) {
                        last = i;
                    }
                }
            } else {
                if (sb.charAt(i) == sb.charAt(last) && checkEscape(i, sb)) {

                }
            }
        }
    }

    public static boolean checkEscape(int p, StringBuffer sb) {
        int result = 0;
        for (int i = p; i >= 0 && sb.charAt(i) == '\\'; i--) {
            result++;
        }
        return result % 2 == 0;
    }
}
