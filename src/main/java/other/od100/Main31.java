package other.od100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 按身高和体重排队
 * @since 2024/7/16 22:21
 **/
public class Main31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] heights = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Student student = new Student(i, heights[i], weights[i]);
            students.add(student);
        }
        Collections.sort(students);
        for (Student student : students) {
            System.out.print(student.index + 1 + " ");
        }
    }
}

class Student implements Comparable<Student> {
    int index;
    int height;
    int weight;

    public Student(int index, int height, int weight) {
        this.index = index;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Student student) {
        if (student.height != this.height) {
            return this.height - student.height;
        } else if (student.weight != this.weight) {
            return this.weight - student.weight;
        } else {
            return this.index - student.index;
        }
    }
}
