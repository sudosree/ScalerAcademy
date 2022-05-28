package designprinciple.dependencyinversion.wrong;

public class Windows98Machine {
    private StandardKeyboard keyboard;
    private Monitor monitor;

    public Windows98Machine(StandardKeyboard keyboard, Monitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
    }
}
