package other.od100;

import java.util.*;

/**
 * @author Mr.黄
 * @description 智能成绩表
 * @since 2024/7/16 11:42
 **/
public class Main22 {
    static String orderSubject;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        String[] subjects = scanner.nextLine().split(" ");
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            Student student = new Student(name);
            for (int j = 0; j < m; j++) {
                int score = scanner.nextInt();
                student.addScore(subjects[j], score);
            }
            studentList.add(student);
        }
        orderSubject = scanner.next();
        Collections.sort(studentList);
        for (Student student : studentList) {
            System.out.print(student.name + " ");
        }
    }

    static class Student implements Comparable<Student> {
        String name;
        Map<String, Integer> subjectMap;
        int total = 0;

        public Student(String name) {
            this.name = name;
            subjectMap = new HashMap<>();
        }

        public void addScore(String subject, int score) {
            subjectMap.put(subject, score);
            total += score;
        }

        @Override
        public int compareTo(Student o) {
            int o1 = total;
            int o2 = o.total;
            if (subjectMap.containsKey(orderSubject)) {
                o1 = subjectMap.get(orderSubject);
                o2 = o.subjectMap.get(orderSubject);
            }
            if (o1 != o2) {
                return o2 - o1;
            } else {
                return name.compareTo(o.name);
            }
        }
    }
}