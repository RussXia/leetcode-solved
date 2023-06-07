package com.xzy.leetcode._1201_2000;

/**
 * User: RuzzZZ
 * Date: 2023/6/7
 * Time: 17:22
 */
public class Solution_1318 {

    public static void main(String[] args) {
        Solution_1318 solution1318 = new Solution_1318();
        System.out.println(solution1318.minFlips(2, 6, 5));
        System.out.println(solution1318.minFlips(4, 2, 7));
        System.out.println(solution1318.minFlips(1, 2, 3));
    }

    public int minFlips(int a, int b, int c) {
        int flip = 0;
        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;
            if ((c & mask) != 0) {
                if (((b & mask) | (a & mask)) == 0) {
                    flip++;
                }
            } else {
                if ((a & mask) != 0) flip++;
                if ((b & mask) != 0) flip++;
            }
        }
        return flip;
    }
}
