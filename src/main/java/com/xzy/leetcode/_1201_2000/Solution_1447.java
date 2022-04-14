package com.xzy.leetcode._1201_2000;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: RuzzZZ
 * Date: 2022/2/10
 * Time: 10:48
 */
public class Solution_1447 {


    public List<String> simplifiedFractions(int n) {
        Set<String> fractions = new HashSet<>();
        for (int i = 2; i <= n; i++) {  //分母
            for (int j = 1; j < i; j++) {   //分子
                int gcd = gcd(i, j);
                fractions.add((j / gcd) + "/" + (i / gcd));
            }
        }
        return new ArrayList<>(fractions);
    }


    /**
     * 最大公约数;(欧几里得算法)
     */
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
