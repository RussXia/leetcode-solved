package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2021-03-29
 */
public class Solution_605 {

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1, 0, 0};
        System.out.println(canPlaceFlowers(flowerbed, 2));

    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 0 && (flowerbed.length == (i + 1) || flowerbed[i + 1] == 0)) {
                n--;
                i++;
            } else if (flowerbed[i] == 1) {
                i++;
            }
        }
        return n == 0;
    }
}
