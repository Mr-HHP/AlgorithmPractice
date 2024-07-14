package other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 执行时长
 * @since 2024/7/14 22:33
 **/
public class Main15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxTask = scanner.nextInt();
        int numTask = scanner.nextInt();
        List<Integer> taskList = new ArrayList<>();
        for (int i = 0; i < numTask; i++) {
            taskList.add(scanner.nextInt());
        }
        int time = 0;
        int remainTask = 0;
        for (int task : taskList) {
            remainTask += task;
            time += 1;
            if (remainTask > maxTask) {
                remainTask -= maxTask;
            } else {
                remainTask = 0;
            }
        }
        if (remainTask > 0) {
            time += (remainTask + maxTask - 1) / maxTask;
        }
        System.out.println(time);
    }
}
