package other.od200;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 模拟目录管理
 * @since 2024/7/23 13:22
 **/
public class Main48 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirectoryManager dm = new DirectoryManager();
        String lastOutput = "";
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }
            String[] commands = line.split(" ");
            if (line.startsWith("mkdir ")) {
                String dirName = commands[1];
                dm.mkdir(dirName);
            } else if (line.startsWith("cd ")) {
                String dirName = commands[1];
                dm.cd(dirName);
            } else if (line.startsWith("pwd")) {
                lastOutput = dm.pwd();
            }
        }
        System.out.println(lastOutput);
    }
}

class DirectoryManager {
    private Directory root;
    private Directory current;
    private String currentPath;

    public DirectoryManager() {
        root = new Directory();
        current = root;
        currentPath = "/";
    }

    public void mkdir(String directoryName) {
        if (!current.subDirectory.containsKey(directoryName)) {
            current.subDirectory.put(directoryName, new Directory());
        }
    }

    public void cd(String directoryName) {
        if ("..".endsWith(directoryName)) {
            if (!"/".endsWith(currentPath)) {
                currentPath = currentPath.substring(0, currentPath.lastIndexOf('/', currentPath.length() - 2) + 1);
                current = root;
                String[] dirs = currentPath.split("/");
                for (String dir : dirs) {
                    if (!dir.isEmpty() && current.subDirectory.containsKey(dir)) {
                        current = current.subDirectory.get(dir);
                    }
                }
            }
        } else {
            if (current.subDirectory.containsKey(directoryName)) {
                current = current.subDirectory.get(directoryName);
                if (!"/".endsWith(currentPath)) {
                    currentPath += "/";
                }
                currentPath += directoryName;
            }
        }
    }

    public String pwd() {
        return currentPath.endsWith("/") ? currentPath : currentPath + "/";
    }
}

class Directory {
    Map<String, Directory> subDirectory = new HashMap<>();
}
