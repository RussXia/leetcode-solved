package com.xzy.leetcode;

import java.util.Arrays;

/**
 * @author xiazhengyue
 * @since 2021-03-29
 */
public class Solution_455 {

    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int satisfied = 0;

        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
            if (g[i] <= s[j]) {
                satisfied++;
                i++;
                j++;
                continue;
            }
            j++;
        }
        return satisfied;
    }
}
