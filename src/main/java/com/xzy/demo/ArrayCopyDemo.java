package com.xzy.demo;

import com.xzy.common.Person;

/**
 * @author xiazhengyue
 * @since 2021-04-06
 */
public class ArrayCopyDemo {

    public static void main(String[] args) {
        test2();
    }

    private static void test1() {
        String[] st = {"A", "B", "C", "D", "E"};
        String[] dt = new String[5];
        System.arraycopy(st, 0, dt, 0, 5);

        //改变dt的值
        dt[3] = "M";
        dt[4] = "V";

        System.out.println("两个数组地址是否相同：" + (st == dt)); //false

        for (String str : st) {
            System.out.print(" " + str + " ");   // A  B  C  D  E

        }
        System.out.println();
        for (String str : dt) {
            System.out.print(" " + str + " ");   // A  B  C  M  V
        }
    }

    private static void test2() {
        Person[] source = {new Person("hhh", 1), new Person("qqq", 2), new Person("eee", 3)};
        Person[] target = new Person[3];
        System.arraycopy(source, 0, target, 0, 3);

        System.out.println(source == target);

//        source[0].setName("HelloWorld");
        target[0].setName("HelloWorld");

        System.out.println(source[0]);
        System.out.println(target[0]);

    }
}
