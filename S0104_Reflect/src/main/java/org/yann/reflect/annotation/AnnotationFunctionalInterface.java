package org.yann.reflect.annotation;

@FunctionalInterface
public interface AnnotationFunctionalInterface {
    //常用的接口Callable、Runnable、Comparator都有此注解
    //1.只能用在有且只有一个抽象方法的接口上。exactly one
    //2.JDK8 接口中的默认方法和静态方法，都不算抽象方法。
    //3.接口默认继承java.lang.Object，如果接口中显示覆盖了Object中的方法，那也不算抽象方法。
    //4.该接口不是必须的，如果一个接口符合“函数式接口”的定义，那么加不加注解都没有影响。
        //如果不是“函数式接口”加上此注解，编译器会报错。

    public void abstractMethod();
    //public void abstractMethod2();

    default void defaultMethod() {
        System.out.println("default method");
    }

    static String returnString() {
        return "balabala";
    }

}
