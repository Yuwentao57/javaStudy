package jvm.basic.dir1;

public class Test <T> implements GenericInterface<T> {
    @Override
    public T next() {
        return null;
    }

    public static void main(String[] args) {
        Test<String> test = new Test<>();
         boolean v = test.next() == null;
        System.out.println(v);
    }
}
