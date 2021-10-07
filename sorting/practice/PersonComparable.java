package sorting.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonComparable implements Comparable <PersonComparable> {

    private String name;
    private int age;

    PersonComparable(String name, int age) {
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
    public int compareTo(PersonComparable p) {
        if (this.age == p.getAge()) {
            return 0;
        }
        return this.age < p.getAge() ? -1 : 1;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        PersonComparable person1 = new PersonComparable("Sree", 26);
        PersonComparable person2 = new PersonComparable("Sourav", 24);
        PersonComparable person3 = new PersonComparable("Alex", 34);
        PersonComparable person4 = new PersonComparable("Lizzy", 21);

        List<PersonComparable> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);

        System.out.println("Before Sorting: " + persons);
        Collections.sort(persons);
        System.out.println("After Sorting: " + persons);
    }
}
