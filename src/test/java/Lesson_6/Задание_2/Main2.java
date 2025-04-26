package src.test.java.Lesson_6.Задание_2;

import java.util.*;

class PhoneDirectory {
    private Map<String, List<String>> directory;

    public PhoneDirectory() {
        this.directory = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        directory.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> get(String lastName) {
        return directory.getOrDefault(lastName, Collections.emptyList());
    }
}

public class Main2 {
    public static void main(String[] args) {
        PhoneDirectory directory = new PhoneDirectory();

        directory.add("Ivanov", "123-456");
        directory.add("Petrov", "789-012");
        directory.add("Ivanov", "345-678");
        directory.add("Sidorov", "901-234");

        System.out.println("Ivanov's phones: " + directory.get("Ivanov"));
        System.out.println("Petrov's phones: " + directory.get("Petrov"));
        System.out.println("Non-existent name: " + directory.get("Kuznetsov"));
    }
}
