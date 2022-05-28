package designpattern.factory;

public class Server extends Computer {

    private String ram;
    private String cpu;

    public Server(String ram, String cpu) {
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
