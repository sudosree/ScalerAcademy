package designpattern.singleton;

public enum SingletonEnum {
    INSTANCE("Info");

    private String info;

    SingletonEnum(String info) {
        this.info = info;
    }

    public SingletonEnum getInstance() {
        return INSTANCE;
    }
}
