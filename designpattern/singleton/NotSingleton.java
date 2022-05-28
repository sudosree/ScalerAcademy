package designpattern.singleton;

public class NotSingleton {

    public NotSingleton() {
        System.out.println("Not Singleton");
    }

    public static void main(String[] args) {
        NotSingleton s1 = new NotSingleton();
        System.out.println(s1);
        NotSingleton s2 = new NotSingleton();
        System.out.println(s2);
    }
}
