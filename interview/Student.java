package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Student {
    private final int rollNo;
    private final String name;
    private final List<String> subjects;
    private final HashMap<String, String> map;

    public Student(int rollNo, String name, List<String> subjects, HashMap<String, String> map) {
        this.rollNo = rollNo;
        this.name = name;
        this.subjects = subjects;
        this.map = map;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public List<String> getSubjects() {
//        return subjects;
        return new ArrayList<>(subjects);
    }

    public HashMap<String, String> getMap() {
//        return map;
        return (HashMap<String, String>) map.clone();
    }

    public static void main(String[] args) {
        List<String> subjects = new ArrayList<>();
        subjects.add("English");
        subjects.add("Math");
        subjects.add("Science");
        subjects.add("Computer Science");
        subjects.add("Algorithms");

        HashMap<String, String> map = new HashMap<>();
        map.put("1", "first");
        map.put("2", "second");
        map.put("3", "third");

        Student s1 = new Student(21, "Alice", subjects, map);
//        Student s2 = new Student(30, "Bob", subjects);
//        Student s3 = new Student(25, "Charlie", subjects);
        System.out.println("Before Value");
        System.out.println("Roll No: " + s1.rollNo);
        System.out.println("Name: " + s1.name);
        System.out.println("Subjects: " + s1.getSubjects());
        System.out.println("Map: " + s1.getMap());

        System.out.println("After Value");
        List<String> subjects1 = s1.getSubjects();
        subjects1.add("Data Structure");
        Map<String, String> map1 = s1.getMap();
        map1.put("4", "fourth");
        System.out.println("Subjects: " + s1.getSubjects());
        System.out.println("Map: " + s1.getMap());

        Student s2 = new Student(30, "Bob", subjects, map);
        Student s3 = new Student(20, "Charlie", subjects, map);
        Student s4 = new Student(30, "Bob", subjects, map);
        List<Student> students = new ArrayList<>();

    }
}
