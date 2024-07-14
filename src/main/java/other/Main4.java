package other;

import java.util.*;

/**
 * @author Mr.黄
 * @description 开源项目热榜
 * @since 2024/7/13 15:36
 **/
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> weights = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            weights.add(scanner.nextInt());
        }
        List<Map<String, String>> projects = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split(" ");
            String projectName = split[0];
            int watchHot = weights.get(0) * Integer.parseInt(split[1]);
            int starHot = weights.get(1) * Integer.parseInt(split[2]);
            int forkHot = weights.get(2) * Integer.parseInt(split[3]);
            int issueHot = weights.get(3) *Integer.parseInt(split[4]);
            int mrHot = weights.get(4) * Integer.parseInt(split[5]);
            int hotValue = watchHot + starHot + forkHot + issueHot + mrHot;
            Map<String, String> map = new HashMap<>();
            map.put("projectName", projectName);
            map.put("hotValue", Integer.toString(hotValue));
            projects.add(map);
        }
        projects.sort((project1, project2) -> {
            String projectName1 = project1.get("projectName");
            int projectHot1 = Integer.parseInt(project1.get("hotValue"));
            String projectName2 = project2.get("projectName");
            int projectHot2 = Integer.parseInt(project2.get("hotValue"));
            if (projectHot1 != projectHot2) {
                return projectHot2 - projectHot1;
            } else {
                return projectName1.toLowerCase().compareTo(projectName2.toLowerCase());
            }
        });
        for (Map<String, String> map : projects) {
            System.out.println(map.get("projectName"));
        }
    }
}
