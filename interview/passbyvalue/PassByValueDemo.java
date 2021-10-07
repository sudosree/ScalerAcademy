package interview.passbyvalue;

public class PassByValueDemo {

    static class Dog {
        String name;

        Dog(String name) {
            this.name = name;
        }
    }

    private static void foo(Dog someDog) {
        System.out.println("Inside foo method:");
        System.out.println(someDog.name);   // Max
        someDog = new Dog("Tommy");
//        someDog.name = "Tommy";
        System.out.println(someDog.name);   // Tommy
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Max");
        System.out.println(dog.name);   // Max
        foo(dog);
        System.out.println(dog.name);   // Tommy
    }
}
