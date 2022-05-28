package interview.immutable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestStudent {

    public static void main(String[] args) {
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("1001", "English"));
        subjects.add(new Subject("1002", "Physics"));
        subjects.add(new Subject("1003", "Maths"));
        subjects.add(new Subject("1004", "Biology"));

        Address address = new Address("Kolkata", "West Bengal", "Newtown");

        Map<String, String> map = new HashMap<>();
        map.put("key1", "val1");
        map.put("key2", "val2");
        map.put("key3", "val3");

        /* Original values */
        Student student1 = new Student(1, "Akash", address, subjects, map);
        System.out.println("ID: " + student1.getId());
        System.out.println("Name: " + student1.getName());
        Address student1Address = student1.getAddress();
        System.out.println("City: " + student1Address.getCity());
        System.out.println("State: " + student1Address.getState());
        System.out.println("Street: " + student1Address.getStreet());
        List<Subject> student1Subjects = student1.getSubjects();
        for (Subject subject : student1Subjects) {
            System.out.println("Subject ID: " + subject.getId());
            System.out.println("Subject Name: " + subject.getName());
        }
        Map<String, String> map1 = student1.getMap();
        for (String k : map1.keySet()) {
            System.out.println("Key: " + k + " Value: " + map1.get(k));
        }

        /* After changing values */
        System.out.println();
        System.out.println("After changing values");
        student1Subjects.add(new Subject("1005", "Chemistry"));
        List<Subject> changeSubjects = student1.getSubjects();
        for (Subject subject : changeSubjects) {
            System.out.println("Subject ID: " + subject.getId());
            System.out.println("Subject Name: " + subject.getName());
        }
        map1.put("key4", "val4");
        Map<String, String> changeMap = student1.getMap();
        for (String k : changeMap.keySet()) {
            System.out.println("Key: " + k + " Value: " + map1.get(k));
        }
    }
}
