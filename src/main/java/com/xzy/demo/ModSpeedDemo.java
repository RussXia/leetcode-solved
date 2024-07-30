package com.xzy.demo;

/**
 * User: RuzzZZ
 * Date: 2024/4/16
 * Time: 14:38
 */
public class ModSpeedDemo {

    public static void main(String[] args) {
        long times = 10_000_000_000L;
        long start = System.currentTimeMillis();
        int count1 = 0;
        for (long i = 0; i < times; i++) {
            if ((i & 1) == 0) {
                count1++;
            }
        }
        System.out.println("count:" + count1);
        System.out.println(System.currentTimeMillis() - start);

        System.out.println("--------------------------------------------");

        start = System.currentTimeMillis();
        int count2 = 0;
        for (long i = 0; i < times; i++) {
            if ((i % 2) == 0) {
                count2++;
            }
        }
        System.out.println("count:" + count2);
        System.out.println(System.currentTimeMillis() - start);
    }
}
