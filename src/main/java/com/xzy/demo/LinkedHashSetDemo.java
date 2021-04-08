package com.xzy.demo;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @author xiazhengyue
 * @since 2021-04-06
 */
public class LinkedHashSetDemo {

    public static void main(String[] args) {
//        HashSet<Integer> set = new LinkedHashSet<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(10);
        set.add(9);
        set.add(22);
        set.add(8);
        set.add(31);

        set.forEach(System.out::println);

    }
}
