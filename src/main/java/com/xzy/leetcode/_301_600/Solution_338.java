package com.xzy.leetcode._301_600;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiazhengyue
 * @since 2021-03-26
 */
public class Solution_338 {

    public static void main(String[] args) {
        System.out.println(JSON.toJSON(countBits(5)));
//        System.out.println(countOne(15));
    }

    /**
     * dp[0] = 0;
     * <p>
     * dp[1] = dp[1-1] + 1;
     * <p>
     * dp[2] = dp[2-2] + 1;
     * <p>
     * dp[3] = dp[3-2] +1;
     * <p>
     * dp[4] = dp[4-4] + 1;
     * <p>
     * dp[5] = dp[5-4] + 1;
     * <p>
     * dp[6] = dp[6-4] + 1;
     * <p>
     * dp[7] = dp[7-4] + 1;
     * <p>
     * dp[8] = dp[8-8] + 1;
     * <p>
     * dp[9] = dp[9-8] + 1;
     * <p>
     * 因此，dp[index] = dp[index - offset] + 1;()limit = 2^i(i表示index向下最大的2的n次幂)
     *
     * @param num
     * @return
     */
    public static int[] countBitsDP(int num) {
        int result[] = new int[num + 1];
        int offset = 1;
        for (int index = 1; index < num + 1; ++index) {
            if (offset * 2 == index) {
                offset *= 2;
            }
            result[index] = result[index - offset] + 1;
        }
        return result;
    }

    public static int[] countBits(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            list.add(countOne(i));
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int countOne(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }
}
