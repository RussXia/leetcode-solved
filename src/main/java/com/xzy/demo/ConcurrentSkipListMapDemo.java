package com.xzy.demo;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author xiazhengyue
 * @since 2021-04-13
 */
public class ConcurrentSkipListMapDemo {

    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer, String> concurrentSkipListMap = new ConcurrentSkipListMap<>();
        for (int i = 1; i <= 2; i++) {
            concurrentSkipListMap.put(2 * i - 1, "Test1");
        }
        System.out.println(concurrentSkipListMap.get(9));

    }
}
