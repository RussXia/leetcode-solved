package com.xzy.algorithm;

/**
 * User: RuzzZZ
 * Date: 2024/4/19
 * Time: 17:04
 */
public class Lesson10_2 {


    private static int totalNumberForMoney(int[] moneyKind, int total) {
        //初始化 c数组
        int[] c = new int[total + 1];
        for (int i = 1; i <= total; i++) {
            for (int money : moneyKind) {
                if (money > i || (i + money) > 100) {
                    continue;
                }
                // c[i+money]==0 表示尚未初始化
                c[i + money] = c[i + money] == 0 ? (c[i] + 1) : Math.min(c[i + money], c[i] + 1);
            }
        }
        return c[total];
    }


    public static void main(String[] args) {
        int[] c = new int[]{2, 3, 7};
        System.out.println(totalNumberForMoney(c, 100));
    }
}