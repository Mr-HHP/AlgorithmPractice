package other;

import java.util.*;

/**
 * @author Mr.黄
 * @description 寻找身高相近的小朋友
 * @since 2024/7/13 13:26
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int N = scanner.nextInt();
        List<Integer> heights = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int height = scanner.nextInt();
            heights.add(height);
        }
        heights.sort((o1, o2) -> {
            int diff1 = Math.abs(o1 - H);
            int diff2 = Math.abs(o2 - H);
            if (diff1 == diff2) {
                return o1 - o2;
            }
            return diff1 - diff2;
        });
        for (int h : heights) {
            System.out.println(h + " ");
        }
    }
}
