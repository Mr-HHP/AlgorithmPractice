package other.od100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 灰度图恢复
 * @since 2024/7/23 18:08
 **/
public class Main47 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        LinkedList<Integer> codes = new LinkedList<>();
        LinkedList<Integer> nums = new LinkedList<>();
        while (scanner.hasNextInt()) {
            if (!scanner.hasNextLine()) {
                break;
            }
            codes.add(scanner.nextInt());
            nums.add(scanner.nextInt());
        }
        int x = codes.pollLast();
        int y = nums.pollLast();
        int cnt = 0;
        int des = x * m + y;

        for (int i = 0; i < nums.size(); i++) {
            des = des - nums.get(i);
            if (des < 0) {
                break;
            }
            cnt++;
        }
        System.out.println(codes.get(cnt));
    }
}
