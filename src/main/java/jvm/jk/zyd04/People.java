package jvm.jk.zyd04;


/**
 * Java 虚拟机识别方法的关键在于类名、方法名以及方法描述符（method descriptor）。
 * 前面两个就不做过多的解释了。至于方法描述符，它是由方法的参数类型以及返回类型所构成。
 *
 * Java 虚拟机中关于方法重写的判定同样基于方法描述符。
 * 也就是说，如果子类定义了与父类中非私有、非静态方法同名的方法，
 * 那么只有当这两个方法的参数类型以及返回类型一致，Java 虚拟机才会判定为重写。
 * 对于 Java 语言中重写而 Java 虚拟机中非重写的情况，
 * 编译器会通过生成桥接方法[2]来实现 Java 中的重写语义。
 *
 *
 *
 * invokestatic：用于调用静态方法。
 * invokespecial：用于调用私有实例方法、构造器，以及使用 super 关键字调用父类的实例方法或构造器，
 * 和所实现接口的默认方法。
 * invokevirtual：用于调用非私有实例方法。
 * invokeinterface：用于调用接口方法。
 * invokedynamic：用于调用动态方法。
 */
public class People {
    public Number getAge(String name, String idcard) {
        return 2;
    }
}

class Student extends People{
    @Override
    public Double getAge(String name, String idcard) {
        return 3.0;
    }
}



