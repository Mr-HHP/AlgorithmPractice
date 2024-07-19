package other.od200;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author Mr.黄
 * @description 文件缓存系统
 * @since 2024/7/19 22:21
 **/
public class Main28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int useSiz = 0;
        Map<String, List<Integer>> map = new HashMap<>();
        TreeSet<MyFile> set = new TreeSet<>((o1, o2) -> {
            if (o1.visitCount != o2.visitCount) {
                return o1.visitCount - o2.visitCount;
            }
            return o1.lastTime - o2.lastTime;
        });
        for (int i = 0; i < n; i++) {
            String operation = scanner.next();
            String fileName = scanner.next();
            if ("put".equals(operation)) {
                int fileSize = scanner.nextInt();
                if (fileSize > m || map.containsKey(fileName)) {
                    continue;
                }
                while (useSiz + fileSize > m) {
                    MyFile myFile = set.pollFirst();
                    useSiz -= myFile.fileSize;
                    map.remove(myFile.fileName);
                }
                List<Integer> newFile = new ArrayList<>(Arrays.asList(0, i, fileSize));
                map.put(fileName, newFile);
                set.add(new MyFile(0, i, fileSize, fileName));
                useSiz += fileSize;
            } else if ("get".equals(operation)) {
                if (!map.containsKey(fileName)) {
                    continue;
                }
                List<Integer> list = map.get(fileName);
                set.remove(new MyFile(list.get(0), list.get(1), list.get(2), fileName));
                list.set(0, list.get(0) + 1);
                list.set(1, i);
                set.add(new MyFile(list.get(0), i, list.get(2), fileName));
            }
        }
        if (map.size() == 0) {
            System.out.println("NONE");
        } else {
            StringBuffer sb = new StringBuffer();
            map.keySet().stream().sorted().forEach(fileName -> sb.append(fileName).append(","));
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }
}

class MyFile {
    int visitCount;
    int lastTime;
    int fileSize;
    String fileName;
    public MyFile(int visitCount, int lastTime, int fileSize, String fileName) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.lastTime = lastTime;
        this.visitCount = visitCount;
    }
}
