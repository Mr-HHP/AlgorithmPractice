package other.od100;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 分割均衡字符串
 * @since 2024/7/14 18:09
 **/
public class Main12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int sum = 0;
        int xCount = 0;
        int yCount = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'X') {
                xCount++;
            } else {
                yCount++;
            }
            if (xCount == yCount) {
                sum++;
                xCount = 0;
                yCount = 0;
            }
        }
        System.out.println(sum);
    }
}
