package com.xzy.demo;

import java.util.Random;

/**
 * User: RuzzZZ
 * Date: 2023/4/19
 * Time: 11:02
 */
public class FixedRandom {

    public static void main(String[] args) {
        Random random = new Random();
        long uid = 123456L;
        for (int i = 0; i < 100; i++) {
            random.setSeed(uid + i);
            System.out.printf(random.nextInt(30) + 70 + "\t");
        }
    }
}
