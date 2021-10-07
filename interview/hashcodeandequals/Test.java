package interview.hashcodeandequals;

public class Test {

    public static void main(String[] args) {
        Person p = new Person("Sreemoyee", "Chowdhury", 27);
        Person q = new Person("Sreemoyee", "Chowdhury", 27);
        System.out.println(p.equals(q));
        System.out.println("Hashcode p: " + p.hashCode());
        System.out.println("Hashcode q: " + q.hashCode());
    }
}
