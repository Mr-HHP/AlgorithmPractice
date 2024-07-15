package other.od100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description API集群负载统计
 * @since 2024/7/14 13:34
 **/
public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lines.add(scanner.nextLine());
        }
        String[] search = scanner.nextLine().split(" ");
        int layer = Integer.parseInt(search[0]);
        String key = search[1];
        int count = 0;
        for (String path : lines) {
            String[] split = path.split("/");
            if (split.length >= layer + 1 && split[layer].equals(key)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
