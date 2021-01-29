package org.yann.reflect.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnotationRepeatable {

    @Value("Hello")
    public String v0;

    @Value("World")
    public String v1;

    //@Values({"Hello", "Repeatable", "Annotation"})
    @Value("Hello")
    @Value("Repeatable")
    @Value("Annotation")
    public String values;

    //没有@Repeatable注解之前，重复使用一个注解的写法。
    @Values({
            @Value("Hello"),
            @Value("Repeatable"),
            @Value("Annotation")
    })
    public String oldValues;

    public static void main(String[] args) throws NoSuchFieldException {
        Class clazz = AnnotationRepeatable.class;
        Field field0 = clazz.getField("v0");
        Annotation[] annotations0 = field0.getAnnotations();
        for (Annotation annotation0 : annotations0) {
            System.out.println(annotation0);
        }

        Field valuesField = clazz.getField("values");
        Annotation[] valuesFieldAnnotations = valuesField.getAnnotations();
        for (Annotation valuesFieldAnnotation : valuesFieldAnnotations) {
            System.out.println(valuesFieldAnnotation);
        }
    }

}
