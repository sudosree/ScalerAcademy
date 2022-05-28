package designpattern.singleton;

public class ModifySingleton {

    private static int count = 0;

    public ModifySingleton() throws Exception {
        count++;
        if (count > 5) {
            throw new Exception("Error creating instance. You can create only 5 instances" +
                    "of this class. You have exceeded the limit.");
        }
        System.out.println("Instance " + count + " is created");
    }

    public static void main(String[] args) throws Exception {
        ModifySingleton s1 = new ModifySingleton();
        System.out.println(s1);
        ModifySingleton s2 = new ModifySingleton();
        System.out.println(s2);
        ModifySingleton s3 = new ModifySingleton();
        System.out.println(s3);
        ModifySingleton s4 = new ModifySingleton();
        System.out.println(s4);
        ModifySingleton s5 = new ModifySingleton();
        System.out.println(s5);
        ModifySingleton s6 = new ModifySingleton();
        System.out.println(s6);
    }
}
