package com.xzy.interview;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_172 {

    public static void main(String[] args) {
        int n = 20;
        System.out.println(new LeetCode_172().trailingZeroes(n));
    }

    /**
     * 2*5->1个0
     */
    public int trailingZeroes(int n) {
        List<Integer> count = new ArrayList<>();
        count.add(0);
        for (int i = 1; i <= n; i++) {
            //int count_2 = countMod(i, 2);
            int count_5 = countMod(i, 5);
            count.add(count.getLast() + count_5);
        }
        return count.getLast();
    }

    private static int countMod(int num, int mod) {
        int count = 0;
        while (true) {
            if (num % mod == 0 && num % mod != num) {
                count++;
                num = num / mod;
            } else {
                break;
            }
        }
        return count;
    }
}
