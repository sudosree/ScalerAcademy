package designprinciple.dependencyinversion.right;

public class Windows98Machine {
    private Keyboard keyboard;
    private Monitor monitor;

    public Windows98Machine(Keyboard keyboard, Monitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
    }
}
