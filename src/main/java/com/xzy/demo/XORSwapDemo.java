package com.xzy.demo;

/**
 * User: RuzzZZ
 * Date: 2024/4/16
 * Time: 14:49
 */
public class XORSwapDemo {

    public static void main(String[] args) {
        int a = 32323;
        int b = 222333;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }
}
