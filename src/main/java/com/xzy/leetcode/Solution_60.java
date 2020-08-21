package com.xzy.leetcode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author xiazhengyue
 * @since 2019-03-01
 */
public class Solution_60 {

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
        System.out.println(getPermutation(3, 2));
        System.out.println(getPermutation(4, 9));
    }

    public static String getPermutation(int n, int k) {
        List<Integer> dict = IntStream.range(1, n + 1).boxed().collect(Collectors.toList());
        return permutation(dict, n, k);
    }

    private static String permutation(List<Integer> dict, int n, int k) {
        if (dict.size() == 1) {
            return dict.get(0).toString();
        }
        String result = "";
        int index = --k / factorial(n - 1);
        result += dict.get(index);
        dict.remove(index);
        n--;
        return result += permutation(dict, n, k + 1 - index * (factorial(n)));
    }

    private static int factorial(int n) {
        switch (n) {
            case 0:
                return 1;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 6;
            case 4:
                return 24;
            case 5:
                return 120;
            case 6:
                return 720;
            case 7:
                return 5040;
            case 8:
                return 40320;
            case 9:
                return 362880;
            default:
                throw new IllegalArgumentException("n must less than 9 and more than 1!");
        }
    }
}
