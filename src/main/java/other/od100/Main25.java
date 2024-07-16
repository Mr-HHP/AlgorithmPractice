package other.od100;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 停车场车辆统计
 * @since 2024/7/16 16:02
 **/
public class Main25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.length() == 0) {
            System.out.println(0);
        } else {
            String[] split = line.split(",");
            String join = String.join("", split);
            join = join.replace("111", "3").replace("11", "2").replace("0", "");
            System.out.println(join.length());
        }
    }
}
