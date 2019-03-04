package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2019-02-28
 */
public class BrokenCalculator991 {

    public static void main(String[] args) {
        System.out.println(brokenCalc(2, 3));
        System.out.println(brokenCalc(5, 8));
        System.out.println(brokenCalc(3, 10));
        System.out.println(brokenCalc(1024, 1));
        System.out.println(brokenCalc(100, 100));
        System.out.println(brokenCalc(1000000000, 1));
    }

    public static int brokenCalc(int X, int Y) {
        int calcTimes = 0;
        if (X > Y) {
            return X - Y;
        } else if (X < Y) {
            if (Y % 2 == 0) {
                calcTimes++;
                calcTimes += brokenCalc(X, Y / 2);
            } else {
                calcTimes += 2;
                calcTimes += brokenCalc(X, (Y + 1) / 2);
            }
        }
        return calcTimes;
    }
}
