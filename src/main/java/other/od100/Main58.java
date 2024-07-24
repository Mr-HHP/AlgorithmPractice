package other.od100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 手机App防沉迷系统
 * @since 2024/7/24 14:45
 **/
public class Main58 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<App> registerApp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split(" ");
            String name = split[0];
            int level = Integer.parseInt(split[1]);
            int startTime = timeToMinutes(split[2]);
            int endTime = timeToMinutes(split[3]) - 1;
            if (startTime > endTime) {
                continue;
            }
            boolean canRegister = true;
            List<App> updateApps = new ArrayList<>();
            for (App app : registerApp) {
                if (startTime <= app.endTime && endTime >= app.startTime) {
                    if (level <= app.level) {
                        canRegister = false;
                        break;
                    }
                }
            }
            if (canRegister) {
                for (App app : registerApp) {
                    if (!(startTime <= app.endTime && endTime >= app.startTime)) {
                        updateApps.add(app);
                    }
                }
                updateApps.add(new App(name, level, startTime, endTime));
                registerApp = updateApps;
            }
        }

        int queryMinute = timeToMinutes(scanner.nextLine());
        for (App app : registerApp) {
            if (app.startTime <= queryMinute && app.endTime >= queryMinute) {
                System.out.println(app.name);
                return;
            }
        }
        System.out.println("NA");
    }

    public static int timeToMinutes(String time) {
        String[] split = time.split(":");
        int hours = Integer.parseInt(split[0]);
        int minutes = Integer.parseInt(split[1]);
        return hours * 60 + minutes;
    }
}

class App {
    String name;
    int level;
    int startTime;
    int endTime;

    public App(String name, int level, int startTime, int endTime) {
        this.name = name;
        this.level = level;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}