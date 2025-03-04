package com.xzy.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSquareSum {

    public static void main(String[] args) {
        System.out.println(findMinSquares(20));
    }

    public static List<Integer> findMinSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        // 找出需要的个数
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        // 找出实际的解
        List<Integer> result = new ArrayList<>();
        int current = n;    // 当前平方数剩余
        while (current > 0) {
            int maxSqrt = (int) Math.sqrt(current);
            for (int i = maxSqrt; i >= 1; i--) {
                if (dp[current] == dp[current - i * i] + 1) {
                    result.add(i * i);
                    current -= i * i;
                    break;
                }
            }
        }
        return result;
    }

}
