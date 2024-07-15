package other;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 靠谱的车
 * @since 2024/7/14 22:23
 **/
public class Main14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        while (n > 0) {
            n = Integer.parseInt(String.valueOf(n).replace("4", "3"));
            count++;
            n--;
        }
        System.out.println(count);
    }
}
