package com.xzy.demo;

import com.xzy.common.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author xiazhengyue
 * @since 2021-04-06
 */
public class GenericsDemo {
    public static void main(String[] args) throws Exception {

        Class<Person> clazz = Person.class;
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class, int.class);
        Person person = constructor.newInstance("test1", 3);

        Method setNameMethod = clazz.getDeclaredMethod("setName", String.class);
        setNameMethod.setAccessible(true);
        setNameMethod.invoke(person, "hello");

        System.out.println(person);

        System.out.println(setNameMethod.getModifiers());
        System.out.println(Modifier.isPrivate(setNameMethod.getModifiers()));
        System.out.println(Modifier.isPublic(setNameMethod.getModifiers()));
    }

}
