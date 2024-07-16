package other.od100;

import java.util.*;

/**
 * @author Mr.黄
 * @description 堆内存申请
 * @since 2024/7/16 18:34
 **/
public class Main29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int requestSize = Integer.parseInt(scanner.nextLine());
        if (requestSize <= 0 || requestSize > 100) {
            System.out.println(-1);
            return;
        }
        List<Memory> userMemoryList = new ArrayList<>();
        while (true) {
            String line = scanner.nextLine();
            if (line.length() == 0) {
                break;
            }
            int start = Integer.parseInt(line.split(" ")[0]);
            int size = Integer.parseInt(line.split(" ")[1]);
            if (start < 0 || size <= 0 || start + size > 100) {
                System.out.println(-1);
                return;
            }
            userMemoryList.add(new Memory(start, size));
        }
        Collections.sort(userMemoryList);
        for (int i = 0; i < userMemoryList.size() - 1; i++) {
            Memory memory = userMemoryList.get(i);
            int currentEnd = memory.start + memory.size;
            int nextStart = userMemoryList.get(i + 1).start;
            if (nextStart < currentEnd) {
                System.out.println(-1);
                return;
            }
        }
        List<Memory> freeMemoryList = new ArrayList<>();
        int currentEnd = 0;
        for (Memory memory : userMemoryList) {
            if (memory.start > currentEnd) {
                freeMemoryList.add(new Memory(currentEnd, memory.start - currentEnd));
            }
            currentEnd = memory.start + memory.size;
        }

        if (currentEnd < 100) {
            freeMemoryList.add(new Memory(currentEnd, 100 - currentEnd));
        }

        int bestStart = -1;
        int minMemorySize = Integer.MAX_VALUE;
        for (Memory memory : freeMemoryList) {
            if (memory.size >= requestSize && memory.size - requestSize < minMemorySize) {
                bestStart = memory.start;
                minMemorySize = memory.size - requestSize;
            }
        }
        System.out.println(bestStart);
    }
}

class Memory implements Comparable<Memory> {
    int start;
    int size;

    public Memory(int start, int size) {
        this.start = start;
        this.size = size;
    }

    @Override
    public int compareTo(Memory o) {
        return this.start - o.start;
    }
}
