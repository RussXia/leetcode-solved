package com.xzy.demo;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiazhengyue
 * @since 2021-04-12
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 4096; i++) {
            map.put("HelloWorld" + i, "HelloWorld" + i);
        }
        System.out.println(map.size());
    }
}
