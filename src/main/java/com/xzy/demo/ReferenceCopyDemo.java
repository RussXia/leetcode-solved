package com.xzy.demo;

import java.util.List;

/**
 * @author xiazhengyue
 * @since 2021-04-20
 */
public class ReferenceCopyDemo {

    public static void main(String[] args) {
        Integer a1 = 222;
        Integer a2 = 333;
        test(a1, a2);
        System.out.println(a1);
        System.out.println(a2);
    }

    public static void test(Integer a1, Integer a2) {
        a1 = a2;
        a2 = 888;
    }

    public static void test2(List<Integer> list) {
        list.add(3);
    }
}
