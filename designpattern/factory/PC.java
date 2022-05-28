package designpattern.factory;

public class PC extends Computer {

    private String ram;
    private String cpu;

    public PC(String ram, String cpu) {
        this.ram = ram;
        this.cpu = cpu;
    }

    @Override
    public void getRAM() {
        System.out.println("RAM: " + this.ram);
    }

    @Override
    public void getCPU() {
        System.out.println("CPU: " + this.cpu);
    }
}
