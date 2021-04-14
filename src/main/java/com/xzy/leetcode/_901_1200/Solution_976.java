package com.xzy.leetcode._901_1200;

import java.util.Arrays;

/**
 * @author xiazhengyue
 * @since 2019-01-24
 */
public class Solution_976 {

    public static void main(String[] args) {
//        int[] array = {3, 6, 2, 3};
        int[] array = {3,2,3,4};
//        int[] array = {1,2,1};
        System.out.println(largestPerimeter(array));
    }

    public static int largestPerimeter(int[] A) {
        if (A.length < 3)
            return 0;
        Arrays.sort(A);
        for (int i = A.length - 1; i > 1; i--) {
            int integerA = A[i];
            int integerB = A[i - 1];
            int integerC = A[i - 2];
            if (integerB + integerC > integerA) {
                return integerA + integerB + integerC;
            }
        }
        return 0;
    }
}
