package other.od100;

import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 火星文计算
 * @since 2024/7/23 17:29
 **/
public class Main46 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split("\\$");
        int[] valueArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            String[] sub = split[i].split("#");
            int temp = Integer.parseInt(sub[0]);
            for (int j = 1; j < sub.length; j++) {
                temp = 4 * temp + 3 * Integer.parseInt(sub[j]) + 2;
            }
            valueArr[i] = temp;
        }
        int result = valueArr[0];
        for (int i = 1; i < valueArr.length; i++) {
            result = 2 * result + valueArr[i] + 3;
        }
        System.out.println(result);
    }
}
