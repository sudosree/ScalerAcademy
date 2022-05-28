package interview.immutable;

import java.util.*;

public final class Student {
    private final int id;
    private final String name;
    private final Address address;
    private final List<Subject> subjects;
    private final Map<String, String> map;

    public Student(int id, String name, Address address, List<Subject> subjects,
                   Map<String, String> map) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.subjects = subjects;
        this.map = map;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<Subject> getSubjects() {
        return new ArrayList<>(subjects);
    }

    public Map<String, String> getMap() {
        return new HashMap<>(map);
    }
}
