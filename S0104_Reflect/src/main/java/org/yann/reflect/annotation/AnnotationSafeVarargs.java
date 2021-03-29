package org.yann.reflect.annotation;

public class AnnotationSafeVarargs<T> {

    private T[] args;

    @SafeVarargs//用于可变个数参数，不能用于fixed arity
    public AnnotationSafeVarargs(T ...args) {
        this.args = args;
    }

    //@SafeVarargs，非static或final方法
    @SuppressWarnings("unchecked")
    public void loopArgs(T ...args) {
        for (T arg : args) {
            System.out.println(arg);
        }
    }

    @SafeVarargs
    public final void loopArgsFinal(T ...args) {
        for (T arg : args) {
            System.out.println(arg);
        }
    }

    @SafeVarargs
    public static<T> void loopArgsStatic(T ...args) {
        for (T arg : args) {
            System.out.println(arg);
        }
    }


}
