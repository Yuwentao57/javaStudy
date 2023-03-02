package jvm.basic.dir1;

public class Generic <T>{
    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    /**
     *
     * @param tGeneric
     * @param <>
     * @return T 返回值为T类型
     *
     *  1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *  2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *  3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *  4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public <U> U showKey(Generic<U> tGeneric) {
        System.out.println(tGeneric.getKey());
        U t = tGeneric.getKey();
        return t;
    }

    /**
     * 不是泛型方法
     * @param generic
     * @return
     */
    public T reshow(Generic<T> generic) {
        return generic.getKey();
    }

    public static <U> void show(Generic<U> generic) {
        System.out.println(generic.getKey());
    }


    public <T, U> T addTwo(Generic<U> generic) {
        return (T)generic.getKey();
    }
}
