package interview.accessmodifiers.defaultpkg.pkg2;

import interview.accessmodifiers.defaultpkg.pkg1.ClassB;

public class ClassC {
    public void print() {
        ClassB.print();
    }
}
