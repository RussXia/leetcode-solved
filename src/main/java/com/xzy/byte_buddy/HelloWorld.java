package com.xzy.byte_buddy;

import lombok.Data;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.NamingStrategy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author xiazhengyue
 * @since 2021-03-25
 */
public class HelloWorld {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

//        helloWorld();

        customNameStrategy();
    }

    private static void customNameStrategy() {
        HelloWorld helloWorld = new HelloWorld();
        ByteBuddy byteBuddy = new ByteBuddy();
        byteBuddy.with(new NamingStrategy.SuffixingRandom("suffix"));
        DynamicType.Unloaded<?> dynamicType = byteBuddy.subclass(Student.class).make();

        Class<?> studentClazz = dynamicType.load(helloWorld.getClass().getClassLoader())
                .getLoaded();
        System.out.println(studentClazz.getName());
    }

    private static void helloWorld() throws IllegalAccessException, InstantiationException {
        HelloWorld helloWorld = new HelloWorld();
        Class<?> dynamicType = new ByteBuddy()
                .subclass(Student.class)
//                .name("com.xzy.byte_buddy.HelloWorld$Student$Dynamic")
                .method(ElementMatchers.named("toString"))
                .intercept(FixedValue.value("Hello World!"))
                .method(ElementMatchers.named("getName"))
                .intercept(FixedValue.value("Hello World1111!"))
                .make()
                .load(helloWorld.getClass().getClassLoader())
                .getLoaded();

        Student studentA = (Student) dynamicType.newInstance();
        System.out.println(studentA.toString());
        System.out.println(studentA.getName());
        System.out.println(studentA.getClass().getName());

        System.out.println();

        Student studentB = new Student();
        System.out.println(studentB.toString());
        System.out.println(studentB.getName());
        System.out.println(studentB.getClass().getName());
    }

    @Data
    public static class Student {
        private String name;
        private String age;
    }
}
