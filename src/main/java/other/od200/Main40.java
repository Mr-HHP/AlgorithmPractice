package other.od200;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 伐木工
 * @since 2024/7/22 16:19
 **/
public class Main40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if (x <= 4) {
            System.out.println(x);
        } else {
            if (x % 3 == 0) {
                int num = x / 3;
                for (int i = 0 ; i < num; i++) {
                    System.out.print("3 ");
                }
            } else if (x % 3 == 1) {
                int num = x / 3 - 1;
                for (int i = 0; i < num; i++) {
                    System.out.print("3 ");
                }
                System.out.print("4");
            } else {
                System.out.println("2 ");
                int num = x / 3;
                for (int i = 0; i < num; i++) {
                    System.out.println("3 ");
                }
            }
        }
    }
}
