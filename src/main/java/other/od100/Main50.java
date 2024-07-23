package other.od100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 多段线数据压缩
 * @since 2024/7/23 21:26
 **/
public class Main50 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuffer sb = new StringBuffer();
        int preX = nums[0];
        int preY = nums[1];
        int preDirectX = 0;
        int preDirectY = 0;
        for (int i = 2; i < nums.length; i += 2) {
            int curX = nums[i];
            int curY = nums[i + 1];
            int offsetX = curX - preX;
            int offsetY = curY - preY;
            int base = Math.max(Math.abs(offsetX), Math.abs(offsetY));
            int directX = offsetX / base;
            int directY = offsetY / base;
            if (directX != preDirectX || directY != preDirectY) {
                sb.append(preX).append(" ").append(preY).append(" ");
            }
            preX = curX;
            preY = curY;
            preDirectX = directX;
            preDirectY = directY;
        }
        sb.append(preX).append(" ").append(preY);
        System.out.println(sb);
    }
}
