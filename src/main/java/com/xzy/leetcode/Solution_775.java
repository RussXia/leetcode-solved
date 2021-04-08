package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2021-04-06
 */
public class Solution_775 {

    public static void main(String[] args) {
        int[] A = {2,0,3,1};
        System.out.println(isIdealPermutation2(A));
    }

    public static boolean isIdealPermutation(int[] A) {
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] > A[i] && A[i - 1] > A[i + 1]) {
                return false;
            }
            if (A[i + 1] < A[i] && A[i + 1] < A[i - 1])
                return false;
        }
        return true;
    }


    public static boolean isIdealPermutation2(int[] A) {
        int cmax = 0;
        for (int i = 0; i < A.length - 2; ++i) {
            cmax = Math.max(cmax, A[i]);
            if (cmax > A[i + 2]) return false;
        }
        return true;
    }
}
