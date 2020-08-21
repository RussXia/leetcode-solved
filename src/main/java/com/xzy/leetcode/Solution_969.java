package com.xzy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiazhengyue
 * @since 2019-02-28
 */
public class Solution_969 {

    public static void main(String[] args) {
        int[] A = {3, 2, 4, 1};
        System.out.println(pancakeSort(A));
        int[] B = {1, 2, 3};
        System.out.println(pancakeSort(B));
        int[] C = {1, 2};
        System.out.println(pancakeSort(C));
        int[] D = {1};
        System.out.println(pancakeSort(D));
    }

    public static List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int x = A.length, i; x > 0; --x) {
            for (i = 0; A[i] != x; ++i) ;
            reverse(A, i + 1);
            res.add(i + 1);
            reverse(A, x);
            res.add(x);
        }
        return res;
    }

    public static void reverse(int[] A, int k) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }

}
