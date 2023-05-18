package com.xzy.leetcode._601_900;

/**
 * User: RuzzZZ
 * Date: 2023/5/17
 * Time: 15:16
 */
public class Solution_779 {

    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        if (k % 2 == 0)
            return flip(kthGrammar(n - 1, k / 2));
        else
            return kthGrammar(n - 1, (k + 1) / 2);
    }

    private int flip(int flip) {
        return flip == 0 ? 1 : 0;
    }


}
