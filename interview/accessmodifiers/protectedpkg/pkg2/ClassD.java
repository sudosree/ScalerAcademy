package interview.accessmodifiers.protectedpkg.pkg2;

import interview.accessmodifiers.protectedpkg.pkg1.ClassA;

public class ClassD extends ClassA {

    public void test() {
        ClassA.print();
    }
}
