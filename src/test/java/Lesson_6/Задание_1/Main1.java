package src.test.java.Lesson_6.Задание_1;

import java.util.*;

class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades;

    public Student(String name, String group, int course, Map<String, Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new HashMap<>(grades);
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0;
        return grades.values().stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public void promoteToNextCourse() {
        if (getAverageGrade() >= 3) {
            course++;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", grades=" + grades +
                '}';
    }
}

class StudentManager {
    private Set<Student> students;

    public StudentManager() {
        this.students = new HashSet<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeUnderperformingStudents() {
        students.removeIf(student -> student.getAverageGrade() < 3);
    }

    public void promoteStudents() {
        for (Student student : students) {
            student.promoteToNextCourse();
        }
    }

    public void printStudents(Set<Student> students, int course) {
        System.out.println("Students on course " + course + ":");
        students.stream()
                .filter(student -> student.getCourse() == course)
                .forEach(student -> System.out.println(student.getName()));
    }

    public Set<Student> getStudents() {
        return new HashSet<>(students);
    }
}

public class Main1 {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        // Создаем студентов
        Map<String, Integer> grades1 = new HashMap<>();
        grades1.put("Math", 5);
        grades1.put("Physics", 4);
        Student student1 = new Student("Ivan", "Group A", 1, grades1);

        Map<String, Integer> grades2 = new HashMap<>();
        grades2.put("Math", 2);
        grades2.put("Physics", 3);
        Student student2 = new Student("Petr", "Group B", 2, grades2);

        Map<String, Integer> grades3 = new HashMap<>();
        grades3.put("Math", 4);
        grades3.put("Physics", 4);
        Student student3 = new Student("Anna", "Group A", 1, grades3);

        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);

        manager.printStudents(manager.getStudents(), 1);

        manager.removeUnderperformingStudents();

        manager.promoteStudents();

        System.out.println("\nAfter processing:");
        manager.printStudents(manager.getStudents(), 1);
        manager.printStudents(manager.getStudents(), 2);
        manager.printStudents(manager.getStudents(), 3);
    }
}
