package interview;

public class Dog extends Animal {

    private String color;

    Dog(String color){
        this.color = color;
    }

    @Override
    public void walk() {
        System.out.println("Dog walks");
    }

    @Override
    public void makeSound() {

    }
}
