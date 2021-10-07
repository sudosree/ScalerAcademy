package sorting.practice;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Person p1 = new Person("Sree", 26);
        Person p2 = new Person("Sourav", 24);
        Person p3 = new Person("Alex", 34);
        Person p4 = new Person("Lizzy", 21);

        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);

        System.out.println("Before Sorting: " + persons);
        Collections.sort(persons, new PersonComparatorByName());
        System.out.println("After Sorting: " + persons);
    }
}
