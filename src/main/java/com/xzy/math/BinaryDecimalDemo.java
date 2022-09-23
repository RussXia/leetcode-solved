package com.xzy.math;

import java.math.BigInteger;

/**
 * User: RuzzZZ
 * Date: 2022/8/9
 * Time: 16:58
 */
public class BinaryDecimalDemo {


    public static String decimalToBinary(int decimalSource) {
        BigInteger bi = new BigInteger(String.valueOf(decimalSource)); //转换成BigInteger类型，默认是十进制
        return bi.toString(2); //参数2指定的是转化成二进制
    }

    public static int binaryToDecimal(String binarySource) {
        BigInteger bi = new BigInteger(binarySource, 2);  //转换为BigInteger类型，参数2指定的是二进制
        return Integer.parseInt(bi.toString());     //默认转换成十进制
    }


    public static void main(String[] args) {
        //int a = 53;
        //String b = "110101";
        //获取十进制数53的二进制数
        //System.out.printf("数字%d的二进制是%s%n", a, BinaryDecimalDemo.decimalToBinary(a));
        //获取二进制数110101的十进制数
        //System.out.printf("数字%s的十进制是%d%n", b, BinaryDecimalDemo.binaryToDecimal(b));
        //System.out.println(a << 1);
        //System.out.println(BinaryDecimalDemo.decimalToBinary(-2));
        //System.out.println(BinaryDecimalDemo.decimalToBinary(-3));
        //System.out.println(-2 >> 1);


        //System.out.println(-2 >>> 1);
        //System.out.println(BinaryDecimalDemo.decimalToBinary(2147483647));

        System.out.println(-4 >> 1);
        System.out.println(-1 >>> 1);

        System.out.println((-3) << 14);
        System.out.println(((-3) << 10) << 4);

        System.out.println();
        System.out.println(((-3) << 30));
        System.out.println((-3) << 31);

        System.out.println((-3) << 33);

        System.out.println((-3) << 32);
        System.out.println(((-3) << 30) << 2);

        //System.out.println(-3 << 31);
        //System.out.println(-3 << 30);
        //System.out.println(-3 << 29);

        //System.out.println();
        //System.out.println(1 << 4);
        //System.out.println((1 << 2) << 2);
    }
}
