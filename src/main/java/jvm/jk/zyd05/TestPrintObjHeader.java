package jvm.jk.zyd05;

import org.openjdk.jol.info.ClassLayout;

public class TestPrintObjHeader {
    public static void main(String[] args) {
        InnerL l = new InnerL();
        int[] a = new int[8];
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }
}


class InnerL{
    private boolean b = true;
}