package other.od200;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Block {
    int groupId;
    int count;

    public Block(int groupId, int count) {
        this.groupId = groupId;
        this.count = count;
    }
}

public class Main44 {
    public static int[] splitInput(char separator) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine().trim();
        String[] tokens = inputStr.split(String.valueOf(separator));
        int[] nums = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            nums[i] = Integer.parseInt(tokens[i]);
        }
        return nums;
    }

    public static List<Block> confirm(List<Block> queue, int confirmedGroupId) {
        List<Block> backQueue = new ArrayList<>();
        for (Block block : queue) {
            if (block.groupId != confirmedGroupId) {
                backQueue.add(block);
            }
        }
        List<Block> newQueue = new ArrayList<>();
        for (int i = 0; i < backQueue.size(); i++) {
            if (i == 0 || backQueue.get(i).groupId != backQueue.get(i - 1).groupId) {
                newQueue.add(backQueue.get(i));
            } else {
                newQueue.get(newQueue.size() - 1).count += backQueue.get(i).count;
            }
        }
        return newQueue;
    }

    public static void main(String[] args) {
        // 原始序列
        int[] nums = splitInput(' ');
        int originalSize = nums.length;
        // 排序后的序列
        int[] sortedNums = splitInput(' ');
        int sortedSize = sortedNums.length;

        // 将索引映射到组号，索引表示顺序，值表示组号
        int[] group = new int[sortedSize + 1];
        for (int i = 0; i < sortedSize; i++) {
            int num = sortedNums[i];
            group[num] = i / 3;
        }

        // 合并相邻的组号相同的块并计数
        List<Block> queue = new ArrayList<>();
        for (int num : nums) {
            int groupId = group[num];
            if (queue.isEmpty() || queue.get(queue.size() - 1).groupId != groupId) {
                queue.add(new Block(groupId, 1));
            } else {
                queue.get(queue.size() - 1).count++;
            }
        }

        // 记录调整次数
        int movedCount = 0;
        while (!queue.isEmpty()) {
            Block first = queue.remove(0);
            if (first.count == 1) {
                if (!queue.isEmpty() && queue.get(0).groupId == first.groupId && queue.get(0).count == 2) {
                    movedCount++;
                    queue.remove(0);
                } else {
                    movedCount += 2;
                    queue = confirm(queue, first.groupId);
                }
            } else if (first.count == 2) {
                movedCount++;
                queue = confirm(queue, first.groupId);
            }
        }

        System.out.println(movedCount);
    }
}