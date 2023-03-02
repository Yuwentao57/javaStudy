package jvm.basic.dir1;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型，参考https://www.cnblogs.com/coprince/p/8603492.html
 * @param <T>
 */
public class Test <T> implements GenericInterface<T> {
    @Override
    public T next() {
        return null;
    }

    public static void main(String[] args) {
        Test<String> test = new Test<>();
         boolean v = test.next() == null;
        System.out.println(v);

        Generic<Integer> g1 = new Generic<>(5);
        Generic<Number> g2 = new Generic<>(6);
//        test.next(g1); Exception
        test.show(g2);

        Generic<Integer> generic = new Generic<>(8);
        generic.showKey(generic);
        generic.reshow(generic);

        generic.showKey(g2);

        Integer integer = generic.addTwo(g2);
        System.out.println(integer);

//        List<String>[] ls1 = new ArrayList<String>[10];

        List<?>[] ls2 = new ArrayList<?>[10];

    }

/*    public void show(Generic<Number> generic) {
        System.out.println(generic);
    }*/

    /**
     * 使用通配符
     * @param generic
     */
    public void show(Generic<?> generic) {
        System.out.println(generic.getKey());
    }





}
